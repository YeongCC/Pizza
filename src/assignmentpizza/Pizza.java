/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentpizza;

/**
 *
 * @author User
 */
public class Pizza {

    int size, price;

    public Pizza() {
        setSize(size);
    }

    public Pizza(int size, int price) {
        setSize(size);
        setPrice(price);
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        switch (size) {
            case 1:
                this.price += 8;
                break;
            case 2:
                this.price += 10;
                break;
            case 3:
                this.price += 12;
                break;
        }
        return this.price;
    }

    public String getSizeName() {
        String s = "";
        switch (size) {
            case 1:
                s = "Small Pizza -RM8";
                break;
            case 2:
                s = "Medium Pizza -RM10";
                break;
            case 3:
                s = "Big Pizza -RM12";
                break;
        }
        return s;
    }
}
