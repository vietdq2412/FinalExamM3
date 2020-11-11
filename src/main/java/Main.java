import Model.Product;
import Service.ConnectDB;
import Service.ProductService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ProductService service = new ProductService();
        service.editProduct(4,"ip11",1000,"red",3,"99%","asus");
    }
}
