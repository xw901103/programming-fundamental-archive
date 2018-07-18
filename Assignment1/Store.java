/**
 * @author Xu Waycell, Way Studios
 * @date 24th Oct
 */
import java.util.*;

/**
 * Class Store will maintain Customer, Item and Gift and handle all sale and redeem functions.
 * @see Item
 * @see Gift
 * @see Customer
 * @author Xu Waycell, Way Studios
 */
public class Store
{   
    /**
     * The name of the store
     */
    String name;
    /**
     * Total sales of the store
     */
    int saleCount;
    /**
     * Total gifts redeemed of the store
     */
    int redeemCount;
    /**
     * The container of customers in the store, index by name
     * @see Customer
     */
    Map<String, Customer> customerMap;
    /**
     * The container of items in the store, index by name
     * @see Item
     */
    Map<String, Item> itemMap;
    /**
     * The container of gifts in the store, index by name
     * @see Gift
     */
    Map<String, Gift> giftMap;

    /**
     * Default constructor to initial a store instance with all default settings
     */
    public Store()
    {
        name = new String("Untitled Store");
        saleCount = 0;
        redeemCount = 0;
        customerMap = new HashMap<String, Customer>();
        itemMap = new HashMap<String, Item>();
        giftMap = new HashMap<String, Gift>();
    }
    
    /**
     * Get the name of store
     * @return The name of store
     */
    public String getName(){
        return name;
    }
    
    /**
     * Set a new name to store
     * @param  newName   The store's new name
     */
    public void setName(String newName){
        name = newName;
    }
    
    /**
     * Alternative method to get current name of the store
     * @see getName()
     * @return     the store name
     */
    public String storeName(){
        return getName();
    }
    
    /**
     * Create a new customer by given name to the store
     * @see Customer#Customer(String)
     * @param   customerName    The name of customer
     * @return     Return a customer object that has been created and added to the store
     */
    public Customer createCustomer(String customerName){
        Customer customer = new Customer(customerName);
        customerMap.put(customerName, customer);
        log(String.format("Customer %s has been add to store \n", customer.getName()));
        return customer;
    }
    
    /**
     * Remove a existing customer by given name in store.
     * @param   customerName    The name of customer
     * @return                  Return true if remove a existing customer from store successfully or false when fail
     */
    public boolean removeCustomer(String customerName){
        if(customerMap.remove(customerName) != null){
            log(String.format("Customer %s has been removed from store \n", customerName));
            return true;
        }
        return false;
    }
    
    /**
     * Find a existing customer by given name in store
     * @param   customerName    The name of customer
     * @return                  Return customer that found or null when fail
     */
    public Customer findCustomer(String customerName){
        return customerMap.get(customerName);
    }
    
    /**
     * Create a new item by given name to store
     * @see Item#Item(String)
     * @param   itemName    The name of item
     * @return              Return a item object that has been created and added to the store
     */
    public Item createItem(String itemName){
        Item item = new Item(itemName);
        itemMap.put(itemName, item);
        log(String.format("Item %s has been add to store \n", item.getName()));
        return item;
    }
    
    /**
     * Remove a existing item by given name in store
     * @param   itemName    The name of item
     * @return              Return true if remove a existing item from store successfully or false when fail
     */
    public boolean removeItem(String itemName){
        if(itemMap.remove(itemName) != null){
            log(String.format("Item %s has been removed from store \n", itemName));
            return true;
        }
        return false;
    }
    
    /**
     * Find a existing item by given name in store
     * @param   itemName    The name of item
     * @return              Return item that found or null when fail
     */
    public Item findItem(String itemName){
        return itemMap.get(itemName);
    }

    /**
     * Create a new gift by given name to store
     * @see Gift#Gift(String)
     * @param   giftName    The name of gift
     * @return              Return a gift object that has been created and added to store
     */
    public Gift createGift(String giftName){
        Gift gift = new Gift(giftName);
        giftMap.put(giftName, gift);
        log(String.format("Gift %s has been add to store \n", gift.getName()));
        return gift;
    }
    
    /**
     * Remove a existing gift by given name in store
     * @param   giftName    The name of gift
     * @return              Return true if remove a existing gift from store successfully or false when fail
     */
    public boolean removeGift(String giftName){
        if(giftMap.remove(giftName) != null){
            log(String.format("Gift %s has been removed from store \n", giftName));
            return true;            
        }
        return false;
    }
    
