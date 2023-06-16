package org.example;

import java.util.Scanner;

public class Client {
    private static Client client = null;

    protected static Client getInstance() {
        if (client == null) client = new Client();
        return client;
    }

    Scanner scanner = new Scanner(System.in);

    public int clientInterface() {
        int a = scanner.nextInt();
        return a;
    }

    public void info() {
        System.out.println("You are in the auto repair parts shop!\n" +
                "If you want to leave the shop, press 0\n" +
                "If you want to see our catalog, press 1\n" +
                "If you want to filter catalog by item price, press 2\n" +
                "If you want to filter catalog by date of delivery, press 3\n" +
                "If you want to add item to your order list, press 4\n" +
                "If you want to remove the item from order list, press 5\n" +
                "If you want to see your order list, press 6\n" +
                "If you want to buy items, press 7\n");
    }
}
