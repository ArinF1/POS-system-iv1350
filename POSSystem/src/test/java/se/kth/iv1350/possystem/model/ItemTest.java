package se.kth.iv1350.possystem.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    private Item item;
    private ItemDTO itemDTO;
    private int barCode = 1234;
    private int quantity = 10;
    private String itemName = "Test Item";
    private double price = 100.0;
    private double VAT = 0.25;

    @BeforeEach
    public void setUp() {
        itemDTO = new ItemDTO(itemName, price, VAT, barCode);
        item = new Item(barCode, itemDTO, quantity);
    }

    @AfterEach
    public void tearDown() {
        item = null;
        itemDTO = null;
    }

    @Test
    public void testGetItemDTO() {
        ItemDTO result = item.getItemDTO();
        assertEquals(itemDTO, result, "The returned ItemDTO was not the expected one.");
    }

    @Test
    public void testGetBarCode() {
        int result = item.getBarCode();
        assertEquals(barCode, result, "The returned barcode was not the expected one.");
    }

    @Test
    public void testGetStoreQuantity() {
        int result = item.getStoreQuantity();
        assertEquals(quantity, result, "The returned quantity was not the expected one.");
    }

    @Test
    public void testUpdateQuantity() {
        int amountSold = 2;
        item.updateQuantity(amountSold);
        int result = item.getStoreQuantity();
        assertEquals(quantity - amountSold, result, "The quantity was not updated correctly.");
    }
}
