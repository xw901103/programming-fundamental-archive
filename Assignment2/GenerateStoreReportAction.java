/**
 * Print out a store report including all status of items, gift and customers and sale and redeem values in the store.
 * 
 * @see Store#generateReport()
 * @see MainMenu
 * 
 * @author Xu Waycell, Way Studios
 */
public class GenerateStoreReportAction extends Action
{
    /**
     * Constructor for objects of class GenerateStoreReportAction
     */
    public GenerateStoreReportAction(Terminal initialTerminal){
        super("GENERATE_STORE_REPORT_ACTION", initialTerminal);
    }
    
    /**
     * Routine to print out all store detail
     */
    protected void routine(){
        getIOUtility().clearScreen();
        getIOUtility().println("Store Report");
        getStore().generateReport();
        getIOUtility().waitEnter("Press ENTER to back to previous menu.");
        stop();
    }

}
