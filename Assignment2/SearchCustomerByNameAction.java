/**
 * This action provides search customer service by collect its unique item name.</br>
 * <strong>THIS ACTION IS NOT CASE SENSITIVE!</strong>
 * 
 * @see SearchMenu
 * 
 * @author Xu Waycell
 */
public class SearchCustomerByNameAction extends Action
{
    /**
     * Constructor for objects of class SearchCustomerByNameAction
     */
    public SearchCustomerByNameAction(Terminal initialTerminal){
        super("SEARCH_CUSTOMER_BY_NAME_ACTION", initialTerminal);
    }

    /**
     * The action routine is to search a customer by its unique name and print found customer's detail for each loop circle.</br>
     * <strong>THIS ACTION IS NOT CASE SENSITIVE!</strong>
     */
    protected void routine(){
        getIOUtility().clearScreen();
        getIOUtility().println("Search a customer by name");
        String customerName = getIOUtility().getStringInput("Input the name of the customer to perform(ignore case):", "Invalid input");
        Customer customer = getStore().findCustomerByNameIgnoreCase(customerName);
        if(customer == null){
            getIOUtility().print(String.format("Boo, nobody is %s \n", customerName));
        }else{
            String group = "UNKNOW";
            switch(customer.getGroup()){
                case DEFAULT:
                group = "DEFAULT";
                break;
                case VIP:
                group = "VIP";
                break;
            }
            getIOUtility().print(String.format("%s Group: %s Cash Balance: %.2f Point: %d Total Purchase: %d Total Redeem: %d \n", customer.getName(), group, customer.currentCashBalance(), customer.currentPointBalance(), customer.getPurchaseCount(), customer.getRedeemCount()));
        }
        if(!getIOUtility().getBooleanInput("Search someone else?(y or n)"))
            stop();
    }

}
