/**
 * Redeem gifts to a customer by searching both name of them in the store.
 * <strong>NOTE:This action is case sensitive</strong>
 * 
 * @see MainMenu
 * @see Store#redeemGiftToCustomer(Customer, Gift, int)
 * 
 * @author Xu Waycell, Way Studios
 */
public class RedeemGiftAction extends Action
{
    /**
     * Constructor for objects of class RedeemGiftAction
     */
    public RedeemGiftAction(Terminal initialTerminal){
        super("REDEEM_GIFT_ACTION", initialTerminal);
    }
    
    /**
     * Routine to interact with user to perform a redeem gift action</br>
     * <strong>NOTE:This action is case sensitive</strong>
     * 
     * @see MainMenu
     * @see Store#redeemGiftToCustomer(Customer, Gift, int)
     */
    protected void routine(){
        getIOUtility().clearScreen();
        getIOUtility().println("Redeem Gift to Customer by searching both name");

        //can not sale nothing ;)
        if(getStore().getTotalAvailableGifts() == 0 || getStore().getTotalCustomers() == 0){
            getIOUtility().println("Can not perform operation");
            getIOUtility().waitEnter("Press ENTER to back to previous menu.");
            stop();
            return;
        }

        String giftName = getIOUtility().getStringInput("Input the name of the gift to perform(ignore case):", "Invalid input");
        Gift gift = getStore().findGiftByNameIgnoreCase(giftName);
        if(gift != null){
            String customerName = getIOUtility().getStringInput("Input the name of the customer to perform(ignore case):", "Invalid input");
            Customer customer = getStore().findCustomerByNameIgnoreCase(customerName);

            if(customer != null){

                int quantity;

                //prepare the quantity of selected item
                do{
                    quantity = getIOUtility().getNumbericInput(String.format("Please input the quantity of %s (0 to cancel):", gift.getName()), String.format("Please input the NUMBERIC quantity of %s (0 to cancel):", gift.getName()));
                }while(quantity < 0);

                if(quantity == 0){
                    getIOUtility().println("Canceled");
                } else {
                    getStore().redeemGiftToCustomer(customer, gift, quantity);
                }
            } else {
                getIOUtility().print(String.format("Customer %s does not exist.", customerName));
            }
        } else {
            getIOUtility().print(String.format("Gift %s does not exist.", giftName));
        }
        if(!getIOUtility().getBooleanInput("Redeem another one?(y or n)"))
            stop();
    }

}
