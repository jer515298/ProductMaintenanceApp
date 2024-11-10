package music.data;

import music.business.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDB {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("music_jpa");

    // Method to get a list of all products
    public static List<Product> getProducts() {
        EntityManager em = emf.createEntityManager();
        String query = "SELECT p FROM Product p";
        TypedQuery<Product> tq = em.createQuery(query, Product.class);
        List<Product> products = null;
        try {
            products = tq.getResultList();
        } finally {
            em.close();
        }
        return products;
    }

    // Method to add a new product
    public static void addProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(product);
            transaction.commit();
        } finally {
            em.close();
        }
    }

    // Method to update an existing product
    public static void updateProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(product);
            transaction.commit();
        } finally {
            em.close();
        }
    }

    // Method to delete a product by code
    public static void deleteProduct(String code) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Product product = selectProduct(code);
            if (product != null) {
                em.remove(em.contains(product) ? product : em.merge(product));
            }
            transaction.commit();
        } finally {
            em.close();
        }
    }

    // Method to retrieve a single product by code
    public static Product selectProduct(String code) {
        EntityManager em = emf.createEntityManager();
        String query = "SELECT p FROM Product p WHERE p.code = :code";
        TypedQuery<Product> tq = em.createQuery(query, Product.class);
        tq.setParameter("code", code);
        Product product = null;
        try {
            product = tq.getSingleResult();
        } finally {
            em.close();
        }
        return product;
    }
}
