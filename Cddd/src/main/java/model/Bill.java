package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bill {

    private ArrayList<Cd> billArr;
    private  int priceSum=0;
    public String filename;
    private int billNo;
    private static Date currentDate;
    private Date dt = new Date();



    public Bill(){

    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public Bill(ArrayList<Cd> billArr, String filename){
        this.billArr = billArr;
        for(Cd c: billArr){
            //c.setQuantity(c.getQuantity() - 1);
            c.setPurchasedDate(dt);
            currentDate = new Date();
        }
        this.filename=filename;
    }

    public Date setDateBill(Date dt){
        return dt;
    }

    public double getPrice(){
        for(Cd c: billArr)
            priceSum += c.getPrice();
        return priceSum;
    }

   /* public void rmQuantity(){

    }*/
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public void writeToBill(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("            ------BILL------\n\n");
            writer.write("Purchased Cds:\n");
            for(Cd c: billArr){
               writer.write("Name: " + c.getName() + "    Singer: " + c.getSinger() + "    Price: " + c.getPrice());
               writer.newLine();
            }
            writer.newLine();
            writer.write("Date: " + dateFormat.format(dt));
            writer.newLine();
            writer.write("Total price: $" + getPrice());

        } catch (IOException e) {
            e.printStackTrace();
        }
        /*System.out.println("------BILL------");
        for(Cd c: billArr){
            c.toString();
        }
        System.out.println("Total amount to pay: " + getPrice());*/
    }


}
