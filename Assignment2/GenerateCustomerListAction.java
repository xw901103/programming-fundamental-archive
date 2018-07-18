/**
 * Print out all customers' status inside the store
 * 
 * @see MainMenu
 * @see Store#listCustomers(boolean)
 * 
 * @author Xu Waycell, Way Studios
 */
public class GenerateCustomerListAction extends Action
{

    /**
     * Constructor for objects of class GenerateCustomerListAction
     */
    public GenerateCustomerListAction(Terminal initialTerminal){
        super("GENERATE_CUSTOMER_LIST_ACTION", initialTerminal);
    }
    
    /**
     * Routine to perform print customer detail action
     * 
     * @see MainMenu
     * @see Store#listCustomers(boolean)
     */
    protected void routine(){
        getIOUtility().print("\f");
        getIOUtility().println("Customer List");
        //obtain false if available only
        boolean showAll = !getIOUtility().getBooleanInput("Show VIP customers only?(y or n)");
        getStore().listCustomers(showAll);
        getIOUtility().waitEnter("Press ENTER to back to previous menu.");        
        stop();
    }

}
