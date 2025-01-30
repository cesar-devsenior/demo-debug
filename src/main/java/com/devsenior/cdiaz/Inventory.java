package com.devsenior.cdiaz;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        try {
            var currentProduct = getProductByName(product.getName());

            var newQuantity = currentProduct.getStock() + product.getStock();
            var newPrice = (currentProduct.getStock() * currentProduct.getPrice()
                    + product.getStock() * product.getPrice()) / newQuantity;

            currentProduct.setStock(newQuantity);
            // El precio no puede ser cambiado
            currentProduct.setPrice(newPrice);
        } catch (NotFoundException e) {
            products.add(product);
        }
    }

    public void sellProduct(String name, Integer quantity) throws NotFoundException {
        // Producto existe
        var product = getProductByName(name);

        // Hay cantidad suficiente
        if (product.getStock() < quantity) {
            // No hay cantidad suficiente
            throw new NotEnoughQuantityException("El producto '" + name + "' no tiene cantidad suficiente");
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

    private Product getProductByName(String name) throws NotFoundException {
        for (var product : products) {
            if (name.equalsIgnoreCase(product.getName())) {
                return product;
            }
        }
        throw new NotFoundException("Producto '" + name + "' existe en el inventario");
    }

}
