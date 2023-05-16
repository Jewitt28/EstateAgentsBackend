package com.example.estateagency.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table (name= "sellers")

public class Sellers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sellers_id;
    private String firstName;
    private String lastName;

    private String email;


    private String address;


    private String postcode;

    private String phone;

//    @ManyToOne       // --------- need to reverse
//    private Properties properties; // --------- PROBABLY JUST DELETE, ONE PROP CANT HAVE MULTIPLE SELLERS

    @OneToMany(mappedBy = "sellers", fetch = FetchType.EAGER)
    @JsonIgnore
   // @JsonManagedReference
    private List<Properties> propertiesList;


    public Sellers(long sellers_id, String firstName, String lastName, String email, String address, String postcode, String phone, List<Properties> propertiesList) {
        this.sellers_id = sellers_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
        this.propertiesList = propertiesList;
    }

    public Sellers(long sellers_id, String firstName, String lastName, String email, String address, String postcode, String phone) {
        this.sellers_id = sellers_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
    }

    public long getSellers_id() {
        return sellers_id;
    }

    public void setSellers_id(long sellers_id) {
        this.sellers_id = sellers_id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public List<Properties> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(List<Properties> propertiesList) {
        this.propertiesList = propertiesList;
    }

    public Sellers() {
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

    //  public Properties getProperties() {
//        return properties;
//    }
//
//    public void setProperties(Properties properties) {
//        this.properties = properties;
//    }


    @Override
    public String toString() {
        return "Sellers{" +
                "sellers_id=" + sellers_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", phone='" + phone + '\'' +
                ", propertiesList=" + propertiesList +
                '}';
    }
}