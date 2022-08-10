package ru.stolyarchuk;

import ru.stolyarchuk.persist.Product;
import ru.stolyarchuk.persist.ProductRepositiry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    private ProductRepositiry productRepositiry;

    @Override
    public void init() throws ServletException {
        this.productRepositiry = new ProductRepositiry();
        this.productRepositiry.insert(new Product("Apple"));
        this.productRepositiry.insert(new Product("Apple1"));
        this.productRepositiry.insert(new Product("Apple2"));
        this.productRepositiry.insert(new Product("Apple3"));
        this.productRepositiry.insert(new Product("Apple4"));
        this.productRepositiry.insert(new Product("Apple5"));
        this.productRepositiry.insert(new Product("Apple6"));
        this.productRepositiry.insert(new Product("Apple7"));
        this.productRepositiry.insert(new Product("Apple8"));
        this.productRepositiry.insert(new Product("Apple9"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<th> id </th>");
        writer.println("<th> productname </th>");
        writer.println("</tr>");


        for (Product product : productRepositiry.findAll()) {
            writer.println("<tr>");
            writer.println("<td>" + product.getId() + "</td>");
            writer.println("<td>" + product.getProductName() + "</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");

    }
}
