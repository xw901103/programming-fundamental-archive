/**
 * @author Xu Waycell, Way Studios
 * @date 12th Dec
 */
import java.util.Scanner;
import java.util.*;
import java.io.IOException;
/**
 * The Terminal class provides a text user interface menu for store operation.
 * @see Store
 * @see Item
 * @see Gift
 * @see Customer
 * @author Xu Waycell, Way Studios
 * @date 12th Dec
 */
public class Terminal
{
    private Store store;
    private boolean running;
    //private Scanner scanner;
    private IOUtility ioutility;
    private Map<String, Menu> menuMap;
    private Map<String, Action> actionMap;
    
    /**
     * Constructor
     * @param store the initial store object
     */
    public Terminal(Store store){
        initialize(store);
    }
    
    /**
     * initialize the terminal object with given store object
     * @param store the initial store object
     */
    private void initialize(Store store){
        this.store = store;
        
        this.running = false;        

        this.ioutility = new IOUtility();
        this.store.setIOUtility(this.ioutility);
        
        //create and map menus
        this.menuMap = new HashMap<String, Menu>();
        
        appendMenu(new MainMenu(this));
        
        appendMenu(new SearchMenu(this));

        this.actionMap = new HashMap<String, Action>();

        appendAction(new SearchItemByNameAction(this));
        appendAction(new SearchItemsByPriceAction(this));
        appendAction(new SearchGiftByNameAction(this));
        appendAction(new SearchGiftsByPointsValueAction(this));
        appendAction(new SearchCustomerByNameAction(this));
        
        appendAction(new CreateItemAction(this));
        appendAction(new CreateGiftAction(this));

        appendAction(new SaleItemAction(this));
        appendAction(new RedeemGiftAction(this));

        appendAction(new GenerateCustomerListAction(this));
        appendAction(new GenerateItemListAction(this));
        appendAction(new GenerateGiftListAction(this));
        appendAction(new GenerateStoreReportAction(this));
    }
    
    /**
     * obtain the store object
     * @return the store object
     * @see Store
     */
    public Store getStore(){
        return this.store;
    }
     
    /**
     * obtain the IOUtility object
     * @return the IOUtility object
     * @see IOUtility
     */
    public IOUtility getIOUtility(){
        return this.ioutility;
    }
   
    /**
     * call a registered menu by its unique menu identity
     * @return true if the call has been performed successfully or false when it is not.
     * @see Menu
     */
    public boolean callMenu(String menuIdentity){
        Menu menu = this.menuMap.get(menuIdentity);
        if(menu == null){
            getIOUtility().log("Terminal", "menu does not exist");
            return false;
        }
        if(menu.getTerminal() != this){
            getIOUtility().log("Terminal", "menu is not safe to call");
            return false;
        }
        menu.enter();
        return true;
    }
    
    protected boolean appendMenu(Menu menu){
        if(this.menuMap.containsKey(menu.getMenuIdentity())){
            getIOUtility().log("Terminal", "Can not append a menu with existing menu identity");
            return false;
        }
        this.menuMap.put(menu.getMenuIdentity(), menu);
        return true;
    }
    
    protected boolean removeMenu(String menuIdentity){
        if(this.menuMap.remove(menuIdentity) == null){
            getIOUtility().log("Terminal", "Can not remove a menu with given menu identity");
            return false;
        }
        return true;
    }
    
    /**
     * call a registered action by its unique action identity
     * @return true if the call has been performed successfully or false when it is not.
     * @see Action
     */
    public boolean callAction(String actionIdentity){
        Action action = this.actionMap.get(actionIdentity);
        if(action == null){
            getIOUtility().log("Terminal", "action does not exist");
            return false;
        }
        if(action.getTerminal() != this){
            getIOUtility().log("Terminal", "action is not safe to call");
            return false;
        }
        action.start();
        return true;
    }
    
    protected boolean appendAction(Action action){
        if(this.actionMap.containsKey(action.getActionIdentity())){
            getIOUtility().log("Terminal", "Can not append a action with existing action identity");
            return false;
        }
        this.actionMap.put(action.getActionIdentity(), action);
        return true;
    }
    
    protected boolean removeAction(String actionIdentity){
        if(this.actionMap.remove(actionIdentity) == null){
            getIOUtility().log("Terminal", "Can not remove a action with given action identity");
            return false;
        }
        return true;
    }
    
    /**
     * set a new store object
     * @param store the new store object
     */
    public void setStore(Store store){
        this.store = store;
    }
    
    /**
     * Start the terminal loop and enter the main menu.
     */
    public void execute(){
        this.running = true;
        getIOUtility().log("Terminal", "Enter main loop");
        while(this.running){
            //enterMainMenu(this.scanner);
            callMenu("MAIN_MENU");
        }
    }
    
    /**
     * Shutdown the terminal loop
     */
    public void terminate(){
        this.running = false;
        //close the terminal scanner
        //no more string for you, scanner.
        //this.scanner.close();
        getIOUtility().log("Terminal", "Shutdown main loop");
    }
    
}
