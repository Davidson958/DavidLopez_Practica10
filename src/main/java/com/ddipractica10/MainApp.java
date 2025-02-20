package com.ddipractica10;

// Importamos las clases necesarias de JavaFX para crear la interfaz de usuario y manejar la ventana principal.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

// La clase MainApp extiende de la clase Application de JavaFX, lo que la convierte en una aplicación que puede ser ejecutada con el framework JavaFX.
public class MainApp extends Application {

    // El método start es el punto de entrada cuando la aplicación JavaFX se inicia.
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargamos la vista de la interfaz de usuario desde el archivo FXML "ProductView.fxml" utilizando FXMLLoader.
        // El archivo FXML define la estructura visual de la ventana.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductView.fxml"));

        // Creamos una nueva escena, que es básicamente la "pantalla" de nuestra aplicación, utilizando el contenido cargado desde el archivo FXML.
        Scene scene = new Scene(loader.load());

        // Establecemos el título de la ventana principal. Este será el nombre que aparecerá en la barra de título de la ventana.
        primaryStage.setTitle("Gestión de Stock");

        // Asociamos la escena a la ventana principal (el Stage), lo que hace que la escena sea visible.
        primaryStage.setScene(scene);

        // Finalmente, mostramos la ventana principal con la escena asignada.
        primaryStage.show();
    }

    // El método main es el punto de entrada de la aplicación en Java.
    // Llama al método launch() que, a su vez, inicia el ciclo de vida de la aplicación JavaFX.
    public static void main(String[] args) {
        // Lanza la aplicación JavaFX, pasando los argumentos desde la línea de comandos.
        launch(args);
    }
}
