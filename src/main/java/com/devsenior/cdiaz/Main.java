package com.devsenior.cdiaz;

public class Main {
    public static void main(String[] args) {
        var inventory = new Inventory();
        inventory.addProduct(new Product("Laptop", 10, 3000));
        inventory.addProduct(new Product("Phone", 0, 600));
        inventory.addProduct(new Product("laptop", 5, 1500));

        inventory.sellProduct("laptop", 5);
        inventory.sellProduct("phone", 1);
        inventory.sellProduct("tablet", 2);
        inventory.sellProduct("LAPTOP", 6);


        var total = inventory.calculateTotalInventory();
        System.out.printf("Valor total del inventaro es: $ %.2f%n", total);
    }
}