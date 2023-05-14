/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lathai
 */
public class CountTimeAccess {

    String shoesId, count;

    public CountTimeAccess(String shoesId, String count) {
        this.shoesId = shoesId;
        this.count = count;
    }

    public CountTimeAccess() {
    }

    public String getShoesId() {
        return shoesId;
    }

    public String getCount() {
        return count;
    }

    public void setShoesId(String shoesId) {
        this.shoesId = shoesId;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
