/**
 * Create an item by collecting user input attributes.
 * <strong>NOTE:This action is case sensitive</strong>
 * 
 * @author Xu Waycell, Way Studios
 */
public class CreateItemAction extends Action
{
    /**
     * Constructor for objects of class CreateItemAction
     */
    public CreateItemAction(Terminal initialTerminal){
        super("CREATE_ITEM_ACTION", initialTerminal);
    }

    /**
     * Create item routine
     * This action might show fail to create an item if there is one with the same name or out of space of item container in the store</br>
     * <strong>NOTE:This action is case sensitive</strong>
     * 
     * @see Store#createItem(String)
     */
    protected void routine(){
        getIOUtility().clearScreen();
        getIOUtility().println("Add item to store");
        String itemName;
        String itemDescription;
        float itemPrice = 0.0f;
        int itemRewardPoint = -1; // -1 for auto generate points value
        boolean itemAvailability = false;
        itemName = getIOUtility().getStringInput("Item name:", "Invalid input");
            
        if(getStore().findItemByNameIgnoreCase(itemName) == null){
            itemDescription = getIOUtility().getStringInput("Type item description below:\n", "Invalid input");
            
            itemPrice = getIOUtility().getFloatInput("Item price:", "Item price(example 8.0):");

            itemRewardPoint = getIOUtility().getNumbericInput("Item reward point:", "Item reward point(example 8):");            
            
            Item item = getStore().createItem(itemName);
            item.setDescription(itemDescription);
            item.setPrice(itemPrice);
            item.setRewardPoint(itemRewardPoint);
            item.setAvailability(true);
        } else {
            getIOUtility().print(String.format("Item %s exists in the store. Please try another name.\n", itemName));
        }
        if(!getIOUtility().getBooleanInput("Add another one?(y or n)"))
            stop();
    }
}
