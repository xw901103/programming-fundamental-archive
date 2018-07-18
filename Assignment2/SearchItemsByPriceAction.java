/**
 * List items between a chosen price scope
 * 
 * @author Xu Waycell, Way Studios
 */
public class SearchItemsByPriceAction extends Action
{
    /**
     * Constructor for objects of class SearchItemsByPriceAction
     */
    public SearchItemsByPriceAction(Terminal initialTerminal){
        super("SEARCH_ITEMS_BY_PRICE_ACTION", initialTerminal);
    }

    /**
     * This action privdes following range to choose.</br>
     * 1. 00.00 to 09.99</br>
     * 2. 10.00 to 39.99</br>
     * 3. 40.00 to 99.99</br>
     * 4. 100.00 and over </br>
     * This routine will list found items between chosen range of price
     * 
     * @see Store#listItemsByPrice(boolean, float, float)
     */
    protected void routine(){
        getIOUtility().clearScreen();
        getIOUtility().println("Search items by price");
        getIOUtility().println("1.0.00 - 9.99");
        getIOUtility().println("2.10.00 - 39.99");
        getIOUtility().println("3.40.00 - 99.99");
        getIOUtility().println("4.100.00 and over");
        getIOUtility().println("5.Back to previous menu");
        int opt = getIOUtility().getNumbericInput("Please select a option:", "Please select a NUMBERIC option:");
        switch(opt){
            case 1:
                getStore().listItemsByPrice(true, 0.0f, 9.99f);
                break;
            case 2:
                getStore().listItemsByPrice(true, 10.0f, 39.99f);
                break;
            case 3:
                getStore().listItemsByPrice(true, 40.0f, 99.99f);
                break;
            case 4:
                //from 100.0 to maximum
                getStore().listItemsByPrice(true, 100.0f, Float.MAX_VALUE);
                break;
            case 5:
                //break the loop directly
                stop();
                return;
            case 0:
                break;
            default:
                getIOUtility().println("Non acceptable menu option!");
                break;
        }
        if(!getIOUtility().getBooleanInput("Search something else?(y or n)?"))
            stop();
    }
}
