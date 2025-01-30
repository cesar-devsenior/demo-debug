package com.devsenior.cdiaz;

import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        var log = LoggerFactory.getLogger(Main.class);
        log.trace("inicia la ejecución del programa");

        log.info("Creando el inventario inicial");
        var inventory = new Inventory();
        log.debug("Agregando el producto: {}, cantidad: {}, precio: {}",
                "Laptop", 10, 3000d);
        inventory.addProduct(new Product("Laptop", 10, 3000d));
        log.debug("Agregando el producto: {}, cantidad: {}, precio: {}",
                "Phone", 0, 600d);
        inventory.addProduct(new Product("Phone", 0, 600d));
        log.debug("Agregando el producto: {}, cantidad: {}, precio: {}",
                "laptop", 5, 1500d);
        inventory.addProduct(new Product("laptop", 5, 1500d));

        try {
            log.debug("Vendiendo el producto: 'laptop', cantidad: 5");
            inventory.sellProduct("laptop", 5);
            log.info("Se ha vendido 5 unidades de laptop");
        } catch (NotFoundException | NotEnoughQuantityException e) {
            log.error(e.getMessage(), e);
            System.err.println(e.getMessage());
        }
        try {
            log.debug("Vendiendo el producto: 'phone', cantidad: 1");
            inventory.sellProduct("phone", 1);
            log.info("Se ha vendido 1 unidad de phone");
        } catch (NotFoundException | NotEnoughQuantityException e) {
            log.error(e.getMessage(), e);
            System.err.println(e.getMessage());
        }
        try {
            log.debug("Vendiendo el producto: 'tablet', cantidad: 2");
            inventory.sellProduct("tablet", 2);
            log.info("Se ha vendido 2 unidades de tablet");
        } catch (NotFoundException | NotEnoughQuantityException e) {
            log.error(e.getMessage(), e);
            System.err.println(e.getMessage());
        }
        try {
            log.debug("Vendiendo el producto: 'LAPTOP', cantidad: 6");
            inventory.sellProduct("LAPTOP", 6);
            log.info("Se ha vendido 6 unidades de LAPTOP");
        } catch (NotFoundException | NotEnoughQuantityException e) {
            log.error(e.getMessage(), e);
            System.err.println(e.getMessage());
        }

        var total = inventory.calculateTotalInventory();
        System.out.printf("Valor total del inventaro es: $ %,.2f%n", total);
        log.debug("Valor total del inventaro es: $ {}",
                String.format("%,.2f", total));

        log.trace("Termina la ejecución del programa");
    }
}