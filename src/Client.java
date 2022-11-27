import javax.sound.midi.Soundbank;
import java.rmi.Naming;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main (String[] args) throws Exception {
        if (args.length != 1)
            throw new IllegalArgumentException ("Syntax: Dateclient <hostname>");

        try {

            // look at the rmi registry, where the name from entry is "Server1"/"2"
            // creates a reference to server1&2
            MuseumInterface museum1= (MuseumInterface) Naming.lookup("rmi://localhost/Server1");
            MuseumInterface museum2= (MuseumInterface) Naming.lookup("rmi://localhost/Server2");

            // Create an object museumInterface
            MuseumInterface museumInterface = null;

            Scanner scanner = new Scanner(System.in);

            System.out.println("Do you want select museum 1 or 2: ");
            String selectmuseum = scanner.nextLine();

            // Museum selection
            if(selectmuseum.equals("1")) {
                museumInterface = museum1;
                System.out.println(museumInterface.getName());
            } else if (selectmuseum.equals("2")) {
                museumInterface=museum2;
                System.out.println(museumInterface.getName());
            }

            // User selects museum
            System.out.println("For searching press 1: ");
            System.out.println("For adding press 2: ");
            String selectseoradd= scanner.nextLine();

            //Searching
            if (selectseoradd.equals("1")){
                System.out.println("For which art are you looking for: ");
                String artname= scanner.nextLine();
                ArtInterface art = museumInterface.SearchByName(artname);

                //get the name,artist,value with the getter methods and print them out
                System.out.println("The name of painting: "+art.getName());
                System.out.println("The name of artist: "+art.getArtist());
                System.out.println("The value of painting "+art.getValue());

                // change/set the value
                System.out.println("Do you want change the value? yes/no: ");
                String yesno= scanner.nextLine();

                if(yesno.equals("yes")){
                    System.out.println("The value should be: ");
                    String value= scanner.nextLine();
                    art.setValue(Integer.parseInt(value));
                } else if (yesno.equals("no")) {
                    return;
                }
            }
            //Adding
            else if (selectseoradd.equals("2")) {
                System.out.println("The name of painting: ");
                String name= scanner.nextLine();

                System.out.println("The name of the artist");
                String artist= scanner.nextLine();

                System.out.println("The value: ");
                String value= scanner.nextLine();


                museumInterface.addArt(name,artist,Integer.parseInt(value));
            }

            // The total value from Monet
            int value = 0;
            for (int i= 0; i<museumInterface.getArtObject().size();i++){
                if(museumInterface.getArtObject().get(i).getArtist().equals("Monet")){
                    value = value + museumInterface.getArtObject().get(i).getValue();
                }
            }System.out.println("The Total value of Monet is " +value);

        } catch (Exception e) {
            System.out.println("Client: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
