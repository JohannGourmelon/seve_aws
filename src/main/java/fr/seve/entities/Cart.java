package fr.seve.entities;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Long, CartItem> items = new HashMap<>();

    public void addItem(Box box) {
        CartItem item = items.get(box.getId());
        if (item == null) {
            items.put(box.getId(), new CartItem(box, 1));
        } else {
            item.setQuantity(item.getQuantity() + 1);
        }
    }

    public void updateQuantity(Long boxId, int quantity) {
        CartItem item = items.get(boxId);
        if (item != null) {
            if (quantity <= 0) {
                items.remove(boxId);
            } else {
                item.setQuantity(quantity);
            }
        }
    }

    public void removeItem(Long boxId) {
        items.remove(boxId);
    }

    public Map<Long, CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.values().stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }
}
