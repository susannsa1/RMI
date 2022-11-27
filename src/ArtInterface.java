import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ArtInterface extends Remote {

    // Return the name
    public String getName() throws RemoteException;

    // Return the artist
    public String getArtist() throws RemoteException;

    // Return the value
    public int getValue() throws RemoteException;

    // Change the value
    public void setValue(int value) throws RemoteException;

}
