package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = Catalog.getInstance();
        Client client = Client.getInstance();
        client.info();
        List<Item> cat = catalog.loadCatalog();
        System.out.println(cat);
        //List<Item> order = catalog.loadOrderList();
        int switcher = 0;


        while ((switcher = client.clientInterface()) != 0) {
            int modNum = 0;
            int quantity = 0;
            switch (switcher) {
                case 1 -> {
                    for (Item item : cat) {
                        System.out.println(item.toString());
                    }
                    //catalog.showCatalog(cat);
                    }
                case 2 -> {
                    System.out.println("Type the minimal price");
                    modNum = client.clientInterface();
                    catalog.filterCatalogByPrice(modNum);
                }
                case 3 -> {
                    System.out.println("Type the maximal days of delivery");
                    modNum = client.clientInterface();
                    catalog.filterCatalogByDaysOfDelivery(modNum);
                }
                case 4 -> {
                    System.out.println("Type the serial number of item");
                    modNum = client.clientInterface() - 1;
                    System.out.println("Type the quantity of the items");
                    quantity = client.clientInterface();
                    //catalog.addItemInList(order.get(modNum), quantity);
                    catalog.removeItemFromList(cat.get(modNum), quantity);
                }
                case 5 -> {
                    System.out.println("Type the serial number of item");
                    modNum = client.clientInterface() - 1;
                    System.out.println("Type the quantity of the items");
                    quantity = client.clientInterface();
                    catalog.addItemInList(cat.get(modNum), quantity);
                    //catalog.removeItemFromList(order.get(modNum), quantity);
                }
                case 6 -> catalog.showCatalog(catalog.orderList);
                //case 7 -> catalog.finishToBuyItems(order);
                case 8 -> catalog.addRating();
            }

        }
    }
}