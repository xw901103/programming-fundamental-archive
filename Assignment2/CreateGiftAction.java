/**
 * Create a gift by collecting user input attributes.
 * <strong>NOTE:This action is case sensitive</strong>
 * 
 * @author Xu Waycell, Way Studios
 */
public class CreateGiftAction extends Action
{
    /**
     * Constructor for objects of class CreateGiftAction
     */
    public CreateGiftAction(Terminal initialTerminal){
        super("CREATE_GIFT_ACTION", initialTerminal);
    }
    
    /**
     * Create gift routine</br>
     * This action might show fail to create a gift if there is one with the same name or out of space of gift container in the store</br>
     * <strong>NOTE:This action is case sensitive</strong>
     * 
     * @see Store#createGift(String)
     */
    protected void routine(){
        getIOUtility().clearScreen();
        getIOUtility().println("Add gift to store");
        String giftName;
        String giftDescription;
        int giftPoint = 0;
        boolean giftAvailability = false;
        
        giftName = getIOUtility().getStringInput("Gift name:", "Invalid input");
        
        if(getStore().findGiftByNameIgnoreCase(giftName) == null){

            giftDescription = getIOUtility().getStringInput("Type gift description below:\n", "Invalid input");
            
            giftPoint = getIOUtility().getNumbericInput("Gift point:", "Gift point(example 8):");
            
            Gift gift = getStore().createGift(giftName);
            gift.setDescription(giftDescription);
            gift.setPoint(giftPoint);
            gift.setAvailability(true);
        } else {
            getIOUtility().print(String.format("Gift %s exists in the store. Please try another name.\n", giftName));
        }
        
        if(!getIOUtility().getBooleanInput("Add another one?(y or n)"))
            stop();
    }

}
