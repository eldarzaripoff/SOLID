package org.example;

public class ItemBuilder {
    protected String name;
    protected String model;
    protected int price;
    protected int dateOfDelivery;
    protected int quantity;

    public ItemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public ItemBuilder setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price can't be less than 0$");
        } else {
            this.price = price;
            return this;
        }
    }

    public ItemBuilder setDaysOfDelivery(int dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
        return this;
    }

    public ItemBuilder setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be less than 0$");
        } else {
            this.quantity = quantity;
            return this;
        }

    }

    public Item build() {
        Item item = new Item(name, model, price, dateOfDelivery, quantity);
        return item;
    }

}
