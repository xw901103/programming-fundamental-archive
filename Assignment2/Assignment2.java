import java.util.*;
/**
 * A demostration instance of assignment 2.
 * @see Terminal
 * @see Store
 * @see Item
 * @see Gift
 * @see Customer
 * @author Xu Waycell, Way Studios
 * @date 12th Dec
 */
public class Assignment2
{
    /**
     * main entry of this assignment 2 demostration.
     */
    public static void main(String args[]){
        Store store = new Store();
        
        Random random = new Random();
        //initialize 5 customers with random cash balance in store for demostration
        for(int i=0;i<5;++i)
        {
            Customer customer = store.createCustomer(String.format("CUSTOMER %d", i));
            customer.setCashBalance((float)random.nextInt(256) + 16.0f);
        }
        //initialize 5 items with random price in store for demostration
        for(int i=0;i<5;++i)
        {
            Item item = store.createItem(String.format("ITEM %d", i));
            item.setPrice((float)random.nextInt(50));
            item.setAvailability(random.nextBoolean());
        }
        //initialize 5 gifts with random points value in store for demostration
        for(int i=0;i<5;++i)
        {
            Gift gift = store.createGift(String.format("GIFT %d", i));
            gift.setPoint(random.nextInt(32));
            gift.setAvailability(random.nextBoolean());
        }
        
        Terminal terminal = new Terminal(store);
        terminal.execute();
        
        System.out.println("G'Bye!");
    }
}
