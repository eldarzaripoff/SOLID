package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = Catalog.getInstance();
        //Принцип single-responsibility продемонстрирован на примере класса Client
        Client client = Client.getInstance();
        client.info();
        List<Item> cat = catalog.loadCatalog();
        System.out.println(cat);
        List<Item> order = catalog.loadOrderList(cat);
        int switcher = 0;

        System.out.println("Total:");

        for (Item item : cat) {
            System.out.println(item.toString());
        }


        while ((switcher = client.clientInterface()) != 0) {
            int modNum = 0;
            switch (switcher) {
                case 1 -> catalog.showCatalog(cat);
                case 2 -> {
                    System.out.println("Type the minimal price");
                    modNum = client.clientInterface();
                    catalog.filterCatalogByPrice(cat, modNum);
                }
                case 3 -> {
                    System.out.println("Type the maximal days of delivery");
                    modNum = client.clientInterface();
                    catalog.filterCatalogByDaysOfDelivery(cat, modNum);
                }
                //Здесь выполняется метод DRY
                case 4 -> transfer(order, cat);
                case 5 -> transfer(cat, order);
                case 6 -> catalog.showOrderList(order);
                case 7 -> {
                    catalog.finishToBuyItems(order);
                    order = catalog.loadOrderList(cat);
                }

            }
        }
    }

    public static void transfer(List<Item> increasing, List<Item> decreasing) {
        //Благодаря этому методу, выполняется метод DRY
        Client client = Client.getInstance();
        Catalog catalog = Catalog.getInstance();
        System.out.println("Type the serial number of item");
        int modNum = client.clientInterface() - 1;
        System.out.println("Type the quantity of the items");
        int quantity = client.clientInterface();
        if (decreasing.get(modNum).equals(catalog.removeItemFromList(decreasing.get(modNum), quantity))) {
            catalog.addItemInList(increasing.get(modNum), quantity);
        }
    }
}