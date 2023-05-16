package com.example.estateagency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name= "buyers")

public class Buyers {



    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long buyers_id;
    private String firstName;
    private String lastName;

    private String email;

    private String address;

    private String postcode;

    private long phone;

    @OneToMany(mappedBy = "buyers", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Properties> propertiesList;

    public long getBuyers_id() {
        return buyers_id;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public List<Properties> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(List<Properties> propertiesList) {
        this.propertiesList = propertiesList;
    }

    public Buyers(long buyers_id, String firstName, String lastName, String email, String address, String postcode, long phone, Buyers buyers, List<Properties> propertiesList) {
        this.buyers_id = buyers_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
    }

    public long getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


    public Buyers(long buyers_id, String firstName, String lastName, String email, String address, String postcode, long phone, List<Properties> propertiesList) {
        this.buyers_id = buyers_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
        this.propertiesList = propertiesList;
    }

    public Buyers() {
    }

    public void setBuyers_id(long buyers_id) {
        this.buyers_id = buyers_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    @Override
    public String toString() {
        return "Buyers{" +
                "buyers_id=" + buyers_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", postcode=" + postcode +
                ", phone=" + phone +
                '}';
    }
}
