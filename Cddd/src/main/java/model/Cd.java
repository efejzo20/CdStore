package model;

import java.io.Serializable;
import java.util.Date;

public class Cd implements Serializable {

    private static final long serialVersionUID = 1L;
    private String genre;
    private String singer;
    private String name;
    private Date purchasedDate;
    private double price;
    private int quantity;
    private int id;
    public  static int nr=0;

    public Cd(){
        this(nr++,"","","",1,1);
    }



    public Cd(int id, String name, String genre, String singer, double price, int quantity) {
        this.genre = genre;
        this.name = name;
        this.singer = singer;
        this.purchasedDate = purchasedDate;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Genre='" + genre + '\'' +
                ", Singer='" + singer + '\'' +
                ", Name='" + name + '\'' +
                ", PurchasedDate=" + purchasedDate +
                ", Price=" + price +
                ", Quantity=" + quantity +
                ", Id=" + id +
                '}';
    }
}
