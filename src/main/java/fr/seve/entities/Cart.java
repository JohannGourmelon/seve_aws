package fr.seve.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Box> items = new ArrayList<>();

    public void addItem(Box box) {
        items.add(box);
    }

    public List<Box> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}

