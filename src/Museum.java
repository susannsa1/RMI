import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

public class Museum extends UnicastRemoteObject implements MuseumInterface{
    private String name;

    // Create an ArrayListe
    private ArrayList<ArtInterface> artObject = new ArrayList<ArtInterface>();



    //Contructor of name and artObject
    public Museum(String name, ArrayList<ArtInterface> artObject) throws RemoteException {
        this.name = name;
        this.artObject = artObject;
    }

    public Museum(String name) throws RemoteException{
        this.name=name;
    }

    @Override
    // Getter Name
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    // Getter Artobject
    public ArrayList<ArtInterface> getArtObject() throws RemoteException{
        return artObject;
    }

    @Override
    //Created SearchByName
    public ArtInterface SearchByName(String name) throws RemoteException{
        for(int i = 0; i<artObject.size(); i++){
            if(name.equals(getArtObject().get(i).getName())){
                return getArtObject().get(i);
            }
        }return null;
    }

    @Override
    //Created AddArt
    public void addArt(String name, String artist, int value) {
        try {
            Art art= new Art(name,artist,value);
            artObject.add(art);

        }catch (RemoteException e){e.printStackTrace();}

    }

    public static void main (String[] args) {

        try {

            Museum museum1 = new Museum ("Art of Science\n");
            // Erstellt ein Eintrag in der Tabelle mit dem Namen Server1 von der klasse Museum museum1
            Naming.rebind("Server1",museum1);

            Museum museum2= new Museum("Art of Human\n");
            Naming.rebind("Server2",museum2);


            System.out.println("The server is up");

        } catch (Exception e) {
            System.out.println("Museum: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
