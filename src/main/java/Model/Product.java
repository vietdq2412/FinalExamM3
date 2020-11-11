package Model;

public class Product {
    private int ID;
    private String name;
    private int price;
    private int quantity;
    private String color;
    private String description;
    private String category;

    public Product() {
    }

    public Product(String name, int price,int quantity, String color, String description, String category) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
    }

    public Product(int ID, String name, String color,int price, int quantity,String description, String category) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return this.ID;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString(){
        return "|Name :" + this.name+
               "|Name :" + this.price+
               "|Name :" + this.quantity+
               "|Name :" + this.color+
               "|Name :" + this.description;
    }
}