    /**
     * Find a existing gift by given name in store
     * @param   giftName    The name of gift
     * @return              Return gift that found or null when fail
     */
    public Gift findGift(String giftName){
        return giftMap.get(giftName);
    }
    
    /**
     * Sale item in given quantity to a customer
     * @param customer  The customer who will purchase the item
     * @param item      The item which will be sold
     * @param quantity  The quantity of item
     * @return          Return true if success or false when fail
     */
    public boolean saleItemToCustomer(Customer customer, Item item, int quantity){
       log(String.format("Sale Item %s To Customer %s with Quantity %d ", item.getName(), customer.getName(), quantity));
       if(customer.purchaseItem(item, quantity)){
           saleCount += quantity;
           if(customer.customerGroup()!=Customer.Group.VIP && customer.getPurchaseCount() >= 5){
               customer.setGroup(Customer.Group.VIP);
           }
           log("SUCCESS \n");
           return true;
        }
        log("FAIL \n");
        return false;
    }
    
    /**
     * Redeem gift in given quantity to a customer
     * @see Customer
     * @see Customer#redeemGift(Gift, int)
     * @see Gift
     * @see Gift#redeem(int)
     * @param customer  The customer who will redeem the gift
     * @param gift      The gift which will be redeemed
     * @param quantity  The quantity of gift
     * @return          Return true if success or false when fail
     */
    public boolean redeemGiftToCustomer(Customer customer, Gift gift, int quantity){
       log(String.format("Redeem Gift %s To Customer %s with Quantity %d ", gift.getName(), customer.getName(), quantity));
       if(customer.redeemGift(gift, quantity)){
           redeemCount += quantity;
           log("SUCCESS \n");
           return true;
        }
        log("FAIL \n");
        return false;
    }
    
    /**
     * Return the item sold count in the store
     * @return The count number of items have been sold from the store
     */
    public int getSaleCount(){
        return saleCount;
    }
    
    /**
     * Return the gift redeemed count in the store
     * @return the count number of gifts have been redeemed from the store
     */
    public int getRedeemCount(){
        return redeemCount;
    }
    
    /**
     * Generate a report of customer status of all customers in store
     */
    public void listCustomers(){
        log("List Customers BEGIN\n");
        Iterator iterator = customerMap.entrySet().iterator();
        /*
         * Iteration of customers to obtain information of customer
         */
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            Customer customer = (Customer)pair.getValue();
            String group = "UNKNOW";
            /*
             * Indentify customer group
             */
            switch(customer.getGroup()){
                case DEFAULT:
                    group = "DEFAULT";
                    break;
                case VIP:
                    group = "VIP";
                    break;
            }
            log(String.format("Customer: %s Group: %s Cash Balance: %f Point: %f Total Purchase: %d Total Redeem: %d \n", customer.getName(), group, customer.currentCashBalance(), customer.currentPointBalance(), customer.getPurchaseCount(), customer.getRedeemCount()));
        }
        log("List Customers END\n");
    }
    
    /**
     * Generate a report of item status of all items in store
     */
    public void listItems(){
        log("List Items BEGIN\n");
        Iterator iterator = itemMap.entrySet().iterator();
        /*
         * Iteration of items to obtain information of item
         */
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            Item item = (Item)pair.getValue();
            log(String.format("Item: %s Price: %f Reward Point: %f Total Sale: %d Available: %b \n", item.getName(), item.currentPrice(), item.rewardPoint(), item.getSaleCount(), item.isAvailable()));
        }
        log("List Items END\n");
    }

    /**
     * Generate a report of gift status of all gifts in store
     */
    public void listGifts(){
        log("List Gifts BEGIN\n");
        Iterator iterator = giftMap.entrySet().iterator();
        /*
         * Iteration of gifts to obtain information of gift
         */
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            Gift gift = (Gift)pair.getValue();
            log(String.format("Gift: %s Point: %f Total Redeem: %d Available: %b \n", gift.getName(), gift.currentPoint(), gift.getRedeemCount(), gift.isAvailable()));
        }
        log("List Gifts END\n");
    }
    
    /**
     * Generate store status include customers list, items list, gifts list and basic sale and redeem count of store
     */
    public void generateReport(){
        log("Store Report BEGIN");
        listCustomers();
        listItems();
        listGifts();
        log(String.format("Store: %s Total Sale: %d Total Redeem: %d \n", getName(), getSaleCount(), getRedeemCount()));
        log("Store Report END");
    }
    
    /**
     * Log the given message
     * @param message The message
     */
    public void log(String message){
        System.out.println(message);
    }
}
