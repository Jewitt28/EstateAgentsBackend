package com.example.estateagency.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table (name= "properties")

public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long property_id;
    private String address;
    private String postcode;
    private int price;
    private String status;
    private String type;
    private int bedrooms;
    private int bathrooms;
    private int garden;






    // EMPTY CONSTRUCTOR
    public Properties() {
    }




    //CONSTRUCTOR

    public Properties(long property_id, String address, String postcode, int price, String status, String type, int bedrooms, int bathrooms, int garden, Buyers buyers, Sellers sellers) {
        this.property_id = property_id;
        this.address = address;
        this.postcode = postcode;
        this.price = price;
        this.status = status;
        this.type = type;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.garden = garden;
        this.buyers = buyers;
        this.sellers = sellers;
    }
    public Properties(long property_id, String address, String postcode, int price, String status, String type, int bedrooms, int bathrooms, int garden, Sellers sellers ) {
        this.property_id = property_id;
        this.address = address;
        this.postcode = postcode;
        this.price = price;
        this.status = status;
        this.type = type;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.garden = garden;
        this.sellers = sellers;
    }
    //GETTER SETTERS


    public long getProperty_id() {
        return property_id;
    }

    public void setProperty_id(long property_id) {
        this.property_id = property_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getGarden() {
        return garden;
    }
    public void setGarden(int garden) {
        this.garden = garden;
    }
    public Sellers getSellers() {
        return sellers;
    }

    public void setSellers(Sellers sellers) {
        this.sellers = sellers;
    }

    public Buyers getBuyers() {
        return buyers;
    }

    public void setBuyers(Buyers buyers) {
        this.buyers = buyers;
    }


    //BUYER FIELD
    @ManyToOne
    @JoinColumn(name = "buyers_id")

    private Buyers buyers;


    //SELLER FIELD

    @ManyToOne
    @JoinColumn(name = "sellers_id")

   // @JsonBackReference
    private Sellers sellers;



    //TOSTRING
    @Override
    public String toString() {
        return "Properties{" +
                "property_id=" + property_id +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", garden=" + garden +
                ", buyers=" + buyers +
                ", sellers=" + sellers +
                '}';
    }
}

