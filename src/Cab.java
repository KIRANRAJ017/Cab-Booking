import java.util.*;

public class Cab {
    static Scanner sc = new Scanner(System.in);
    int id;
    String name, password, location;
    List<Trip> trip;
    Cab(int id, String name, String password, String location){
        this.id=id;
        this.name=name;
        this.password=password;
        this.location=location;
        trip=new ArrayList<>();
    }
    static class Trip{
        String src, dest;
        int fare;
        Customer cust;
        Trip(String src, String dest, Customer cust, int fare){
            this.src=src;
            this.dest=dest;
            this.cust=cust;
            this.fare=fare;
        }
    }
    static public Cab getCab(){
        int id;
        String name, password;
        System.out.println("Enter id: ");
        id=sc.nextInt();
        System.out.println("Enter name: ");
        name=sc.next();
        System.out.println("Enter password: ");
        password=sc.next();
        Cab cab = new Cab(id, name, password, null);
        return cab;
    }
    static void showCabLocations(){
        System.out.println("cab Id      Location");
        for(Cab i: Main.drivers){
            System.out.println(i.id+"            "+i.location);
        }
    }
}
