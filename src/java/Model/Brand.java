/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.AdminDao;
import DAO.ProductDao;

/**
 *
 * @author lathai
 */
public class Brand {

    String id;
    String img;
    String name;
    String detail;

    public Brand(String id, String img, String name, String detail) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.detail = detail;
    }

    public Brand(String img, String name, String detail) {
        this.img = img;
        this.name = name;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Brand() {
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String checkSameBrandName() {
        AdminDao ad = new AdminDao();
        return ad.checkSameBrandName(name);
    }
    
    public boolean checkSameBrandNameForAdd() {
        AdminDao ad = new AdminDao();
        return ad.checkSameBrandNameForAdd(name);
    }
    
    public String getIdByBrandName(String id){
        ProductDao pd = new ProductDao();
        return pd.getIdByBrandName(id);
    }

}
