import java.util.*;

public class Customer {
    static Scanner sc = new Scanner(System.in);
    int id;
    String name, password;
    List<Trip> trip;
    Customer(int id, String name, String password){
        this.id=id;
        this.name=name;
        this.password=password;
        trip = new ArrayList<Trip>();
    }
    static class Trip{
        String src, dest;
        int fare;
        Cab cab;
        Trip(String src, String dest, Cab cab, int fare){
            this.src=src;
            this.dest=dest;
            this.cab=cab;
            this.fare=fare;
        }
    }
    static public Customer getCustomer(){
        int id;
        String name, password;
        System.out.println("Enter id: ");
        id=sc.nextInt();
        System.out.println("Enter name: ");
        name=sc.next();
        System.out.println("Enter password: ");
        password=sc.next();
        Customer cust = new Customer(id, name, password);
        return cust;
    }
}
