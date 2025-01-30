package com.devsenior.cdiaz;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void sellProduct(String name, Integer quantity) {
        // Producto existe
        var product = getProductByName(name);

        // Hay cantidad suficiente
        if (product.getStock() < quantity) {
            // No hay cantidad suficiente
        }

        product.setStock(product.getStock() - quantity);
    }

    public Double calculateTotalInventory() {
        var total = 0d;

        for (var product : products) {
            total += product.getStock() * product.getPrice();
        }

        return total;
    }

    private Product getProductByName(String name) {
        for (var product : products) {
            if(name.equals(product.getName())){
                return product;
            }
        }
        return null;
    }

}
