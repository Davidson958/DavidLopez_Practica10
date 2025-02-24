package com.ddipractica10;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    // Lista donde se almacenarán los productos
    private final List<Product> productList = new ArrayList<>();

    public List<Product> getProducts() {
        return new ArrayList<>(productList); // Assuming 'products' is the internal list
    }



    public boolean addProduct(Product product) {
        // Valida el producto antes de agregarlo a la lista
        if (validateProduct(product) && !isDuplicate(product)) {
            productList.add(product); // Agrega el producto a la lista si es válido y no está duplicado
            return true;
        }
        return false;
    }

    // Nuevo método para verificar si un producto ya existe en la lista
    private boolean isDuplicate(Product product) {
        for (Product existingProduct : productList) {
            if (existingProduct.getName().equalsIgnoreCase(product.getName())) {
                return true; // Producto duplicado
            }
        }
        return false; // No está duplicado
    }


    // Método para editar un producto en la lista dado un índice, con validaciones
    public boolean editProduct(int index, Product updatedProduct) {
        // Verifica que el índice sea válido y que el producto actualizado sea válido
        if (index >= 0 && index < productList.size() && validateProduct(updatedProduct)) {
            productList.set(index, updatedProduct); // Reemplaza el producto en el índice dado
            return true; // Retorna true si la edición es exitosa
        }
        return false; // Retorna false si no es posible editar el producto
    }

    // Método para eliminar un producto de la lista dado un índice
    public boolean deleteProduct(int index) {
        // Verifica que el índice sea válido
        if (index >= 0 && index < productList.size()) {
            productList.remove(index); // Elimina el producto en el índice dado
            return true; // Retorna true si la eliminación es exitosa
        }
        return false; // Retorna false si no es posible eliminar el producto
    }

    // Método de validación para asegurarse de que el producto sea válido
    public boolean validateProduct(Product product) {
        // Verifica que el producto no sea null
        if (product == null) return false;

        // Verifica que el nombre no sea null ni esté vacío
        if (product.getName() == null || product.getName().trim().isEmpty()) return false;

        // Verifica que la cantidad no sea negativa
        if (product.getQuantity() < 0) return false;

        // Verifica que el precio no sea negativo
        return !(product.getPrice() < 0); // Si el precio es negativo, retorna false
    }

    public void addProduct(String s, int i, double v) {
    }

    public List<Product> getAllProducts() {
        return null;
    }

    public void removeProduct(String auriculares) {

    }
}
