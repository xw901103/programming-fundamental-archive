/**
 * Search an item by its unique name action</br>
 * <strong>THIS ACTION IS NOT CASE SENSITIVE!</strong>
 * 
 * @see SearchMenu
 * 
 * @author Xu Waycell, Way Studios
 */
public class SearchItemByNameAction extends Action
{
    /**
     * Constructor for objects of class SearchItemByNameAction
     */
    public SearchItemByNameAction(Terminal initialTerminal){
        super("SEARCH_ITEM_BY_NAME_ACTION", initialTerminal);
    }
    
    /**
     * This action routine is to search an item by its unique name and print found item's status.</br>
     * <strong>THIS ACTION IS NOT CASE SENSITIVE!</strong>
     */
    protected void routine(){
        getIOUtility().clearScreen();
        getIOUtility().println("Search an item by name");
        String itemName = getIOUtility().getStringInput("Input the name of the item to perform(ignore case):", "Invalid input");
        Item item = getStore().findItemByNameIgnoreCase(itemName);
        if(item == null){
            getIOUtility().print(String.format("Oops, no such thing is %s \n", itemName));
        }else{
            getIOUtility().print(String.format("%s Price: %.2f Reward Point: %d Total Sale: %d Available: %b \n Description:%s \n", item.getName(), item.currentPrice(), item.getRewardPoint(), item.getSaleCount(), item.isAvailable(), item.getDescription()));
        }
        if(!getIOUtility().getBooleanInput("Search something else?(y or n)"))
            stop();
    }

}
