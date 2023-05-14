/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lathai
 */
public class User {

    String id;
    String dob;
    String gender;
    String name;
    String email;
    String phoneNumber;
    String address;
    String password;
    String account;
    String isAdmin;

    public User() {
    }

    public User(String password, String account) {
        this.password = password;
        this.account = account;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String dob, String gender, String name, String email, String phoneNumber, String address, String password, String account, String isAdmin) {
        this.dob = dob;
        this.gender = gender;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.account = account;
        this.isAdmin = isAdmin;
    }

    public User(String id, String dob, String gender, String name, String email, String phoneNumber, String address, String password, String account, String isAdmin) {
        this.id = id;
        this.dob = dob;
        this.gender = gender;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.account = account;
        this.isAdmin = isAdmin;
    }

    public String getId() {
        return id;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getAccount() {
        return account;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }
    
   
}
