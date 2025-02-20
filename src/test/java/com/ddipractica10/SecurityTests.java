package com.ddipractica10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityTests {

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void testValidateProductNameNotEmpty() {
        Product product = new Product("  ", 10, 100.0);
        assertFalse(productService.validateProduct(product));
    }

    @Test
    public void testValidateProductQuantityNonNegative() {
        Product product = new Product("Producto E", -1, 50.0);
        assertFalse(productService.validateProduct(product));
    }

    @Test
    public void testValidateProductPriceNonNegative() {
        Product product = new Product("Producto F", 5, -10.0);
        assertFalse(productService.validateProduct(product));
    }

    @Test
    public void testValidateNullProduct() {
        assertFalse(productService.validateProduct(null));
    }

    @Test
    public void testValidateProductSuccess() {
        Product product = new Product("Producto G", 5, 25.0);
        assertTrue(productService.validateProduct(product));
    }
}
