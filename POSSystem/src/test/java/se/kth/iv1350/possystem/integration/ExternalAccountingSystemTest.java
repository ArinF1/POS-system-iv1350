package se.kth.iv1350.possystem.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExternalAccountingSystemTest {
    private ExternalAccountingSystem instance;
    
    public ExternalAccountingSystemTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new ExternalAccountingSystem();
    }
    
    @AfterEach
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testUpdate() {
        double totalPrice = 50.0;
        double initialBalance = instance.getStoreBalance();
        instance.update(totalPrice);
        assertEquals(initialBalance + totalPrice, instance.getStoreBalance(), "The store balance should be updated correctly.");
    }
}
