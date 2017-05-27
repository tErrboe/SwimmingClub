import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileReadWrite{
    public void saveMembers(ArrayList<Member> m){
        try{
            ArrayList<Member> members = m;
            ObjectOutputStream saveMembers = new ObjectOutputStream(new FileOutputStream("members.txt"));
            saveMembers.writeObject(members);
            saveMembers.close();
        }
        catch(IOException | NullPointerException e){
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Member> loadMembers(){
        ArrayList<Member> m = null;
        try{
            ObjectInputStream loadMembers = new ObjectInputStream(new FileInputStream("members.txt"));
            m = (ArrayList<Member>) loadMembers.readObject();
            loadMembers.close();
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        return m;
    }

}