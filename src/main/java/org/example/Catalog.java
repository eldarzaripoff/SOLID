package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Catalog {
    private static Catalog catalog = null;

    protected static Catalog getInstance() {
        if (catalog == null) catalog = new Catalog();
        return catalog;
    }


    int totalSum = 0;
    Item filtronOP595 = new ItemBuilder()
            .setName("Filtron")
            .setModel("OP595")
            .setPrice(396)
            .setDaysOfDelivery(1)
            .setQuantity(10)
            .build();
    Item mannW6103 = new ItemBuilder()
            .setName("MANN")
            .setModel("W6103")
            .setPrice(695)
            .setDaysOfDelivery(2)
            .setQuantity(3)
            .build();
    Item sakuraC1823SBP = new ItemBuilder()
            .setName("SAKURA")
            .setModel("C1823SBP")
            .setPrice(395)
            .setDaysOfDelivery(2)
            .setQuantity(5)
            .build();
    Item sakuraC1821 = new ItemBuilder()
            .setName("SAKURA")
            .setModel("C1821")
            .setPrice(451)
            .setDaysOfDelivery(8)
            .setQuantity(2)
            .build();
    Item jsAsakashiC224J = new ItemBuilder()
            .setName("JS ASAKASHI")
            .setModel("C224J")
            .setPrice(482)
            .setDaysOfDelivery(6)
            .setQuantity(3)
            .build();

    public List<Item> loadCatalog() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(filtronOP595);
        itemList.add(mannW6103);
        itemList.add(sakuraC1821);
        itemList.add(sakuraC1823SBP);
        itemList.add(jsAsakashiC224J);
        return itemList;
    }

    public List<Item> loadOrderList(List<Item> list) {
        List<Item> orderList = new ArrayList<>();
        // Снизу выполняется принцип избегания магических чисел
        for (int i = 0; i < list.size(); i++) {
            orderList.add(list.get(i).clone());
        }
        for (int i = 0; i < orderList.size(); i++) {
            orderList.get(i).setQuantity(0);
        }
        System.out.println("Order list: ");
        for (Item item : orderList) {
            System.out.println(item.toString());
        }
        return orderList;
    }

    public void showCatalog(List<Item> itemList) {
        System.out.println("Welcome to our shop! We present to your attention high-quality oil filters:");
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
        System.out.println();
    }

    public void showOrderList(List<Item> orderList) {
        if (orderList.isEmpty()) {
            System.out.println("Your order list is empty");
        } else {
            System.out.println("Your order list:");
            for (Item item : orderList) {
                System.out.println(item.toString());
            }
            for (Item item : orderList) {
                totalSum += item.getPrice() * item.getQuantity();
            }
            System.out.println("Your payment amount is " + totalSum);
        }
    }

    public List<Item> filterCatalogByPrice(List<Item> list, int a) {
        Predicate<Item> byPrice = item -> item.getPrice() > a;
        List<Item> filteredList = list.stream().filter(byPrice).collect(Collectors.toList());
        for (Item item : filteredList) {
            System.out.println(item.toString());
        }
        System.out.println();
        return filteredList;
    }

    public List<Item> filterCatalogByDaysOfDelivery(List<Item> list, int a) {
        Predicate<Item> byDaysOfDelivery = item -> item.getDateOfDelivery() <= a;
        List<Item> filteredList = list.stream().filter(byDaysOfDelivery).collect(Collectors.toList());
        for (Item item : filteredList) {
            System.out.println(item.toString());
        }
        System.out.println();
        return filteredList;
    }

    public Item removeItemFromList(Item catalogItem, int num) {
        if (catalogItem.getQuantity() < num) {
            System.out.println("You can't buy such quantity!");
        } else {
            catalogItem.reduceQuantity(num);
        }
        return catalogItem;

    }

    public Item addItemInList(Item catalogItem, int num) {
        catalogItem.increaseQuantity(num);
        return catalogItem;
    }

    public List<Item> finishToBuyItems(List<Item> orderList) {
        if (orderList.isEmpty()) {
            System.out.println("Your order list is empty! Select the necessary oil filter");
        } else {
            System.out.println("Write your phone number. Our manager will call you during 5 minutes to clarify details of your order. Afterwards, top up your balance and get the letter with track-number to rack the package.");
            orderList.clear();
        }
        return orderList;
    }

}
