import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    // Create an list for users, drivers
    static List<Customer> users;
    static List<Cab> drivers;
    static Map<String, Integer> iniloc;
    // track curr Cust and Cab
    static Customer currCust;
    static Cab currCab;
    public static void main(String[] args) {
        users = new ArrayList<>();
        drivers = new ArrayList<>();
        iniloc = new HashMap<>();
        System.out.println("Welcome to Kiran cab_Services");
        while(true){
            System.out.println("Main Menu:");
            System.out.println("1.Driver\n2.Customer\n3.Administration\n4.Exit");
            int opt=sc.nextInt();
            if(opt>=4 || opt<0) break;
            if(opt==1){
                if (!drivers.isEmpty() && validUser("Driver")) {
                    System.out.println("Pickup  Drop  CustomerName  Amount");
                    for (Cab.Trip i : currCab.trip) {
                        System.out.println(i.src + "      " + i.dest + "       " + i.cust.name + "       " + i.fare);
                    }
                }
                else {
                    System.out.println("Invalid User !!");
                }
            }
            else if(opt==2){
                System.out.println("1.Signup\n2.Book Cab\n3.Ride Details");
                int cusOpt=sc.nextInt();
                if(cusOpt<0 || cusOpt>3){
                    System.out.println("Invalid Option !!");
                }
                else if(cusOpt==1){
                    users.add(Customer.getCustomer());
                }
                else if(cusOpt==2){
                    if(!users.isEmpty() && validUser("Customer")){
                        if(!drivers.isEmpty()) {
                            Cab.showCabLocations();
                            String src, dest;
                            System.out.println("Enter pickUp point: ");
                            src = sc.next();
                            System.out.println("Enter drop point: ");
                            dest = sc.next();
                            Bookcab.bookCab(src, dest, currCust);
                        }
                        else{
                            System.out.println("No cabs Available !!");
                        }
                    }
                    else{
                        System.out.println("Invalid User !!");
                    }
                }
                else{
                    if(!users.isEmpty() && validUser("Customer")){
                        System.out.println("Pickup  Drop  DriverName  Amount");
                        for(Customer.Trip i:currCust.trip){
                            System.out.println(i.src+"       "+i.dest+"      "+i.cab.name+"        "+i.fare);
                        }
                    }
                }
            }
            else{
                System.out.println("1.Details\n2.Add Driver\n3.Add locations");
                int admOpt=sc.nextInt();
                if(admOpt<0 || admOpt>3){
                    System.out.println("Invalid Option !!");
                }
                else if(admOpt==1){
                    System.out.println("Details");
                    System.out.println(drivers+" "+users);
                }
                else if(admOpt==2){
                    drivers.add(Cab.getCab());
                }
                else {
                    System.out.println("1.Initial location\n2.Cab locations");
                    int locOpt = sc.nextInt();
                    if (locOpt < 0 || locOpt > 2) {
                        System.out.println("Invalid Option !!");
                    } else if (locOpt == 1) {
                        System.out.println("Enter Number Of Locations: ");
                        int locCnt = sc.nextInt();
                        for (int i = 0; i < locCnt; i++) {
                            System.out.println("Enter location name: ");
                            String locname = sc.next();
                            System.out.println("Enter distance from Origin: ");
                            int dist = sc.nextInt();
                            iniloc.put(locname, dist);
                        }
                    } else if (locOpt == 2) {
                        System.out.println("Enter Number Of Cab Locations: ");
                        int cabCnt = sc.nextInt();
                        if(drivers.size()<cabCnt){
                            System.out.println("Insufficient drivers !!");
                        }
                        else {
                            for (int i = 0; i < cabCnt; i++) {
                                System.out.println("Enter id: ");
                                int id = sc.nextInt();
                                System.out.println("Enter location name: ");
                                String locname = sc.next();
                                for(Cab j : drivers){
                                    if(j.id==id){
                                        j.location=locname;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    static boolean validUser(String currUser){
        String name, password;
        System.out.println("Enter name: ");
        name=sc.next();
        System.out.println("Enter password: ");
        password=sc.next();
        if(currUser.equals("Customer")){
            for(Customer i:users){
                if(i.name.equals(name) && i.password.equals(password)){
                    currCust=i;
                    return true;
                }
            }
        }
        else{
            for(Cab i:drivers){
                if(i.name.equals(name) && i.password.equals(password)){
                    currCab=i;
                    return true;
                }
            }
        }
        return false;
    }
}