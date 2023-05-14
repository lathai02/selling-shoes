/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author lathai
 */
public class ImportHistory {

    String shoesId, quantity, dateAdd, id, timeAdd;

    public ImportHistory() {
    }

    public ImportHistory(String shoesId, String quantity, String dateAdd, String id, String timeAdd) {
        this.shoesId = shoesId;
        this.quantity = quantity;
        this.dateAdd = dateAdd;
        this.id = id;
        this.timeAdd = timeAdd;
    }

    public String getShoesId() {
        return shoesId;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public String getId() {
        return id;
    }

    public String getTimeAdd() {
        return timeAdd;
    }

    public void setShoesId(String shoesId) {
        this.shoesId = shoesId;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTimeAdd(String timeAdd) {
        this.timeAdd = timeAdd;
    }

    public ImportHistory(String shoesId, String quantity, String dateAdd, String timeAdd) {
        this.shoesId = shoesId;
        this.quantity = quantity;
        this.dateAdd = dateAdd;
        this.timeAdd = timeAdd;
    }
    
    public String getTime(){
        String timeRet[] = timeAdd.split("\\.");
        return timeRet[0];
    }
}
