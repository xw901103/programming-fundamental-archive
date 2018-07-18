/**
 * Search a gift by its unique name action</br>
 * <strong>THIS ACTION IS NOT CASE SENSITIVE!</strong>
 * 
 * @see SearchMenu
 * 
 * @author Xu Waycell, Way Studios
 */
public class SearchGiftByNameAction extends Action
{
    /**
     * Constructor for objects of class SearchItemByNameAction
     */
    public SearchGiftByNameAction(Terminal initialTerminal){
        super("SEARCH_GIFT_BY_NAME_ACTION", initialTerminal);
    }
    
    /**
     * This action routine is to search a gift by its unique name and print found gift's status.</br>
     * <strong>THIS ACTION IS NOT CASE SENSITIVE!</strong>
     */
    protected void routine(){
        getIOUtility().print("\f");
        getIOUtility().println("Search a gift by name");
        String giftName = getIOUtility().getStringInput("Input the name of the gift to perform(ignore case):", "Invalid input");
        Gift gift = getStore().findGiftByNameIgnoreCase(giftName);
        if(gift == null){
            getIOUtility().print(String.format("Oops, no such thing is %s \n", giftName));
        }else{
            getIOUtility().print(String.format("%s Point: %d Total Redeem: %d Available: %b \n Description:%s \n", gift.getName(), gift.currentPoint(), gift.getRedeemCount(), gift.isAvailable(), gift.getDescription()));
        }
        if(!getIOUtility().getBooleanInput("Search something else?(y or n)"))
            stop();
    }

}
