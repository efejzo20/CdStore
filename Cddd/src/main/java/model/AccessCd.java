package model;

import java.io.*;
import java.util.ArrayList;

public class AccessCd {

    public static final String filename="CdData.bin";

    private ArrayList<Cd> cdArray = new ArrayList<Cd>();
    InputStream file, buffer;
    OutputStream bf, fl;
    ObjectInput input;
    ObjectOutput output;
    File ufile = new File(filename);

    public AccessCd(){
        readF();
    }

    public void addCd(Cd c){
        cdArray.add(c);
        writeF();
    }

    public ArrayList<Cd> getCds()
    {
        return cdArray;
    }

    public boolean sameId(int id){
        for (Cd c : cdArray)
            if(c.getId() == id)
                return true;
        return false;
    }

    public void remove(int id) {
        boolean rm = false;
        for (Cd x : cdArray)
            if (x.getId() == id) {
                rm = true;
                cdArray.remove(cdArray.indexOf(x));
            }
        if (!rm)
            System.out.println("Not Found");
    }

    public int getPosition(Cd c)
    {
        for(int i = 0; i< cdArray.size(); i++)
        {
            if(cdArray.get(i).toString().equals(c.toString()))
                return i;
        }

        return -1;
    }

    public void setQuantity(Cd c, int quantity)
    {
        int pos = getPosition(c);

        cdArray.get(pos).setPrice(quantity);

        this.writeF();
    }

    private void readF() {
        try {
            file = new FileInputStream(ufile);
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            cdArray = (ArrayList<Cd>) input.readObject();
            for (Cd c : cdArray) {
                System.out.println("Cd Data: " + c.toString());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("File Not well defined. Creating new file"
                    + ex.toString());
        } catch (IOException ex) {
            System.out.println("Cannot perform input." + ex.toString());
        }
        closeFile();
    }

    public void editCd(Cd u)
    {
        readF();
        for(int i=0; i<cdArray.size(); i++)
        {

            if(cdArray.get(i).getId() == (u.getId())) {
                cdArray.set(i, u);
                writeF();
            }

        }

    }

    private void writeF() {
        // serialize the List
        try {
            fl = new FileOutputStream(ufile);
            bf = new BufferedOutputStream(fl);
            output = new ObjectOutputStream(bf);
            output.writeObject(cdArray);
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

