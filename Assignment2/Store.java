/**
 * Class Store will maintain Customer, Item and Gift and handle all sale and redeem functions.
 * @see Model
 * @see ModelStackArray<T>
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
    int salesCount;
    /**
     * Total sales value
     */
    double salesValue;
    /**
     * Total gifts redeemed of the store
     */
    int redeemCount;    
    /**
     * Total redeem value
     */
    int redeemValue;
    /**
     * the ioutility to handle and help all input and output tasks through terminal
     */
    private IOUtility ioutility;
    /**
     * The container of customers in the store
     * @see Customer
     */
    ModelStackArray<Customer> customers;
    /**
     * The container of items in the store
     * @see Item
     */
    ModelStackArray<Item> items;    
    /**
     * The container of gifts in the store
     * @see Gift
     */
    ModelStackArray<Gift> gifts;    

    /**
     * Default constructor to initial a Store instance with all default settings
     */
    public Store()
    {
        this.name = new String("Untitled Store");
        this.salesCount = 0;
        this.salesValue = 0.00;
        this.redeemCount = 0;
        this.redeemValue = 0;
        this.customers = new ModelStackArray<Customer>(128);
        this.items = new ModelStackArray<Item>(512);
        this.gifts = new ModelStackArray<Gift>(256);

        this.ioutility = new IOUtility();
    }

    /**
     * Set a new IOUtility object to handle and help all input and output tasks.</br>
     * <strong>There is no a method called getIOUtility because it is not necessary.</strong>
     * @param newIOUtility The new ioutility object will be using.
     */
    public void setIOUtility(IOUtility newIOUtility){
        this.ioutility = newIOUtility;
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
     * @return     The store name
     */
    public String storeName(){
        return getName();
    }

    /**
     * Obtain the total number of customers in the store
     * @return The total customer number
     */
    public int getTotalCustomers(){
        return this.customers.getTotal();
    }

    /**
     * Create a new customer by given name to the store
     * @see Customer#Customer(String)
     * @param   customerName    The name of customer
     * @return                  Return a customer object that has been created and added to the store
     */
    public Customer createCustomer(String customerName){
        if(this.customers.isFull()){
            this.ioutility.log("Store", "Out of customer array capacity\n");
            return null;
        }
        Customer customer = new Customer(customerName, this);
        this.customers.push(customer);
        this.ioutility.log("Store", String.format("Customer %s has been add to store \n", customer.getName()));
        return customer;
    }

    /**
     * Find a existing customer by given name in store
     * @param   customerName    The name of customer
     * @return                  Return customer that found or null when fail
     */
    public Customer findCustomerByName(String customerName){
        ModelStackArray<Customer>.Iterator iterator = this.customers.getIterator();
        while(iterator.hasNext()){
            Customer customer = iterator.next();
            //it will only return the object which owned by this store
            if(customer.getName().equals(customerName))
                if(customer.getStore() == this)
                    return customer;
        }
        return null;
    }

    /**
     * Find a existing customer by given name in store
     * This method is not case sensitive.
     * @param   customerName    The name of customer
     * @return                  Return customer that found or null when fail
     */
    public Customer findCustomerByNameIgnoreCase(String customerName){
        ModelStackArray<Customer>.Iterator iterator = this.customers.getIterator();
        while(iterator.hasNext()){
            Customer customer = iterator.next();
            //it will only return the object which owned by this store
            if(customer.getName().equalsIgnoreCase(customerName))
                if(customer.getStore() == this)
                    return customer;
        }
        return null;
    }

    /**
     * Obtain a customer object at given postion of array in the store
     * @param index The postion of customer array in the store
     * @return A customr object at given position or null when there is no one.
     */
    public Customer getCustomerByIndex(int index){
        return this.customers.at(index);
    }

    /**
     * Obtain the total number of items in the store
     * @return The total item number
     */
    public int getTotalItems(){
        return this.items.getTotal();
    }

    /**
     * Count and return a number of current total available items
     * @return The number of current total available items
     */
    public int getTotalAvailableItems(){
        int count = 0;
        ModelStackArray<Item>.Iterator iterator = this.items.getIterator();
        while(iterator.hasNext()){
            Item item = iterator.next();
            if(item.isAvailable())
                ++count;
        }
        return count;
    }

    /**
     * Create a new item by given name to store
     * @see Item#Item(String)
     * @param   itemName    The name of item
     * @return              Return a item object that has been created and added to the store
     */
    public Item createItem(String itemName){
        if(this.items.isFull()){
            this.ioutility.log("Store", "Out of item array capacity\n");
            return null;
        }
        //new policy for name here
        if(findItemByNameIgnoreCase(itemName) == null){
            Item item = new Item(itemName, this);
            this.items.push(item);
            this.ioutility.log("Store", String.format("Item %s has been add to store \n", item.getName()));
            return item;
        }
        this.ioutility.log("Store", String.format("Item %s exists in store \n", itemName));
        return null;
    }

    /**
     * Find a existing item by given name in store, This method is case sensitive
     * @param   itemName    The name of item
     * @return              Return item that found or null when fail
     */
    public Item findItemByName(String itemName){
        ModelStackArray<Item>.Iterator iterator = this.items.getIterator();
        while(iterator.hasNext()){
            Item item = iterator.next();
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    /**
     * Find a existing item by given name in store, This method is not case sensitive
     * @param   itemName    The name of item
     * @return              Return item that found or null when fail
     */
    public Item findItemByNameIgnoreCase(String itemName){
        ModelStackArray<Item>.Iterator iterator = this.items.getIterator();
        while(iterator.hasNext()){
            Item item = iterator.next();
            if(item.getName().equalsIgnoreCase(itemName))
                return item;
        }
        return null;
    }

    /**
     * Obtain an item object at given postion of array in the store
     * @param index The postion of item array in the store
     * @return An item object at given position or null when there is no one.
     */
    public Item getItemByIndex(int index){
        return this.items.at(index);
    }

    /**
     * Obtain total gifts count.
     * @return The total number of gifts inside the store
     */
    public int getTotalGifts(){
        return this.gifts.getTotal();
    }

    /**
     * Count and return a number of current total available gifts
     * @return The number of current total available gifts
     */
    public int getTotalAvailableGifts(){
        int count = 0;
        ModelStackArray<Gift>.Iterator iterator = this.gifts.getIterator();
        while(iterator.hasNext()){
            Gift gift = iterator.next();
            if(gift.isAvailable())
                ++count;
        }
        return count;
    }

    /**
     * Create a new gift by given name to store
     * @see Gift#Gift(String)
     * @param   giftName    The name of gift
     * @return              Return a gift object that has been created and added to store
     */
    public Gift createGift(String giftName){
        if(this.gifts.isFull()){
            this.ioutility.log("Store", "Out of gift array capacity\n");
            return null;
        }
        if(findGiftByNameIgnoreCase(giftName) == null){
            Gift gift = new Gift(giftName, this);
            this.gifts.push(gift);
            this.ioutility.log("Store", String.format("Gift %s has been add to store \n", gift.getName()));
            return gift;
        }
        this.ioutility.log("Store", String.format("Gift %s exists in store \n", giftName));
        return null;
    }

    /**
     * Find a existing gift by given name in store
     * @param   giftName    The name of gift
     * @return              Return gift that found or null when fail
     */
    public Gift findGiftByName(String giftName){
        ModelStackArray<Gift>.Iterator iterator = this.gifts.getIterator();
        while(iterator.hasNext()){
            Gift gift = iterator.next();
            if(gift.getName().equals(giftName))
                return gift;
        }
        return null;
    }

    /**
     * Find a existing gift by given name in store, this operation is not case sensitive.
     * @param   giftName    The name of gift
     * @return              Return gift that found or null when fail
     */
    public Gift findGiftByNameIgnoreCase(String giftName){
        ModelStackArray<Gift>.Iterator iterator = this.gifts.getIterator();
        while(iterator.hasNext()){
            Gift gift = iterator.next();
            if(gift.getName().equalsIgnoreCase(giftName))
                return gift;
        }
        return null;
    }

    /**
     * Obtain a gift object at a given index
     * @return Null when the index it is not valid or a gift object if it exists.
     */
    public Gift getGiftByIndex(int index){
        return this.gifts.at(index);
    }

    /**
     * Sale item in given quantity to a customer
     * @param customer  The customer who will purchase the item
     * @param item      The item which will be sold
     * @param quantity  The quantity of item
     * @return          Return true if success or false when fail
     */
    public boolean saleItemToCustomer(Customer customer, Item item, int quantity){
        if(customer.getStore() != this ){
            this.ioutility.log("Store", "Unsafe sale operation detected.");
            return false;
        }
        this.ioutility.log("Store", String.format("Sale Item %s To Customer %s with Quantity %d \n", item.getName(), customer.getName(), quantity));
        if(!item.isAvailable()){
            this.ioutility.log("Store", "Item is not available to sale");
            return false;
        }
        if(customer.purchaseItem(item, quantity)){
            salesCount += quantity;
            salesValue += item.currentPrice()*quantity;
            if(customer.customerGroup()!=Customer.Group.VIP && customer.getPurchaseCount() >= 5){
                customer.setGroup(Customer.Group.VIP);
            }
            this.ioutility.log("Store", "SALE SUCCESS \n");
            return true;
        }
        this.ioutility.log("Store", "SALE FAIL - Not enough currency \n");
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
        if(customer.getStore() != this ){
            this.ioutility.log("Store", "Unsafe redeem operation detected.");
            return false;
        }
        this.ioutility.log("Store", String.format("Redeem Gift %s To Customer %s with Quantity %d \n", gift.getName(), customer.getName(), quantity));
        if(!gift.isAvailable()){
            this.ioutility.log("Store", "Gift is not available to redeem");
            return false;
        }
        if(customer.redeemGift(gift, quantity)){
            redeemCount += quantity;
            redeemValue += gift.currentPoint()*quantity;
            this.ioutility.log("Store", "REDEEM SUCCESS \n");
            return true;
        }
        this.ioutility.log("Store", "REDEEM FAIL - Not enough points \n");
        return false;
    }

    /**
     * Return the item sold count in the store
     * @return The count number of items have been sold from the store
     */
    public int getSalesCount(){
        return this.salesCount;
    }

    /**
     * Obtain the grand total items sale value
     * @return Add up value of all sold items
     */
    public double getSalesValue(){
        return this.salesValue;
    }

    /**
     * Return the gift redeemed count in the store
     * @return The count number of gifts have been redeemed from the store
     */
    public int getRedeemCount(){
        return this.redeemCount;
    }

    /**
     * Obtain the grand total gifts redeem value
     * @return Add up value of all redeemed gifts
     */
    public int getRedeemValue(){
        return this.redeemValue;
    }

    /**
     * Generate a report of customer status of all customers in store
     * @param showAll Show all customers when true or false only VIP customers
     */
    public void listCustomers(boolean showAll){
        /*
         * Iteration of customers to obtain information of customer
         */
        ModelStackArray<Customer>.Iterator iterator = customers.getIterator();
        while(iterator.hasNext()){
            Customer customer = iterator.next();
            String group = "UNKNOW";

            /*
             * Indentify customer group
             */

            //skip array holes
            if(customer == null)
                continue;

            switch(customer.getGroup()){
                case DEFAULT:
                group = "DEFAULT";
                break;
                case VIP:
                group = "VIP";
                break;
            }
            if(!showAll)
            {
                if(customer.getGroup() == Customer.Group.VIP)
                    this.ioutility.print(String.format("%s Group: %s Cash Balance: %.2f Point: %d Total Purchase: %d Total Redeem: %d \n", customer.getName(), group, customer.currentCashBalance(), customer.currentPointBalance(), customer.getPurchaseCount(), customer.getRedeemCount()));
            }
            else
                this.ioutility.print(String.format("%s Group: %s Cash Balance: %.2f Point: %d Total Purchase: %d Total Redeem: %d \n", customer.getName(), group, customer.currentCashBalance(), customer.currentPointBalance(), customer.getPurchaseCount(), customer.getRedeemCount()));
        }
    }

    /**
     * Generate a report of item status of all items in store
     * @param showAll Show all gifts when true or false only available gifts
     */
    public void listItems(boolean showAll){
        /*
         * Iteration of items to obtain information of item
         */
        ModelStackArray<Item>.Iterator iterator = this.items.getIterator();
        while(iterator.hasNext()){
            Item item = iterator.next();

            //skip array holes
            if(item!=null)
                if(!showAll)
                {
                    if(item.isAvailable())
                        this.ioutility.print(String.format(" %s Price: %.2f Reward Point: %d Total Sale: %d Available: %b \n Description:%s \n", item.getName(), item.currentPrice(), item.getRewardPoint(), item.getSaleCount(), item.isAvailable(), item.getDescription()));
                }
                else
                    this.ioutility.print(String.format(" %s Price: %.2f Reward Point: %d Total Sale: %d Available: %b \n Description:%s \n", item.getName(), item.currentPrice(), item.getRewardPoint(), item.getSaleCount(), item.isAvailable(), item.getDescription()));
        }
    }

    /**
     * List items between a given price range
     * @param showAll Show all gifts when true or false only available gifts
     * @param minimumPrice The minimum price
     * @param maximumPrice The maximum price
     */
    public void listItemsByPrice(boolean showAll, float minimumPrice, float maximumPrice){
        if(minimumPrice > maximumPrice)
            this.ioutility.log("Store", "illegal given price");
        boolean empty = true;
        ModelStackArray<Item>.Iterator iterator = this.items.getIterator();
        while(iterator.hasNext()){
            Item item = iterator.next();

            //skip array holes
            if(item!=null)
                if(minimumPrice <= item.currentPrice() && item.currentPrice() <= maximumPrice){
                    if(!showAll)
                    {
                        if(item.isAvailable()){
                            empty = false;
                            this.ioutility.print(String.format(" %s Price: %.2f Reward Point: %d Total Sale: %d Available: %b \n Description:%s \n", item.getName(), item.currentPrice(), item.getRewardPoint(), item.getSaleCount(), item.isAvailable(), item.getDescription()));
                        }
                    }
                    else{
                        empty = false;                        
                        this.ioutility.print(String.format(" %s Price: %.2f Reward Point: %d Total Sale: %d Available: %b \n Description:%s \n", item.getName(), item.currentPrice(), item.getRewardPoint(), item.getSaleCount(), item.isAvailable(), item.getDescription()));
                    }
            }
        }
        if(empty)
            this.ioutility.log("Store", String.format("No item found by given price %.2f - %.2f \n", minimumPrice, maximumPrice));
    }

    /**
     * Generate a report of gift status of all gifts in store
     * @param showAll Show all gifts when true or false only available gifts
     */
    public void listGifts(boolean showAll){
        /*
         * Iteration of gifts to obtain information of gift
         */
        ModelStackArray<Gift>.Iterator iterator = this.gifts.getIterator();
        while(iterator.hasNext()){
            Gift gift = iterator.next();

            //skip array holes
            if(gift!=null)
                if(!showAll)
                {
                    if(gift.isAvailable())
                        this.ioutility.print(String.format(" %s Point: %d Total Redeem: %d Available: %b \n Description:%s \n", gift.getName(), gift.currentPoint(), gift.getRedeemCount(), gift.isAvailable(), gift.getDescription()));
                }
                else
                    this.ioutility.print(String.format(" %s Point: %d Total Redeem: %d Available: %b \n Description:%s \n", gift.getName(), gift.currentPoint(), gift.getRedeemCount(), gift.isAvailable(), gift.getDescription()));
        }
    }

    /**
     * List gifts under a given maximum points
     * @param showAll Show all gifts when true or false only available gifts
     * @param maximumPoints The maximum points
     */
    public void listGiftsEqualOrLessThan(boolean showAll, int maximumPoints){
        boolean empty = true;
        ModelStackArray<Gift>.Iterator iterator = this.gifts.getIterator();
        while(iterator.hasNext()){
            Gift gift = iterator.next();

            //skip array holes
            if(gift!=null)
                if(gift.currentPoint() <= maximumPoints){
                    if(!showAll)
                    {
                        if(gift.isAvailable()){
                            empty = false;
                            this.ioutility.print(String.format(" %s Point: %d Total Redeem: %d Available: %b \n Description:%s \n", gift.getName(), gift.currentPoint(), gift.getRedeemCount(), gift.isAvailable(), gift.getDescription()));
                        }
                    }
                    else {
                        empty = false;
                        this.ioutility.print(String.format(" %s Point: %d Total Redeem: %d Available: %b \n Description:%s \n", gift.getName(), gift.currentPoint(), gift.getRedeemCount(), gift.isAvailable(), gift.getDescription()));
                    }
            }
        }
        if(empty)
            this.ioutility.log("Store", String.format("No gift found which equals or less than given points %d \n", maximumPoints));
    }

    /**
     * Generate store status include customers list, items list, gifts list and basic sale and redeem count of store.
     */
    public void generateReport(){
        listCustomers(true);
        listItems(true);
        listGifts(true);
        this.ioutility.print(String.format("%s \n Total Item Sales: %d Value: %.2f \n Total Gift Redeem: %d Value: %d Points \n", getName(), getSalesCount(), getSalesValue(), getRedeemCount(), getRedeemValue()));
    }

}
