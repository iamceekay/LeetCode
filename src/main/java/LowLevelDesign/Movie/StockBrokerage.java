package LowLevelDesign.Movie;
//User can buy sell stock
//user have multiple watchlist
//Able tto place stock and trade
//Have multiple lots of stock
//Generate report
//Should able to deposit and withdraw money via check
//able to send notofiactiom
//Actor: Member, System, Admin
//Use caases:
//Add new account
//Add watchlist
//Search Stock inventory
//Place order
//Cancel order
//Deposit money
enum AccountStatus{
    Active,Closed,Cancelled;
}
enum orderStatus{
    Open,filled,Cancelled;
}

class StockBrokerage {
}
abstract class AccountB{
    String name;
    String id;
    String email;
    String address;
    String password;
    String phonenumber;
    public boolean resetPassword(){return true;};

}
class Member extends AccountB
{
    private double availableFund;

}
