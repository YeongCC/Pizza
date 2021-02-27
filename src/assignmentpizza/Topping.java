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
public class Topping extends Pizza {

    int price;
    int topping[] = new int[3];

    public Topping() {
    }
    //1            //1     

    public Topping(int size, int P, int S, int M) {//constructor
        super.size = size;
        this.price = price;
        setTopping1(P);
        setTopping2(S);
        setTopping3(M);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTopping1(int P) {
        topping[0] = P;
    }

    public void setTopping2(int S) {
        topping[1] = S;
    }

    public void setTopping3(int M) {
        topping[2] = M;
    }

    public int getToppingPrice() {
        if (this.topping[0] == 1) {
            this.price += 2;
        }
        if (this.topping[1] == 2) {
            this.price += 2;
        }
        if (this.topping[2] == 3) {
            this.price += 2;
        }
        return price;
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    public String getTopping() {
        String p = "";
        String s = "";
        String m = "";

        if (this.topping[0] == 1) {
            p = "\n                               Pepperoni -RM2";

        } else {
            p = "";
        }
        if (this.topping[1] == 2) {
            s = "\n                               Sasauge -RM2";

        } else {
            s = "";
        }
        if (this.topping[2] == 3) {
            m = "\n                               Mushroom -RM2";

        } else {
            m = "";
        }
        return p + s + m;
    }

    public int getTotal() {
        int total = super.price + this.price;
        return total;
    }

    @Override
    public String toString() {
        String msg = "";
        if (this.getTopping().equals("")) {
            msg = super.getSizeName()+"\n";
        } else {
            msg = super.getSizeName() + "\nSelected topping :" + this.getTopping() + "\n";
        }
        return msg;
    }

}
