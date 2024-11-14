import java.util.*;

public class Bookcab {
    static Scanner sc = new Scanner(System.in);

    static void bookCab(String src, String dest, Customer currCust){
        boolean avail=false;
        for(Cab i:Main.drivers){
            if(i.location!=null){
                avail=true;
                break;
            }
        }
        if(!avail){
            System.out.println("No cabs available !!");
            return;
        }
        int dist= Main.iniloc.get(src), minDist=Integer.MAX_VALUE;
        Cab availCab = null;
        for(Cab i: Main.drivers){
            int val=Math.abs(dist- Main.iniloc.get(i.location));
            if(val<minDist){
                minDist=val;
                availCab=i;
            }
        }
        if(availCab==null){
            System.out.println("No cabs Available !!");
            return;
        }
        System.out.println("Available cab from your location: ");
        System.out.println(availCab.id+" "+availCab.name+" "+availCab.location);
        System.out.println("Do you want to book?\n1.Yes\n2.No");
        int bookOpt=sc.nextInt();
        if(bookOpt<0 || bookOpt>2){
            System.out.println("Invalid Options !!");
        }
        else if(bookOpt==1){
            System.out.println("Your cab booked !!");
            availCab.location=dest;
            int fare=Math.abs(Main.iniloc.get(src)-Main.iniloc.get(dest))*10;
            Cab.Trip bookedCab = new Cab.Trip(src, dest, currCust, fare);
            availCab.trip.add(bookedCab);
            Customer.Trip bookedCust = new Customer.Trip(src, dest, availCab, fare);
            currCust.trip.add(bookedCust);
        }
        else{
            System.out.println("Wait for other cabs !!");
        }
    }
}
