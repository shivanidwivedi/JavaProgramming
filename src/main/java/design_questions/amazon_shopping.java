package design_questions;


import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * @author shivanidwivedi on 22/04/20
 * @project JavaProgramming
 */
public class amazon_shopping {
}

enum OrderStatus{
    SHIPPED, CANCELLED, UNSHIPPED, PLACED
}

enum AccountStatus{
    ACTIVE, BLOCKED, ARCHIVED
}

enum ShipmentStatus{
    SHIPPED, DELIVERED, FAILED
}
class Address{
    private String streetName;
    private String Locality;
    private String city;
    private String state;
    private String zipCode;
}

//Account, Customer, Admin, and Guest:

class Account{
    private String userName;
    private String password;
    private AccountStatus status;
    private Address shippingAddress;
    private String name;
    private String phone;

    private List<CreditCards> creditCards;
    private List<EBankTransfers> payment;

    public boolean addProduct(Product product);
    public boolean addProductReview(Product product);
    public boolean resetPassword();

}

class Customer{
    private ShoppingCart cart;
    private Order order;

    public ShoppingCart getShoppingCart();
    public boolean addItemToCart(Item item);
    public boolean removeItemfromCart(Item item);

}

class Guest extends Customer{
    public boolean registerAccount();
}
class Member extends Customer{
    private Account account;
    public OrderStatus placeOrder(Order order);
}

//ProductCategory, Product, and ProductReview

class ProductCategory{
    private String name;
    private String description;
}
class Product{
    private String productName;
    private String productId;
    private String description;
    private double price;
    private ProductCategory productCategory;
    private int availableCapacity;

    public boolean updatePrice(double newPrice);
    public boolean getAvailableCount();

}
class ProductReview{
 private String review;
 private int rating;

 private Member reviewer;

}

//ShoppingCart, Item, Order

class ShoppingCart{
    private List<Item> itemList;

    public boolean addItem(Item item);
    public boolean removeItem(Item item);
    public boolean checkOut();
    public boolean updateItemQuantity(Item item, int quantity);
    public List<Item> getItemList();

}
class Item{
    private String itemId;
    private int quantity;
    private String itemName;
}

class Order{
    private String orderid;
    private OrderStatus status;
    private Date createOrder;

    public boolean makePayment(Payment payment);
    public boolean sendForShipment();
}

//Shipment and Notification

class Shipment{
    private Address shippingAddress;
    private Date shippingDate;
    private Date estimatedArrival;
    private String shipmentId;
}

class Notification{
    private int notificationId;
    private String content;
    private Date notificationDate;

    public boolean sendNotification(Account account);
}
interface search{
    public List<Product> searchProductByName(String name);
    public List<Product> searchProductByCategory(ProductCategory category);
}

class Catalog implements search{
    HashSet<String,List<Product>> productNames;
    HashSet<String,List<Product>> productCategories;

    public List<Product> searchProductByName(String name){
        return productNames.get(name);
    }
    public List<Product> searchProductByName(String category){
        return productNames.get(category);
    }
}
