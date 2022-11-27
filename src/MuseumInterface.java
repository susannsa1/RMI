import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MuseumInterface extends Remote {

    //Add a new piece of Art
    public void addArt(String name, String artist, int value) throws RemoteException;

    //Search for a piece of Art
    public ArtInterface SearchByName(String name) throws RemoteException;

    // Return the set of all Arts
    public ArrayList<ArtInterface> getArtObject() throws RemoteException;

    // Return the name of the Museum
    public String getName()throws RemoteException;

}
