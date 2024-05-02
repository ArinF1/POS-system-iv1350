package se.kth.iv1350.possystem.integration;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.possystem.model.Item;
import se.kth.iv1350.possystem.model.ItemDTO;
import se.kth.iv1350.possystem.model.Sale;

/**
 *External inventory system of all items with hard coded example items
 */
public class ExternalInventorySystem {
    private List<Item> storeItems = new ArrayList<>();
    private List<ItemDTO> itemDTOs = new ArrayList<>();
	
    public ExternalInventorySystem() {
	}
   
	/**
	 * Adds items to the store inventory.
	 * (ItemName, price, VAT, barcode)
	 */
	public void addItem() {
            this.itemDTOs.add(new ItemDTO("Apples 5kg", 130, 8,123)); 
            this.itemDTOs.add(new ItemDTO("Ketchup", 10, 5,234));
            this.itemDTOs.add(new ItemDTO("Fish 100g", 20, 6, 345));

            this.storeItems.add(new Item(1, itemDTOs.get(0), 100));
            this.storeItems.add(new Item(2, itemDTOs.get(1), 100));
            this.storeItems.add(new Item(3, itemDTOs.get(2), 100));
}

	/**
	 * Searches for an item in the inventory system using an identifier.
	 * @param barCode the item's identifier.
	 * @return Returns item if found, otherwise returns null.
	 */
	public Item search(int barCode) {
            for (Item item : storeItems) {
                if(item.getBarCode() == barCode) {
                    return item;
                }
            }
            return null;
	}

	/**
	 * Updates the inventory after a sale.
	 * @param sale The sale containing the sale information of what has been sold.
	 */
	public void update(Sale sale) {
            List<Integer> itemsQuantity = sale.getCustomerItemsQuantity();
            List<Item> items = sale.getItems();

            for (Item item : items) {
                for (Item item2 : storeItems) {
                    if (item == item2) {
                        storeItems.get(storeItems.indexOf(item2)).updateQuantity(itemsQuantity.get(items.indexOf(item)));
                    }
		}
            }
	}
}
