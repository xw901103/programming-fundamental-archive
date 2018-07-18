/**
 * Sale item to customer by name action by searching both name of them in the store.
 * <strong>NOTE:This action is case sensitive</strong>
 * 
 * @see MainMenu
 * @see Store#saleItemToCustomer(Customer, Item, int)
 * 
 * @author Xu Waycell, Way Studios
 */
public class SaleItemAction extends Action
{
    /**
     * Constructor for objects of class SaleItemAction
     */
    public SaleItemAction(Terminal initialTerminal){
        super("SALE_ITEM_ACTION", initialTerminal);
    }

    /**
     * Routine to interact with user to perform a sale item action</br>
     * <strong>NOTE:This action is case sensitive</strong>
     * 
     * @see MainMenu
     * @see Store#saleItemToCustomer(Customer, Item, int)
     */
    protected void routine(){
        getIOUtility().clearScreen();
        getIOUtility().println("Sale Item to Customer by searching both name");

        //can not sale nothing ;)
        if(getStore().getTotalAvailableItems() == 0 || getStore().getTotalCustomers() == 0){
            getIOUtility().println("Can not perform operation");
            getIOUtility().waitEnter("Press ENTER to back to previous menu.");
            stop();
            return;
        }

        String itemName = getIOUtility().getStringInput("Input the name of the item to perform(ignore case):", "Invalid input");
        Item item = getStore().findItemByNameIgnoreCase(itemName);
        if(item != null){
            String customerName = getIOUtility().getStringInput("Input the name of the customer to perform(ignore case):", "Invalid input");
            Customer customer = getStore().findCustomerByNameIgnoreCase(customerName);

            if(customer != null){

                int quantity;

                //prepare the quantity of selected item
                do{
                    quantity = getIOUtility().getNumbericInput(String.format("Please input the quantity of %s (0 to cancel):", item.getName()), String.format("Please input the NUMBERIC quantity of %s (0 to cancel):", item.getName()));
                }while(quantity < 0);

                if(quantity == 0){
                    getIOUtility().println("Canceled");
                } else {
                    getStore().saleItemToCustomer(customer, item, quantity);
                }
            } else {
                getIOUtility().print(String.format("Customer %s does not exist.\n", customerName));
            }
        } else {
            getIOUtility().print(String.format("Item %s does not exist.\n", itemName));
        }
        if(!getIOUtility().getBooleanInput("Sale another one?(y or n)"))
            stop();
    }

}
