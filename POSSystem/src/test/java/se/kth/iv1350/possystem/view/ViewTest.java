
package se.kth.iv1350.possystem.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author arinh
 */
public class ViewTest {
    
    public ViewTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testRunFakeExecution() {
        System.out.println("runFakeExecution");
        View instance = null;
        instance.runFakeExecution();
        fail("The test case is a prototype.");
    }
    
}
