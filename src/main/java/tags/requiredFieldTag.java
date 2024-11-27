/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ccull
 * this tag will not be used, a java script function has replaced it's purpose
 * code will still be included in the project to align with class requirements
 */
public class requiredFieldTag extends SimpleTagSupport {
    private String value;          // Use lowercase for variable naming

    public void setValue(String value) {
        this.value = value;
    }



    @Override
    public void doTag() throws JspException, IOException {
        // Show asterisk only if the field is empty and the form is submitted
        // Display the asterisk only if the form is submitted and the value is empty ||
        // if (value == null || value.trim().isEmpty()) {
        //     getJspContext().getOut().write("<span style='color: red;'>*</span>");
        // }
    }
}