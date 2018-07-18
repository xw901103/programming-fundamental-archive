/**
 * Customer class stores the information of a customer and provides methods to manipulate them. This class will cooperate with class Store, Item and Gift.
 * @see Model
 * @see Store
 * @see Item
 * @see Gift
 * @author Xu Waycell, Way Studios
 */
public class Customer extends Model
{
    /**
     * Customer's name
     */
    private String name;
    /**
     * Customer's email
     */
    private String email;
    /**
     * Customer's current cash balance
     */
    private float cashBalance;
    /**
     * Customer's current reward points which earned via purchasing items
     */
    private int pointBalance;
    /**
     * The current customer group
     */
    private Group group;
    /**
     * Total purchased item count
     */
    private int purchaseCount;
    /**
     * Total redeemed gift count
     */
    private int redeemCount;

    /**
     * The customer group
     * @see getGroup()
     * @see setGroup()
     * @see customerGroup()
     */
    public enum Group{
        DEFAULT,
        VIP
    }
    
    /**
     * Constructor to initial a Customer object with its owner
     * @param initialStore The owner
     */
    public Customer(Store initialStore)
    {
        super(initialStore);
        cashBalance = 0.0f;
        pointBalance = 0;
        group = Group.DEFAULT;
        purchaseCount = 0;
        redeemCount = 0;
    }
    
    /**
     * Alternative constructor to initial a Customer object with given name and store parent.
     * @param newName The name will be used to initial the Customer object
     * @param initialStore The owner
     */
    public Customer(String newName, Store initialStore){
        super(initialStore);
        name = newName;
        cashBalance = 0.0f;
        pointBalance = 0;
        group = Group.DEFAULT;
        purchaseCount = 0;
        redeemCount = 0;
    }
    
    /**
     * Obtain the name of the customer
     * @see setName(String)
     * @return The name of customer
     */
    public String getName(){
        return name;
    }
    
    /**
     * Set a new name of the customer
     * @see getName()
     * @param newName New name of the customer
     */
    public void setName(String newName){
        name = newName;
    }
    
    /**
     * Obtain the email address of customer
     * @see setEmail(String)
     * @return The email address
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * Set a new email address to the customer
     * @see getEmail()
     * @param newEmail New email address of customer
     */
    public void setEmail(String newEmail){
        email = newEmail;
    }
    
    /**
     * Obtain current cash balance of the customer
     * @see setCashBalance(float)
     * @see currentCashBalance()
     * @return Current cash balance
     */
    public float getCashBalance(){
        return cashBalance;
    }
    
    /**
     * Set cash balance to the customer
     * @see getCashBalance()
     * @see currentCashBalance()
     * @param newCashBalance New cash balance
     */
    public void setCashBalance(float newCashBalance){
        cashBalance = newCashBalance;
    }
    
    /**
     * Alternative method to obtain current cash balance of the customer
     * @see getCashBalance()
     * @see setCashBalance(float)
     * @return The current cash balance
     */
    public float currentCashBalance(){
        return getCashBalance();
    }
    
    /**
     * Obtain current points of the customer has been rewarded via purchasing items
     * @see setPointBalance(float)
     * @see currentPointBalance()
     * @return The reward points
     */
    public int getPointBalance(){
        return pointBalance;
    }
    
    /**
     * Set reward points to the customer
     * @see getPointBalance()
     * @see currentPointBalance()
     * @param newPointBalance New reward points of the customer
     */
    public void setPointBalance(int newPointBalance){
        pointBalance = newPointBalance;
    }
    
    /**
     * Alternative method to obtain current reward points balance of the customer
     * @see getPointBalance()
     * @see setPointBalance(float)
     * @return The reward points of the customer
     */
    public int currentPointBalance(){
        return getPointBalance();
    }
    
    /**
     * Obtain the customer group of the customer
     * @see Group
     * @see setGroup(Group)
     * @see customerGroup()
     * @return The group of the customer
     */
    public Group getGroup(){
        return group;
    }
    
    /**
     * Set new customer group to the customer
     * @see Group
     * @see getGroup()
     * @see customerGroup()
     * @param newGroup new customer group of the customer
     */
    public void setGroup(Group newGroup){
        group = newGroup;
    }
    
    /**
     * Alternative method to obtain the customer group of the customer
     * @see Group
     * @see getGroup()
     * @see setGroup(Group)
     * @return The group of the customer
     */
    public Group customerGroup(){
        return getGroup();
    }
    
    /**
     * Buy a given item in given quantity
     * @see Item#sale(int)
     * @see Store#saleItemToCustomer(Customer, Item, int)
     * @param item      The item will be purcahsed
     * @param quantity  The quantity of the item
     * @return Return true if it is successful or false when it is not.
     */
    public boolean purchaseItem(Item item, int quantity){
        if(item.verifyCustomer(this, quantity)){
            cashBalance -= item.sale(quantity);
            pointBalance += (item.getRewardPoint()*quantity);
            purchaseCount += quantity;
            return true;
        }
        return false;
    }
    
    /**
     * Obtain the quantity of items have been purchased by the customer
     * @return The quantity of items
     */
    public int getPurchaseCount(){
        return purchaseCount;
    }
    
    /**
     * Redeem a given gift in given quantity
     * @see Gift#redeem(int)
     * @see Store#redeemGiftToCustomer(Customer, Gift, int)
     * @param gift      The gift will be redeemed
     * @param quantity  The quantity of the gift
     * @return Return true if it is successful or false when it is not.
     */
    public boolean redeemGift(Gift gift, int quantity){
        if(gift.verifyCustomer(this, quantity)){
            pointBalance -= gift.redeem(quantity);
            redeemCount += quantity;
            return true;
        }
        return false;
    }
    
    /**
     * Obtain the quantity of gifts have been redeemed by the customer
     * @return The quantity of redeemed gifts
     */
    public int getRedeemCount(){
        return redeemCount;
    }
}
