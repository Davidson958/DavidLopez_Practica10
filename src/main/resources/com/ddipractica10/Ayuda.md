# Guía de Usuario e Instalación

## 📌 Guía de Uso

### 1. Inicio de la Aplicación
- Para ejecutar la aplicación, abre el archivo `MainApp.java` ubicado en `src/main/java/com/ddipractica10/` y ejecútelo desde tu entorno de desarrollo (por ejemplo, IntelliJ IDEA o Eclipse).
- Asegúrate de que todas las dependencias estén correctamente instaladas antes de la ejecución.

### 2. Funcionalidades Principales
- **Modelo**: `Product.java` representa la entidad de un producto, conteniendo sus atributos y métodos.
- **Controlador**: `ProductController.java` maneja la interacción entre la interfaz de usuario y la lógica de negocio.
- **Servicio**: `ProductService.java` implementa la lógica de negocio, como agregar, eliminar o modificar productos.

### 3. Interfaz de Usuario
- El archivo `ProductView.fxml` define la interfaz gráfica utilizando JavaFX.
- Puedes editar este archivo con Scene Builder para modificar la apariencia y disposición de la interfaz.

### 4. Pruebas y Seguridad
- Existen pruebas unitarias en `src/test/java/com/ddipractica10/`.
- `ProductServiceTest.java` valida la lógica de negocio.
- `SecurityTests.java` comprueba aspectos de seguridad de la aplicación.

---

## 🛠 Guía de Instalación

### 1. Requisitos Previos
Asegúrate de tener instalados los siguientes componentes antes de proceder con la instalación:
- **Java JDK 17 o superior** ([Descargar JDK](https://www.oracle.com/java/technologies/javase-downloads.html))
- **Maven** ([Descargar Maven](https://maven.apache.org/download.cgi)) o Gradle si prefieres ese gestor de dependencias.
- **Scene Builder** (opcional, si deseas modificar la UI) ([Descargar Scene Builder](https://gluonhq.com/products/scene-builder/))

### 2. Instalación y Configuración
1. **Clonar o descargar el proyecto**
   ```sh
   git clone <URL_DEL_REPOSITORIO>
   cd <NOMBRE_DEL_PROYECTO>
   ```
2. **Compilar e instalar dependencias**
   ```sh
   mvn clean install
   ```
3. **Ejecutar la aplicación**
   ```sh
   mvn javafx:run
   ```

### 3. Configuración Adicional (Opcional)
- Para modificar la interfaz, abre `ProductView.fxml` con Scene Builder.
- Para cambiar la configuración del proyecto, revisa el archivo `pom.xml` en la raíz del proyecto.

---

### ℹ️ Soporte
Si encuentras errores o necesitas ayuda, revisa la documentación del proyecto o contacta con el equipo de desarrollo.

