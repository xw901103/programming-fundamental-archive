/**
 * Print out a list of all status of all gifts inside the store.
 * @see MainMenu
 * @see Store#listGifts(boolean)
 * 
 * @author Xu Waycell, Way Studios
 */
public class GenerateGiftListAction extends Action
{
    /**
     * Constructor for objects of class GenerateGiftListAction
     */
    public GenerateGiftListAction(Terminal initialTerminal){
        super("GENERATE_GIFT_LIST_ACTION", initialTerminal);
    }
    
    /**
     * Routine to print a list of gifts' detail
     * @see MainMenu
     * @see Store#listGifts(boolean)
     */
    protected void routine(){
        getIOUtility().clearScreen();
        getIOUtility().println("Gift List");
        //obtain false if available only
        boolean showAll = !getIOUtility().getBooleanInput("Show available gifts only?(y or n)");
        getStore().listGifts(showAll);
        getIOUtility().waitEnter("Press ENTER to back to previous menu.");
        stop();
    }

}
