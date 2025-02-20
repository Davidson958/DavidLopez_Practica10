package com.ddipractica10;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProductController {

    // Campos de texto para ingresar los datos del producto
    @FXML
    private TextField nameField; // Campo para el nombre del producto

    @FXML
    private TextField quantityField; // Campo para la cantidad del producto

    @FXML
    private TextField priceField; // Campo para el precio del producto

    // Vista de la lista de productos
    @FXML
    private ListView<String> productListView; // Lista que muestra los productos agregados

    // Etiqueta para mostrar mensajes de error o éxito
    @FXML
    private Label messageLabel;

    // Servicio que maneja la lógica de los productos
    private ProductService productService;

    // Lista observable que está vinculada con la interfaz de usuario
    private ObservableList<String> productObservableList;

    // Método que se ejecuta cuando la vista se inicializa
    @FXML
    public void initialize() {
        // Inicializa el servicio de productos y la lista observable
        productService = new ProductService();
        productObservableList = FXCollections.observableArrayList();

        // Asocia la lista observable con la vista del ListView
        productListView.setItems(productObservableList);
    }

    // Método para agregar un producto cuando se hace clic en el botón "Agregar"
    @FXML
    private void handleAddProduct(ActionEvent event) {
        // Obtiene los valores de los campos de texto
        String name = nameField.getText();
        int quantity;
        double price;

        // Maneja posibles errores de formato en la cantidad y el precio
        try {
            quantity = Integer.parseInt(quantityField.getText()); // Convierte la cantidad a entero
            price = Double.parseDouble(priceField.getText()); // Convierte el precio a decimal
        } catch (NumberFormatException e) {
            // Si ocurre un error en la conversión, muestra un mensaje de error
            messageLabel.setText("Cantidad o precio inválidos.");
            return;
        }

        // Crea un nuevo objeto de tipo Product con los valores proporcionados
        Product product = new Product(name, quantity, price);

        // Intenta agregar el producto al servicio y actualizar la lista
        if (productService.addProduct(product)) {
            // Si el producto se agrega correctamente, lo añade a la lista observable
            productObservableList.add(product.toString());
            messageLabel.setText("Producto agregado."); // Muestra un mensaje de éxito
            clearFields(); // Limpia los campos de texto
        } else {
            // Si no se puede agregar el producto, muestra un mensaje de error
            messageLabel.setText("Datos del producto inválidos.");
        }
    }

    // Método para eliminar un producto cuando se hace clic en el botón "Eliminar"
    @FXML
    private void handleDeleteProduct(ActionEvent event) {
        // Obtiene el índice del producto seleccionado en la lista
        int selectedIndex = productListView.getSelectionModel().getSelectedIndex();

        // Si hay un producto seleccionado, intenta eliminarlo
        if (selectedIndex >= 0) {
            // Intenta eliminar el producto desde el servicio
            if (productService.deleteProduct(selectedIndex)) {
                // Si se elimina correctamente, lo elimina de la lista observable
                productObservableList.remove(selectedIndex);
                messageLabel.setText("Producto eliminado.");
            } else {
                // Si ocurre un error al eliminar, muestra un mensaje de error
                messageLabel.setText("Error al eliminar producto.");
            }
        } else {
            // Si no hay un producto seleccionado, muestra un mensaje de advertencia
            messageLabel.setText("Seleccione un producto para eliminar.");
        }
    }

    // Método que limpia los campos de texto después de agregar un producto
    private void clearFields() {
        nameField.clear(); // Limpia el campo del nombre
        quantityField.clear(); // Limpia el campo de cantidad
        priceField.clear(); // Limpia el campo de precio
    }
}
