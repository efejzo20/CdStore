package model;

import java.io.*;
import java.util.ArrayList;

public class UserAccess {

    public static final String filename = "UserData.txt";
    private ArrayList<User> users = new ArrayList<User>();
    InputStream file, buffer;
    OutputStream bf, fl;
    ObjectInput input;
    ObjectOutput output;
    File ufile = new File(filename);

    public UserAccess() {
        readF();
    }

    public User checkUser(String user, String pass) {
        for (User u : users)
            if (u.getUsername().equals(user) && u.getPassword().equals(pass)) {
                return u;
            }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
        writeF();
    }

    public boolean sameId(int id){
        for (User u : users)
            if(u.getId() == id)
                return true;
        return false;
    }

    public String readS() {
        readF();
        String read = "";
        for (User x : users)
            read += "--------------------\n" + x.toString()
                    + "\n>---------------------------<\n";
        return read;
    }

    public ArrayList<User> getUsers()
    {
        this.readF();
        return this.users;
    }


    public void remove(User u) {
        boolean rm = false;
            for(int i=0; i<users.size(); i++)
            {
                User user = users.get(i);
                if(users.get(i).toString().equals(u.toString()))
                {
                    users.remove(i);
                    rm = true;
                    this.writeF();
                }

            }
        if (!rm)
            System.out.println("Not Found");
    }

    public int getPosition(User u)
    {
        //this.readF();
        System.out.println("--------------");
        System.out.println(u);
        System.out.println("--------------");
        for(int i=0; i<users.size(); i++)
        {
            if(users.get(i).toString().equals(u.toString()))
                return i;
        }

        return -1;
    }

    public void editUser(int pos, User u)
    {
        System.out.println(">>>>"+pos);
        if(pos < 0 || pos >= users.size())
        {
            System.out.println("Cannot find User");
            return;
        }
        else
        {
            users.set(pos, u);
            this.writeF();
        }
    }

    @SuppressWarnings("unchecked")
    private void readF() {
        try {
            file = new FileInputStream(ufile);
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            users = (ArrayList<User>) input.readObject();
            for (User user : users) {
                System.out.println("Login Data: " + user.toString());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Not found. Creating new file"
                    + ex.toString());
        } catch (IOException ex) {
            System.out.println("Cannot perform input." + ex.toString());
        }
        closeFile();
    }

    private void writeF() {
        try {
            fl = new FileOutputStream(ufile);
            bf = new BufferedOutputStream(fl);
            output = new ObjectOutputStream(bf);
            output.writeObject(users);
        } catch (IOException ex) {
            System.out.println("Cannot perform output." + ex.toString());
        }
        closeFile();
    }

    public void closeFile() {
        try {
            if (input != null) {
                input.close();
                buffer.close();
                file.close();
            }
            if (output != null) {
                output.close();
                bf.close();
                fl.close();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
