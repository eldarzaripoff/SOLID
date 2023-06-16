package org.example;

public class Item implements Cloneable {
    private final String name;
    private final String model;
    protected final int price;
    protected final int dateOfDelivery;
    protected double rating;
    protected int totalRating;
    protected int numberCounter = 0;
    protected int ratingCounter = 0;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected int reduceQuantity(int difference) {
        this.quantity -= difference;
        return quantity;
    }

    protected int increaseQuantity(int summer) {
        this.quantity += summer;
        return quantity;
    }

    public int buyItem(int quantity) {
        if (quantity > 0) {
            this.quantity -= quantity;
            return quantity;
        } else {
            System.out.println("There is empty");
            return quantity;
        }
    }

    public int addItem(int quantity) {
        this.quantity += quantity;
        return quantity;
    }

    public Item(String name, String model, int price, int dateOfDelivery, int quantity) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.dateOfDelivery = dateOfDelivery;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getDateOfDelivery() {
        return dateOfDelivery;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        numberCounter++;
        this.rating = rating;
        ratingCounter += rating;
    }

    public int getTotalRating() {
        totalRating = ratingCounter / numberCounter;
        return totalRating;
    }


    @Override
    public String toString() {
        return "Item{" +
                "name= '" + name + '\'' +
                ", model= '" + model + '\'' +
                ", price= " + price + " RUB" +
                ", dateOfDelivery= " + dateOfDelivery + " days" +
                ", quantity= " + quantity + " pcs" +
                ", totalRating= " + totalRating +
                '}';
    }

    @Override
    public Item clone() {
        try {
            //Благодаря тому, что класс Item имплементирует интерфейс Cloneable, не изменяя какие-либо стандартные сущестувующие классы
            Item clone = (Item) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public boolean equals(Item item) {
        if (item == null) return false;
        return quantity == item.getQuantity();
    }
}
