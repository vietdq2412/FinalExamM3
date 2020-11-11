package Service;

import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private ConnectDB connectDB = ConnectDB.getInstance();
    private Connection connection = connectDB.getConnection();

    @Override
    public boolean addNewProduct(Product product) {
        String sql = "insert into product(name, price, color, description, category) values (?,?,?,?,?);";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, product.getName());
            stm.setInt(2, product.getPrice());
            stm.setString(3, product.getColor());
            stm.setString(4, product.getDescription());
            stm.setString(5, product.getCategory());
            stm.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        String sql = "delete from product where ID =" + id;
        try {
            Statement stm = connection.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Product> listAllProduct() {
        String sql = "Select * from product";
        List<Product> list = new ArrayList<>();
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String color = rs.getString("color");
                String desc = rs.getString("description");
                int quantity = rs.getInt("quantity");
                String category = rs.getString("category");
                list.add(new Product(id, name, color, price, quantity, desc, category));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean editProduct(int id, String name, int price, String color, int quantity, String description, String category) {
        String sql = "UPDATE product" +
                " set name = ?,price = ?, color =?, quantity=?,description = ?,category = ? where ID = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1,id);
            stm.setString(2,name);
            stm.setInt(3,price);
            stm.setString(4,color);
            stm.setInt(5,quantity);
            stm.setString(6,description);
            stm.setString(7,category);
            stm.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Product getProduct(int ID) {
        String sql = "select * from product where ID="+ID;
        Product product = null;
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            int id = rs.getInt("ID");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            String color = rs.getString("color");
            String desc = rs.getString("description");
            int quantity = rs.getInt("quantity");
            String category = rs.getString("category");
            product = new Product(id, name, color, price, quantity, desc, category);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }
}
