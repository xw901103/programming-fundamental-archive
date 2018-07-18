/**
 * Item class contains name, description, sale count, price and its availability and provides methods to manipulate them. This class will cooperate with class Store and Customer.
 * @see Model
 * @see Customer
 * @see Store
 * @author Xu Waycell, Way Studios
 */
public class Item extends Model
{
    /**
     * The name of item
     */
    private String name;
    /**
     * The description of item
     */
    private String description;
    /**
     * Total sold count
     */
    private int saleCount;
    /**
     * Item price
     */
    private float price;    
    /**
     * Reward points once the item has been purchased. -1 for auto-generate or any value greater than -1
     */
    private int rewardPoint;
    /**
     * The availability of item, true if it is available or false when it is not
     */
    private boolean availability;
    
    /**
     * Constructor to initial a Item object within a owner.
     * @param initialStore The item owner
     * @see Item(String)
     * @see Item(String, float)
     */
    public Item(Store initialStore){
        super(initialStore);
        saleCount = 0;
        price = 0.0f;
        rewardPoint = -1;
        availability = false;
    }
    
    /**
     * Alternative constructor to initial a Item object with given item name.
     * @param newName The name of item
     * @param initialStore The item owner
     * @see Item()
     * @see Item(String, float)
     */
    public Item(String newName, Store initialStore){
        super(initialStore);
        name = newName;
        saleCount = 0;
        price = 0.0f;
        rewardPoint = -1;
        availability = false;
    }
    
    /**
     * Alternative constructor to initial a Item object with given item name and given price
     * @param newName The name of item
     * @param newPrice The item price
     * @param initialStore The item owner
     * @see Item()
     * @see Item(String)
     */
    public Item(String newName, float newPrice, Store initialStore){
        super(initialStore);
        name = newName;
        saleCount = 0;
        price = newPrice;
        availability = false;
    }

    /**
     * Obtain the availability of Item
     * @see setAvailability(boolean)
     * @see isAvailable()
     * @return Return true if the Item is available or false when it is not
     */
    public boolean getAvailability(){
        return availability;
    }
    
    /**
     * Set the availability of Item
     * @see getAvailability()
     * @see isAvailable()
     * @param The status of availability in boolean, true if it is available or false when it is not
     */
    public void setAvailability(boolean newAvailability){
        availability = newAvailability;
    }

    /**
     * Alternative method to obtain the availability of Item
     * @see getAvailability()
     * @see setAvailability(boolean)
     * @return Return true if the Item is available or false if it is not
     */
    public boolean isAvailable(){
        return getAvailability();
    }
    
    /**
     * Obtain the required single item price to purchase
     * @see setPrice(float)
     * @see currentPrice()
     * @return An item price
     */
    public float getPrice(){
        return price;
    }
    
    /**
     * Set the required single item price to purchase
     * @see getPrice()
     * @see currentPrice()
     * @param newPrice New item price
     */
    public void setPrice(float newPrice){
        price = newPrice;
    }
    
    /**
     * Alternative method to obtain the price of the Item to purchase
     * @see getPrice()
     * @see setPrice(float)
     * @return The item price
     */
    public float currentPrice(){
        return getPrice();
    }
    
    /**
     * Obtain the name of item
     * @see setName(String)
     * @return The name of item
     */
    public String getName(){
        return name;
    }
    
    /**
     * Set the name of item
     * @see getName()
     * @param New name of item
     */
    public void setName(String newName){
        name = newName;
    }
    
    /**
     * Obtain the description of Item
     * @see setDescription(String)
     * @return The description of item
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * Set the description of Item
     * @see getDescription()
     * @param newDescription New description for the Item
     */    
    public void setDescription(String newDescription){
        description = newDescription;
    }
    
    /**
     * Obtain the reward points of the Item will reward after purchased it
     * @see Gift
     * @see Gift#getPoint()
     * @see Item#setRewardPoint(int)
     * @return The points to reward buyer
     */
    public int getRewardPoint(){
            if(rewardPoint < 0){
                if(price >= 50.0f)
                    return 9;
                else if(price >= 20.0f && price < 50.0f)
                    return 6;
                else if(price >= 10.0f && price < 20.0f)
                    return 3;
                else if(price >= 0.01f && price < 10.0f)
                    return 1;
                return 0;
            }
            else
                return rewardPoint;
    }
    
    /**
     * Set the reward points of the Item will reward after purchased it
     * @see Gift
     * @see Gift#getPoint()
     * @see Item#getRewardPoint()
     * @param point The points to reward buyer
     */
    public void setRewardPoint(int point){
        rewardPoint = point;
    }
    
    /**
     * Verify the given customer's capability to purchase the item in given quantity
     * @see Store#saleItemToCustomer(Customer, Item, int)
     * @see sale(int)
     * @param customer Given customer to verify
     * @param quantity The quantity of item
     * @return Return true if the customer is able to purchase or false when it is not
     */
    public boolean verifyCustomer(Customer customer, int quantity){
        if(isAvailable())
            return customer.currentCashBalance() >= (currentPrice()*quantity);
        return false;
    }
    
    /**
     * Sale the Item in given quantity and return the total costs
     * @see Store#saleItemToCustomer(Customer, Item, int)
     * @param quantity The quantity of item that will be sold
     * @return The total costs of items which are sold
     */
    public float sale(int quantity){
        saleCount+=quantity;
        return currentPrice()*quantity;
    }
    
    /**
     * Obtain the number of total sold
     * @return The number of total sold
     */
    public int getSaleCount(){
        return saleCount;
    }
}
