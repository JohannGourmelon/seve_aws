package fr.seve.entities;

public class CartItem {
    private Box box;
    private int quantity;

    public CartItem(Box box, int quantity) {
        this.box = box;
        this.quantity = quantity;
    }

    public Box getBox() {
        return box;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return box.getPrice() * quantity;
    }
}

