package LowLevelDesign.Movie;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

enum OrderStatus{
    Pending,Completed,Cancelled;
}
enum AccountStatusA
{
    Active,Blocked;
}
enum ShipmentStatus
{
    Pending,Shipped,Delivered;
}
enum PaymentStatus
{
    Completed,Declined,Pending;
}
class AccountA
{
    String name;
    String email;
    String phoneNumber;
    String address;
    boolean resetPassword(){
        return true;
    }
    boolean addProduct(Product product){
        return  true;
    }
    boolean addProductReview(Product product){
        return  true;
    }
}
abstract class CustomerA{
    private ShoppingCart shoppingCart;
    private Order order;

    private ShoppingCart getShoppingCart(){
        return new ShoppingCart();
    }
    private boolean addItemToCart(Item item){
            return true;
    }
    private boolean removeFromart(Item item){
        return true;
    }
}
class MemberA extends CustomerA{
    AccountA account;
    OrderStatus placeOrder(Order order)
    {
        return OrderStatus.valueOf("Cancelled");
    }
}
class GuestA extends CustomerA
{
    boolean registerAccount(){
        return true;
    }
}
interface SearchA{
    public List<Product> searchByName(String name);
    public List<Product> searchByCategory(String name);

}
class CatalogA implements SearchA{
    HashMap<String, List<Product>> ProductByNames;
    HashMap<String,List<Product>> ProductByCategory;
    @Override
    public List<Product> searchByName(String name)
    {
        return ProductByNames.get(name);
    }
    @Override
    public List<Product> searchByCategory(String name)
    {
        return ProductByCategory.get(name);
    }

}
class ProductCategory{
    String name;
    String description;
}
class ProductReviewA{
    String review;
    int rating;
    MemberA member;
}
class Product
{
    String Productid;
    String name;
    String description;
    double price;
    private int availableCount;
}
class Item
{
    String productId;
    private int quantity;
    private double Price;
    public boolean updateQuantity(int quantity)
    {
        return true;
    }
}
class ShoppingCart
{
    private List<Item> items;
    public boolean addItem(Item item)
    {
        return true;
    }
    public boolean removeItem(Item item)
    {
        return true;
    }
    public boolean ItemQuantity(int q)
    {
        return true;
    }
    private boolean checkout()
    {
        return true;
    }

}
class Order
{
    private String orderNumber;
    private String orderStatus;
    public boolean sendForShipment(){
            return true;
    }
    public boolean MakePayment(){
            return true;
    }
}
abstract class Notification
{
    private int notificationId;
    private Date date;
    private String content;
    private void SendNotification(Account account)
    {

    }
}
class SMS extends Notification{
    void addSMSDetail()
    {

    }
}
class Email extends Notification{
    void addEmail()
    {

    }
}
 class Amazon {
}
