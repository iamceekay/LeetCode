package LowLevelDesign.Movie;

import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

enum bookingStatus{
    Requested,Pending,Confirmed,cancelled;
}
enum seatType{
    Regular,Premium;
}
enum accountStatus
{
    Active,Blocked
}
enum paymentStatus
{
    Pending,Completed,Cancelled, Declined;
}
class Account {
    private String id;
    private String password;
    private accountStatus accountStatus;
    private boolean resetPassword() {
        return false;
    }
}

abstract class Person
{
    private String name;
    private  String email;
    private String phone;
    private Account account;

}
class Customer extends Person{
    public boolean MakeBooking(Booking booking) throws SQLException {
        Connection dbConnection=null;
        dbConnection.setAutoCommit(false);
        dbConnection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        Statement st=dbConnection.createStatement();
        String query="select * from showSeat where showid=(?) and ShowSeatNumber in(?) && isReserved=0;  ";
        PreparedStatement ps=dbConnection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        dbConnection.commit();
        return true;

    }
    public List<Booking> getAllBooking(){
        return null;
    }
}
class Admin extends Person{
   public boolean addMovie(Movie movie){ return true;}
   public boolean addShow(Show show){return  true;}
}
class Guest{
    boolean registerAccount(){return true;}
}
class Movie{
    public String title;
    public String description;
    public String language;
    public List<Show> getShow(){ return null;}
}
class Show{
    private Date StartTime;
    private Date endTime;
    private Movie movie;


}
class City{
    String name;
    String state;
    String ZipCode;
    List<Theatre> allTheatre;
}
class Theatre
{
    String name;
    int numberOfAuditorium;
    List<Auditorium> Auditorium;
}
class Auditorium{
    String Name;
    int totalSeat;
    Show show;
}
interface Search{
    List<Movie> searchByTitle(String title);
    List<Movie> searchByCity(String City);
    List<Movie> searchByGenre(String Genre);
    List<Movie> searchByLanguage(String Language);

}
class Catalog implements Search {
    HashMap<String, List<Movie>> movieTitle;
    HashMap<String, List<Movie>> movieLanguage;
    HashMap<String, List<Movie>> movieGenre;
    HashMap<String, List<Movie>> movieCities;

    @Override
    public List<Movie> searchByTitle(String title) {
        return movieTitle.get(title);
    }

    @Override
    public List<Movie> searchByCity(String City) {
        return movieCities.get(City);
    }

    @Override
    public List<Movie> searchByGenre(String Genre) {
        return movieGenre.get(Genre);
    }

    @Override
    public List<Movie> searchByLanguage(String Language) {
        return movieLanguage.get(Language);
    }
}
    class Booking{
        private String bookingNumber;
        private  int numberOfSeat;
        bookingStatus bookingStatus;
        Payment payment;
        private  boolean makePayment(Payment payment){
            return true;
        }
       Show show;
        private boolean cancel(){return false;};
    }
    class Payment
    {
        Date created;
        private double amount;
        paymentStatus paymentStatus;
    }
