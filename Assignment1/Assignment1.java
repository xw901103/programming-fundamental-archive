/**
 * A demostration instance of assignment 1.
 * @see Customer
 * @see Item
 * @see Gift
 * @author Xu Waycell, Way Studios
 * @date 24th Oct
 */
public class Assignment1
{
    public static void main(String[] args) {
        Store store = new Store(); //create new Store instance
        //create a customer called Customer A and set cash balance to 100
        Customer customerA = store.createCustomer(new String("Customer A"));
        customerA.setCashBalance(100.0f);
        //create a customer called Customer B and set cash balance to 20
        Customer customerB = store.createCustomer(new String("Customer B"));
        customerB.setCashBalance(20.0f);
        //create a item called Item A and set price to 0.005 and enable it        
        Item itemA = store.createItem(new String("Item A"));
        itemA.setPrice(0.005f);
        itemA.setAvailability(true);
        //create an item called Item B and set price to 6.99 and enable it        
        Item itemB = store.createItem(new String("Item B"));
        itemB.setPrice(6.99f);
        itemB.setAvailability(true);
        //create an item called Item C and set price to 19.99 and enable it        
        Item itemC = store.createItem(new String("Item C"));
        itemC.setPrice(19.99f);
        itemC.setAvailability(true);
        //create an item called Item D and set price to 60.99 and enable it        
        Item itemD = store.createItem(new String("Item D"));
        itemD.setPrice(60.99f);
        itemD.setAvailability(true);
        //create a gift called Gift A and set required point to 3 and enable it        
        Gift giftA = store.createGift(new String("Gift A"));
        giftA.setPoint(3);
        giftA.setAvailability(true);
        //create a gift called Gift B and set required point to 9 and enable it        
        Gift giftB = store.createGift(new String("Gift B"));
        giftB.setPoint(9);
        giftB.setAvailability(true);
        
        store.saleItemToCustomer(customerA, itemA, 1);
        store.saleItemToCustomer(customerA, itemD, 1);
        store.redeemGiftToCustomer(customerA, giftB, 1);
        store.saleItemToCustomer(customerB, itemA, 10);
        
        store.generateReport();
    }
}
