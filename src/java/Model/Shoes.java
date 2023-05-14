/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.AdminDao;

/**
 *
 * @author lathai
 */
public class Shoes {
    
    String id;
    String code;
    String origin;
    String detail;
    String name;
    String color;
    String brandId;
    String price;
    String decription;
    String img;
    String size;
    String stockQuantity;
    String gender;
    String discount;
    String userId;
    
    public Shoes() {
    }
    
    public Shoes(String code, String origin, String detail, String name, String color, String brandId, String price, String decription, String img, String size, String stockQuantity, String gender, String discount, String userId) {
        this.code = code;
        this.origin = origin;
        this.detail = detail;
        this.name = name;
        this.color = color;
        this.brandId = brandId;
        this.price = price;
        this.decription = decription;
        this.img = img;
        this.size = size;
        this.stockQuantity = stockQuantity;
        this.gender = gender;
        this.discount = discount;
        this.userId = userId;
    }
    
    public Shoes(String id, String code, String origin, String detail, String name, String color, String brandId, String price, String decription, String img, String size, String stockQuantity, String gender, String discount, String userId) {
        this.id = id;
        this.code = code;
        this.origin = origin;
        this.detail = detail;
        this.name = name;
        this.color = color;
        this.brandId = brandId;
        this.price = price;
        this.decription = decription;
        this.img = img;
        this.size = size;
        this.stockQuantity = stockQuantity;
        this.gender = gender;
        this.discount = discount;
        this.userId = userId;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public String getName() {
        return name;
    }
    
    public String getColor() {
        return color;
    }
    
    public String getBrandId() {
        return brandId;
    }
    
    public String getPrice() {
        return price;
    }
    
    public String getDecription() {
        return decription;
    }
    
    public String getImg() {
        return img;
    }
    
    public String getSize() {
        return size;
    }
    
    public String getStockQuantity() {
        return stockQuantity;
    }
    
    public String getGender() {
        return gender;
    }
    
    public String getDiscount() {
        return discount;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getDetail() {
        return detail;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    
    public void setDecription(String decription) {
        this.decription = decription;
    }
    
    public void setImg(String img) {
        this.img = img;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setDiscount(String discount) {
        this.discount = discount;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public Shoes(String name, String color, String brandId, String size, String gender) {
        this.name = name;
        this.color = color;
        this.brandId = brandId;
        this.size = size;
        this.gender = gender;
    }
    
    public String getShoesCode() {
        if (this.getGender().equals("1")) {
            return this.getBrandNameById(brandId) + "_" + this.getColor() + "_" + "Male" + "_" + this.getName() + "_" + this.getSize();
        } else {
            return this.getBrandNameById(brandId) + "_" + this.getColor() + "_" + "Female" + "_" + this.getName() + "_" + this.getSize();
        }
    }
    
    public String getShoesCodeWithoutSize() {
        if (this.getGender().equals("1")) {
            return this.getBrandNameById(brandId) + "_" + this.getColor() + "_" + "Male" + "_" + this.getName();
        } else {
            return this.getBrandNameById(brandId) + "_" + this.getColor() + "_" + "Female" + "_" + this.getName();
        }
    }
    
    public String getBrandNameById(String brandId) {
        AdminDao ad = new AdminDao();
        return ad.getBrandNameById(brandId);
    }
    
    public String getShoesPriceAfterDiscount() {
        Double ret = Double.parseDouble(price) * (1 - Double.parseDouble(discount));
        return String.valueOf(ret);
    }
    
    public String checkDiscount(){
        if(this.discount.equals("0.0")){
            return "0";
        }else{
            return "1";
        }
    }
}
