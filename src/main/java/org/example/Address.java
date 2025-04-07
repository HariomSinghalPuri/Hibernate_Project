package org.example;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="student_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private int addressID ;

    @Column(length = 50 , name = "STREET")
    private String street;

    @Column(length = 100,name = "CITY")
    private String city ;

    @Column(name = "is_open")
    private boolean isOpen ;

    @Transient
    private double X;

    @Column(name = "addedDate")
    private Date addedDate;

    @Lob
    private byte[] image ;


    public Address(){
         super();
    }


    public Address(int addressID, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
        this.addressID = addressID;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        X = x;
        this.addedDate = addedDate;
        this.image = image;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
