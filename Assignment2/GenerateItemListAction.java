/**
 * Generate a list of all item status inside the store
 * @see MainMenu
 * @see Store#listItems(boolean)
 * 
 * @author Xu Waycell, Way Studios
 */
public class GenerateItemListAction extends Action
{
    /**
     * Constructor for objects of class GenerateItemListAction
     */
    public GenerateItemListAction(Terminal initialTerminal){
        super("GENERATE_ITEM_LIST_ACTION", initialTerminal);
    }
    
    /**
     * The action routine to print a list of items' detail
     * @see MainMenu
     * @see Store#listItems(boolean)
     */
    protected void routine(){
        getIOUtility().clearScreen();
        getIOUtility().println("Item List");
        //obtain false if available only
        boolean showAll = !getIOUtility().getBooleanInput("Show available items only?(y or n)");
        getStore().listItems(showAll);
        getIOUtility().waitEnter("Press ENTER to back to previous menu.");       
        stop();
    }

}
