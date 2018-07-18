/**
 * The main menu of the store terminal
 * This menu including following menu options:</br>
 * Search elements in the store</br>
 * Add a new item to store</br>
 * Add a new gift to store</br>
 * Sale item to customer</br>
 * Redeem gift to customer</br>
 * List all customers in store</br>
 * List all items in store</br>
 * List all gifts in store</br>
 * Print out a store report including previous three</br>
 * Quit the store terminal</br>
 * 
 * @see SearchMenu
 * @see CreateItemAction
 * @see CreateGiftAction
 * @see SaleItemAction
 * @see RedeemGiftAction
 * @see GenerateCustomerListAction
 * @see GenerateItemListAction
 * @see GenerateGiftListAction
 * @see GenerateStoreReportAction
 * @see Terminal#terminate()
 * 
 * @author Xu Waycell, Way Studios
 */
public class MainMenu extends Menu
{

    /**
     * Constructor for objects of class MainMenu
     */
    public MainMenu(Terminal initialTerminal){
        super("MAIN_MENU", "Main Menu", "1.Search\n2.Add Item\n3.Add Gift\n4.Sale Item\n5.Redeem Gift\n6.Customer List\n7.Item List\n8.Gift List\n9.Store Report\n0.Quit", initialTerminal);
    }

    /**
     * Process a user input numberic menu option.</br>
     * This menu including following menu options:</br>
     * Search elements in the store</br>
     * Add a new item to store</br>
     * Add a new gift to store</br>
     * Sale item to customer</br>
     * Redeem gift to customer</br>
     * List all customers in store</br>
     * List all items in store</br>
     * List all gifts in store</br>
     * Print out a store report including previous three</br>
     * Quit the store terminal</br>
     * 
     * @see SearchMenu
     * @see CreateItemAction
     * @see CreateGiftAction
     * @see SaleItemAction
     * @see RedeemGiftAction
     * @see GenerateCustomerListAction
     * @see GenerateItemListAction
     * @see GenerateGiftListAction
     * @see GenerateStoreReportAction
     * @see Terminal#terminate()
     */
    protected void processMenuOption(int option){
        switch(option){
            case 1:
                callMenu("SEARCH_MENU");
                break;
            case 2:
                callAction("CREATE_ITEM_ACTION");
                break;
            case 3:
                callAction("CREATE_GIFT_ACTION");
                break;
            case 4:
                callAction("SALE_ITEM_ACTION");
                break;
            case 5:
                callAction("REDEEM_GIFT_ACTION");
                break;
            case 6:
                callAction("GENERATE_CUSTOMER_LIST_ACTION");
                break;
            case 7:
                callAction("GENERATE_ITEM_LIST_ACTION");
                break;
            case 8:
                callAction("GENERATE_GIFT_LIST_ACTION");
                break;
            case 9:
                callAction("GENERATE_STORE_REPORT_ACTION");
                break;
            case 0:
                getTerminal().terminate();
                leave();
                break;
            default:
                break;
        }
    }
}
