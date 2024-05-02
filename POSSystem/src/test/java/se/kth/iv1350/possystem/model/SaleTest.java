/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.possystem.model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author arinh
 */
public class SaleTest {
    
    private Sale instance;
    
    public SaleTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new Sale();
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testGetItems() {
        List<Item> result = instance.getItems();
        assertTrue(result.isEmpty(), "The items list should be empty initially.");
    }

    @Test
    public void testGetCustomerItemsQuantity() {
        List<Integer> result = instance.getCustomerItemsQuantity();
        assertTrue(result.isEmpty(), "The customerItemsQuantity list should be empty initially.");
    }

    @Test
    public void testGetSaleInformation() {
        SaleDTO result = instance.getSaleInformation();
        assertNotNull(result, "The sale information should not be null.");
    }

    @Test
    public void testAddItem() {
        // Create an instance of ItemDTO
    String itemDescription = "Test Item";
    double price = 100.0;
    double VAT = 0.25; // 25% VAT
    int barCode = 123456; // example barcode
    ItemDTO itemDTO = new ItemDTO(itemDescription, price, VAT, barCode);

    // Create an instance of Item
    int itemIdentifier = 1; // example identifier
    int quantity = 10; // example quantity
    Item item = new Item(itemIdentifier, itemDTO, quantity);

    // Add the item to the sale
    instance.addItem(item, quantity);
    assertFalse(instance.getItems().isEmpty(), "The items list should not be empty after adding an item.");
    assertFalse(instance.getCustomerItemsQuantity().isEmpty(), "The customerItemsQuantity list should not be empty after adding an item.");
    }

    @Test
    public void testGetReceipt() {
        Receipt result = instance.getReceipt(instance);
        assertNotNull(result, "The receipt should not be null.");
    }
    
}
