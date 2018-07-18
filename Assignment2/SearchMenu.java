/**
 * Search menu of the store terminal.</br>
 * This menu including following menu options:</br>
 * Search item by name</br>
 * Search items by price</br>
 * Search gift by name</br>
 * Search gifts by points value</br>
 * Search customer by name</br>
 * 
 * @see SearchItemByNameAction
 * @see SearchItemsByPriceAction
 * @see SearchGiftByNameAction
 * @see SearchGiftsByPointsValueAction
 * @see SearchCustomerByNameAction
 * 
 * @author Xu Waycell, Way Studios
 */
public class SearchMenu extends Menu
{
    /**
     * Constructor for objects of class SearchMenu
     */
    public SearchMenu(Terminal initialTerminal){
        super("SEARCH_MENU", "Search Menu", "1.Search an Item by name\n2.Search Items by price\n3.Search a Gift by name\n4.Search Gifts by points value\n5.Search a Customer by name\n6.Back to previous menu", initialTerminal);
    }

    /**
     * Process a numberic menu option from user input.</br>
     * This menu including following menu options:</br>
     * Search item by name</br>
     * Search items by price</br>
     * Search gift by name</br>
     * Search gifts by points value</br>
     * Search customer by name</br>
     * 
     * @see SearchItemByNameAction
     * @see SearchItemsByPriceAction
     * @see SearchGiftByNameAction
     * @see SearchGiftsByPointsValueAction
     * @see SearchCustomerByNameAction
     */
    protected void processMenuOption(int option){
        switch(option){
            case 1:
                callAction("SEARCH_ITEM_BY_NAME_ACTION");
                break;
            case 2:
                callAction("SEARCH_ITEMS_BY_PRICE_ACTION");
                break;
            case 3:
                callAction("SEARCH_GIFT_BY_NAME_ACTION");
                break;
            case 4:
                callAction("SEARCH_GIFTS_BY_POINTS_VALUE_ACTION");
                break;
            case 5:
                callAction("SEARCH_CUSTOMER_BY_NAME_ACTION");
                break;
            case 6:
                leave();
                break;
            default:
                break;
        }
    }
}
