package se.kth.iv1350.possystem.view;

import se.kth.iv1350.possystem.controller.Controller;
import se.kth.iv1350.possystem.model.SaleDTO;

/**
 * The View of the program which runs a runFakeExecution task.
 */
public class View {
    private Controller contr;
    private double runningTotal;
   
    
    
    /**
     * Creates a new instance, that uses the specified controller for all calls to other layers.
     * 
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * Performs a fake sale by calling all system operations in the controller.
     */
    public void runFakeExecution() {
    	contr.startSale();
    	System.out.println("Starting a new sale");
        
        System.out.println("Scan items");
        
        
    	SaleDTO saleDTO = contr.enterItem(1, 10);
        System.out.println("Item ID: " + saleDTO.getItems().get(0).getItemDTO().getBarCode());
        
        System.out.println("Item: " + saleDTO.getItems().get(0).getItemDTO().getItemName() + " " +  saleDTO.getItems().get(0).getItemDTO().getPrice() + " SEK");
        runningTotal += saleDTO.getItems().get(0).getItemDTO().getPrice();
        System.out.println("Running total includning VAT: " + runningTotal + " SEK");
        System.out.println("Item VAT: " + saleDTO.getItems().get(0).getItemDTO().getVAT() + "SEK\n");
        
    	saleDTO = contr.enterItem(2, 1);
        System.out.println("Item ID: " + saleDTO.getItems().get(1).getItemDTO().getBarCode()+ "\n");
        System.out.println("Item: " + saleDTO.getItems().get(1).getItemDTO().getItemName() + " " +  saleDTO.getItems().get(1).getItemDTO().getPrice() + " SEK");
        runningTotal += saleDTO.getItems().get(1).getItemDTO().getPrice();
        System.out.println("Running total: " + runningTotal + " SEK");
        System.out.println("Item VAT: " + saleDTO.getItems().get(1).getItemDTO().getVAT() + "SEK\n");


    	
    	contr.endSale();
        System.out.println("Sale ended\n");
    	double change = contr.pay(200, runningTotal);
        System.out.println("--------Receipt--------");
    	contr.print();
        System.out.println("Change: " + change + " SEK");

        
        
   
    }
}