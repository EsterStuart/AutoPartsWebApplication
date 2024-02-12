package org.team.autopartswebapplication;


import Business.Cart;
import Business.PartOrder;
import Business.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddProductToCartServlet", value = "/add-product-to-cart-servlet")
public class AddProductToCartServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        String productID = request.getParameter("ProductID");
        int quantity = Integer.parseInt(request.getParameter("OrderQuantity"));

        Cart cart;
        if(null != session.getAttribute("UserCart")){
            cart = (Cart) session.getAttribute("UserCart");
            System.out.println("CART ALREADY IN SESSION");
        } else {
            cart = new Cart();
            System.out.println("CART NOT IN SESSION ==========");
        }

        Product product = new Product();
        product.selectDB(productID);

        PartOrder partOrder = new PartOrder();
        partOrder.setPart(product);
        partOrder.setQuantity(quantity);
        partOrder.setTotalOrderPrice(partOrder.getTotalPrice());

        cart.addPartOrderToCart(partOrder);


        /*

        ArrayList<Product> productsArrayList = new ArrayList<Product>();

        if (partType != null){
            if (carType != null) {
                productsArrayList = product.getAllProductsFilterBy(partType, Product.getCarType(carType));
            } else {
                productsArrayList = Product.getAllProductsFilterBy(partType);
            }
        } else if (carType != null) {
            productsArrayList = product.getAllProductsFilterBy(Product.getCarType(carType));
        }


        */

        //session.setAttribute("ArrayOfFilteredProducts", productsArrayList);
        session.setAttribute("UserCart", cart);

        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/products.jsp");
        //requestDispatcher.forward(request, response);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    public void destroy() {
    }

}
