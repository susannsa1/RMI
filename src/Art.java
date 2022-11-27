import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Art extends UnicastRemoteObject implements ArtInterface {
    private String name;
    private String artist;
    private int value;

    //Contructor
    public Art(String name, String artist, int value) throws RemoteException {
        this.name = name;
        this.artist = artist;
        this.value = value;
    }

    // Return the name
    public String getName() throws RemoteException {
        return name;
    }

    // Return the artist
    public String getArtist() throws RemoteException {
        return artist;
    }


    //Return the value
    public int getValue() throws RemoteException {
        return value;
    }

    // Change / Set the Value
    public void setValue(int value) throws RemoteException {
        this.value = value;
    }
}
