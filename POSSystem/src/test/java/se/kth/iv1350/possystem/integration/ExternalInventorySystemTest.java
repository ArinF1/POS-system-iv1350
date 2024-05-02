package se.kth.iv1350.possystem.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.possystem.model.Item;
import se.kth.iv1350.possystem.model.ItemDTO;
import se.kth.iv1350.possystem.model.Sale;

import java.util.ArrayList;
import java.util.List;

public class ExternalInventorySystemTest {
    private ExternalInventorySystem instance;
    private ItemDTO itemDTO;
    private int barCode = 123;
    private String itemName = "Apples 5 kg";
    private double price = 130.0;
    private double VAT = 8;
    private Sale sale;
    private List<Item> items;
    private List<Integer> itemsQuantity;

    @BeforeEach
    public void setUp() {
        instance = new ExternalInventorySystem();
        itemDTO = new ItemDTO(itemName, price, VAT, barCode);
        items = new ArrayList<>();

        items.add(new Item(barCode, itemDTO, 10));
        itemsQuantity = new ArrayList<>();
        itemsQuantity.add(5);
        sale = new Sale();
        sale.addItem(new Item(barCode, itemDTO, 10), 5);
    }

    @AfterEach
    public void tearDown() {
        instance = null;
        itemDTO = null;
        sale = null;
        items = null;
        itemsQuantity = null;
    }

    @Test
    public void testAddItem() {
        instance.addItem();
        Item result = instance.search(barCode);
        assertNotNull(result, "The item was not added correctly.");
    }

    @Test
    public void testSearch() {
        instance.addItem();
        Item result = instance.search(barCode);
        assertEquals(barCode, result.getBarCode(), "The search did not return the correct item.");
    }

    @Test
    public void testUpdate() {
        instance.addItem();
        instance.update(sale);
        Item result = instance.search(barCode);
        assertEquals(100, result.getStoreQuantity(), "The quantity was not updated correctly.");
    }
}