package se.kth.iv1350.possystem.controller;

import se.kth.iv1350.possystem.integration.ExternalAccountingSystem;
import se.kth.iv1350.possystem.integration.ExternalInventorySystem;
import se.kth.iv1350.possystem.integration.Printer;
import se.kth.iv1350.possystem.model.Item;
import se.kth.iv1350.possystem.model.Sale;
import se.kth.iv1350.possystem.model.SaleDTO;

/**
 * The controller class of the POS system which handle communication
 * between view, model, and external systems
 */
public class Controller {
    private ExternalAccountingSystem accounting;
    private ExternalInventorySystem inventory;
    private Printer printer; 
    private Sale sale;
    
    
    /**
	 * Creats instance of the controller object.
	 * @param printer external system to print receipt
	 * @param accounting external accounting system.
	 * @param inventory external inventory system.
	 */
    public Controller(Printer printer, ExternalAccountingSystem accounting, ExternalInventorySystem inventory) {
        this.printer = printer;
        this.accounting = accounting;
        this.inventory = inventory;
        inventory.addItem();
    }
    
    /**
	 * Starts a new sale, first method to be called when starting a sale
	 * @return getSaleInformation returns the information of the sale
	 */
    public SaleDTO startSale() {
        this.sale = new Sale();
        return sale.getSaleInformation();
    }
    
    /**
     * Adds an item to the sale by scanningen the barcode.
     * @param barCode a bar code which identifies an item
     * @param quantity The amount of the a single item a customer is buying
     * @return SaleDTO, 
     */
    public SaleDTO enterItem(int barCode, int quantity) {
    	Item item = inventory.search(barCode);
    	if(item == null){
            return null;
        }
    	if(item.getStoreQuantity() >= quantity) {
            sale.addItem(item, quantity);
    	}
        
        else {
            return null;
    	}
        
    	return this.sale.getSaleInformation();
    }
    
    /**
	 * Ends a sale is called when all items has been scanned.
	 * @return a SaleDTO is being returned with information about the sale
	 */
    public SaleDTO endSale() {
    	inventory.update(this.sale);
    	return this.sale.getSaleInformation();
    }
    
    /**
	 * Calculates change and updates the ecternal accounting system
	 * @param amount describes the amount paid by the customer
	 * @return change amount of change the customer should receive
	 */
    public double pay(double amount,  double totalPrice) {
    	double change = amount - totalPrice;
    	
    	if(change >= 0){
    		this.accounting.update(amount - change);
    	}
        else{
            System.out.println("To little money");
        }
    	return change;
        
    }
    
    /**
     * printer prints the receipt for the sale.
     */
    public void print() {
    	printer.print(this.sale.getReceipt(sale));
    }
}
