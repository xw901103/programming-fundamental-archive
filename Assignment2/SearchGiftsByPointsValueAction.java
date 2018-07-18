/**
 * List items under given maximum points value
 * 
 * @see SearchMenu
 * 
 * @author Xu Waycell, Way Studios
 */
public class SearchGiftsByPointsValueAction extends Action
{
    /**
     * Constructor for objects of class SearchGiftsByPointsValueAction
     */
    public SearchGiftsByPointsValueAction(Terminal initialTerminal){
        super("SEARCH_GIFTS_BY_POINTS_VALUE_ACTION", initialTerminal);
    }
    
    /**
     * Search routine</br>
     * This action will find gifts under given points value and print out all found gifts' detail
     */
    protected void routine(){
        getIOUtility().clearScreen();
        getIOUtility().println("Search gifts by points value");
        int maximumPoints = getIOUtility().getNumbericInput("Input the maximum points value of gift to perform:", "Input the maximum NUMBERIC points value of gift to perform:");
        getStore().listGiftsEqualOrLessThan(true, maximumPoints);
        if(!getIOUtility().getBooleanInput("Search something else?(y or n)?"))
            stop();
    }

}
