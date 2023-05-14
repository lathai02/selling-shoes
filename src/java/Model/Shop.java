/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lathai
 */
public class Shop {

    String image;
    String decription;
    String name;
    String phoneNumber;
    String email;
    String address;

    public Shop(String image, String decription, String name, String phoneNumber, String email, String address) {
        this.image = image;
        this.decription = decription;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Shop() {
    }

    public String getImage() {
        return image;
    }

    public String getDecription() {
        return decription;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
