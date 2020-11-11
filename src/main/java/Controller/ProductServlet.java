package Controller;

import Model.Product;
import Service.ConnectDB;
import Service.IProductService;
import Service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "ProductServlet",urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        switch (action){
            case "create":
                createNewProduct(request,response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            default:
                showProduct(request,response);
        }
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) {
        ProductService service = new ProductService();

        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String desc = request.getParameter("desc");
        String category = request.getParameter("category");
        service.addNewProduct(new Product(name,price,color,desc,category));

        showProduct(request,response);
    }
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        ProductService service = new ProductService();
        int id = Integer.parseInt(request.getParameter("id"));
        boolean rs = service.deleteProduct(id);
        if (rs){
            request.setAttribute("message", "delete success!");
        }
        showProduct(request,response);
    }
    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        ProductService service = new ProductService();
        int id = Integer.parseInt(request.getParameter("id"));
        boolean rs = service.deleteProduct(id);
        if (rs){
            request.setAttribute("message", "delete success!");
        }
        showProduct(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        switch (action){
            case "create":
                System.out.println("show form");
                showCreateProductForm(request,response);
            case "delete":
                deleteProduct(request,response);
                break;
            case "edit":
                showEditProductForm(request,response);
                break;
            case "show":
                showProduct(request,response);
                break;
            default:
        }
    }

    private void showEditProductForm(HttpServletRequest request, HttpServletResponse response) {
        ProductService service = new ProductService();
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = service.getProduct(id);
        request.setAttribute("product",product);
        List<String> list = getCategoryNameList();
        request.setAttribute("category",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editForm.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProduct(HttpServletRequest request, HttpServletResponse response) {
        IProductService service = new ProductService();
        List<Product> list = service.listAllProduct();
        System.out.println("lisp"+list.size());
        request.setAttribute("listProduct",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateProductForm(HttpServletRequest request, HttpServletResponse response) {
        List<String> list = getCategoryNameList();
      request.setAttribute("listCategory",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("createProductForm.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getCategoryNameList() {
        ConnectDB connectDB = ConnectDB.getInstance();
        Connection connection = connectDB.getConnection();
        String sql = "select name from category";
        List<String> list = new ArrayList<>();
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("name");
                list.add(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
