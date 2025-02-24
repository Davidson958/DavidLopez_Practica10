package com.ddipractica10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void testAddValidProduct() {
        Product product = new Product("Producto A", 10, 99.99);
        assertTrue(productService.addProduct(product));
        assertEquals(1, productService.getProducts().size());
    }

    @Test
    public void testAddInvalidProduct() {
        Product product = new Product("", -5, -10.0);
        assertFalse(productService.addProduct(product));
        assertEquals(0, productService.getProducts().size());
    }

    @Test
    public void testEditProduct() {
        Product product = new Product("Producto B", 5, 50.0);
        productService.addProduct(product);
        Product updatedProduct = new Product("Producto B Modificado", 8, 55.0);
        assertTrue(productService.editProduct(0, updatedProduct));
        assertEquals("Producto B Modificado", productService.getProducts().get(0).getName());
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product("Producto C", 3, 30.0);
        productService.addProduct(product);
        assertTrue(productService.deleteProduct(0));
        assertEquals(0, productService.getProducts().size());
    }

    @Test
    public void testEditProductWithInvalidIndex() {
        Product product = new Product("Producto D", 2, 20.0);
        productService.addProduct(product);
        Product updatedProduct = new Product("Producto D Modificado", 4, 25.0);
        assertFalse(productService.editProduct(5, updatedProduct));
    }

    @Test
    public void testDeleteProductWithInvalidIndex() {
        Product product = new Product("Producto X", 1, 15.0);
        productService.addProduct(product);
        assertFalse(productService.deleteProduct(5)); // Intento de eliminar un índice inexistente
    }

    @Test
    public void testEditProductWithInvalidValues() {
        Product product = new Product("Producto Y", 3, 50.0);
        productService.addProduct(product);
        Product updatedProduct = new Product("", -1, -5.0);
        assertFalse(productService.editProduct(0, updatedProduct));
    }

    @Test
    public void testAddLargeNumberOfProducts() {
        for (int i = 0; i < 1000; i++) {
            assertTrue(productService.addProduct(new Product("Producto " + i, i, i * 10.0)));
        }
        assertEquals(1000, productService.getProducts().size());
    }

    // NUEVAS PRUEBAS AÑADIDAS

    @Test
    public void testDeleteProductFromEmptyList() {
        assertFalse(productService.deleteProduct(0)); // No debería permitir eliminar en una lista vacía
    }

    @Test
    public void testEditProductInEmptyList() {
        Product updatedProduct = new Product("Producto Modificado", 10, 100.0);
        assertFalse(productService.editProduct(0, updatedProduct)); // No debería permitir la edición en una lista vacía
    }

    @Test
    public void testAddDuplicateProductCaseInsensitive() {
        Product product1 = new Product("Producto Duplicado", 5, 45.0);
        Product product2 = new Product("producto duplicado", 3, 30.0); // Diferente capitalización

        assertTrue(productService.addProduct(product1));
        assertFalse(productService.addProduct(product2)); // Debería detectarse como duplicado
    }

    @Test
    public void testAddSimilarButNotDuplicateProduct() {
        Product product1 = new Product("Producto XYZ", 10, 100.0);
        Product product2 = new Product("Producto XYZ 2", 5, 50.0);

        assertTrue(productService.addProduct(product1));
        assertTrue(productService.addProduct(product2)); // Debería permitirlo, ya que no es idéntico
    }

    @Test
    public void testGetProductsReturnsImmutableList() {
        Product product = new Product("Producto H", 5, 50.0);
        productService.addProduct(product);

        // Intentar modificar la lista desde fuera
        productService.getProducts().clear();

        // Asegurar que la lista interna sigue intacta
        assertEquals(1, productService.getProducts().size());
    }

    @Test
    public void testAddProductWithNullName() {
        Product product = new Product(null, 10, 50.0);
        assertFalse(productService.addProduct(product));
    }
}
