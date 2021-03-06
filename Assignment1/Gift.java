/**
 * A gift class contains information of it and provides methods to manipulate them. This class will cooperate with Customer class and Store class.
 * @see Customer
 * @see Store
 * @author Xu Waycell, Way Studios
 * @date 24th Oct
 */
public class Gift
{
    /**
     * The name of gift
     */
    private String name;
    /**
     * The description of gift
     */
    private String description;
    /**
     * The points which costs to redeem the gift
     */
    private float point;
    /**
     * The availability of gift, true if it is available or false when it is not
     */
    private boolean availability;
    /**
     * Total redeemed count
     */
    private int redeemCount;
    
    /**
     * Default constructor to initial a Gift object
     * @see Gift(String)
     * @see Gift(String, float)
     */
    public Gift(){
        point = 0.0f;
        availability = false;
        redeemCount = 0;
    }
    
    /**
     * Alternative constructor to initial a Gift object with given name
     * @see Gift()
     * @see Gift(String, float)
     * @param newName The name of gift
     */
    public Gift(String newName){
        name = newName;
        point = 0.0f;
        availability = false;
        redeemCount = 0;
    }
    
    /**
     * Alternative constructor to initial a Gift object with given name and required points to redeem it
     * @see Gift()
     * @see Gift(String)
     * @param newName The name of Gift
     * @param newPoint The required points to redeem this gift
     */
    public Gift(String newName, float newPoint){
        name = newName;
        point = newPoint;
        availability = false;
        redeemCount = 0;
    }
    
    /**
     * Obtain the availability of gift
     * @return Return true if the gift is available or false when it is not
     */
    public boolean getAvailability(){
        return availability;
    }
    
    /**
     * Set the availability of Gift
     * @param The status of availability in boolean, true if it is available or false when it is not
     */
    public void setAvailability(boolean newAvailability){
        availability = newAvailability;
    }

    /**
     * Alternative method to obtain the availability of Gift
     * @see getAvailability()
     * @return Return true if the gift is available or false when it is not
     */
    public boolean isAvailable(){
        return getAvailability();
    }
    
    /**
     * Obtain the required points to redeem a gift by a customer
     * @see currentPoint()
     * @see setPoint(float)
     * @return The points
     */
    public float getPoint(){
        return point;
    }

    /**
     * Set the required points to redeem a gift by a customer
     * @see getPoint()
     * @see currentPoint()
     * @param newPoint The points to redeem a gift by a customer
     */
    public void setPoint(float newPoint){
        point = newPoint;
    }
    
    /**
     * Alternative method to obtain the required points to redeem a gift by a customer
     * @see setPoint(float)
     * @see getPoint()
     * @return The points
     */
    public float currentPoint(){
        return getPoint();
    }
    
    /**
     * Obtain the name of gift
     * @return The name of gift
     */
    public String getName(){
        return name;
    }
    
    /**
     * Set a new name to gift
     * @param The new name of gift
     */
    public void setName(String newName){
        name = newName;
    }
    
    /**
     * Obtain the description of Gift
     * @return The description of gift
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * Set a description to Gift
     * @param newDescription new description of gift
     */
    public void setDescription(String newDescription){
        description = newDescription;
    }
    
    /**
     * Verify the given customer's capability to redeem the gift in a given quantity
     * @see redeem(int)
     * @see Customer
     * @see Customer#redeemGift(Gift, int)
     * @see Store
     * @see Store#redeemGiftToCustomer(Customer, Gift, int)
     * @param customer Given customer to verify
     * @param quantity The quantity of gift that customer wanna redeem
     * @return Return true if the customer is able to redeem or false when it is not
     */
    public boolean verifyCustomer(Customer customer, int quantity){
        if(isAvailable())
            return customer.currentPointBalance() >= (currentPoint()*quantity);
        return false;
    }
    
    /**
     * Redeem the gift in given quantity and return the total points costs
     * @see Store#redeemGiftToCustomer(Customer, Gift, int)
     * @see Customer#redeemGift(Gift, int)
     * @param quantity The quantity of the gift that will be redeemed
     * @return The total points of gifts which are redeemed
     */
    public float redeem(int quantity){
        redeemCount+=quantity;
        return currentPoint()*quantity;        
    }
    
    /**
     * Obtain the number of total redeemed gifts
     * @return The quantity of total redeemed
     */
    public int getRedeemCount(){
        return redeemCount;
    }
}
