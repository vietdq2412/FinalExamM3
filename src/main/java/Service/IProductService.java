package Service;

import Model.Product;

import java.util.List;

public interface IProductService {
    boolean addNewProduct(Product product);
    boolean deleteProduct(int id);
    List<Product> listAllProduct();
    boolean editProduct(int id, String name, int price, String color, int quantity,String description,String category);
    Product getProduct(int ID);
    Product searchProduct(String str);
}
