package com.ddipractica10;

// Esta clase representa un producto con nombre, cantidad y precio.
public class Product {
    // Atributos de la clase Product
    private String name;     // Nombre del producto
    private int quantity;    // Cantidad disponible del producto
    private double price;    // Precio del producto

    // Constructor de la clase que inicializa los valores del producto
    public Product(String name, int quantity, double price) {
        this.name = name;     // Asignamos el nombre del producto
        this.quantity = quantity;  // Asignamos la cantidad disponible
        this.price = price;   // Asignamos el precio del producto
    }

    // Métodos getter y setter para acceder y modificar los atributos de la clase

    // Obtiene el nombre del producto
    public String getName() {
        return name;
    }

    // Establece un nuevo nombre para el producto
    public void setName(String name) {
        this.name = name;
    }

    // Obtiene la cantidad del producto
    public int getQuantity() {
        return quantity;
    }

    // Establece una nueva cantidad para el producto
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Obtiene el precio del producto
    public double getPrice() {
        return price;
    }

    // Establece un nuevo precio para el producto
    public void setPrice(double price) {
        this.price = price;
    }

    // Método toString que devuelve una representación del producto en forma de texto
    @Override
    public String toString() {
        // La representación del producto será el nombre seguido de la cantidad y el precio
        return name + " - Cantidad: " + quantity + ", Precio: " + price;
    }
}
