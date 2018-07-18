/**
 * The base class of all other action classes.
 *
 * @see Terminal
 * @see Menu
 * @author Xu Waycell, Way Studios
 */
public abstract class Action
{
    /**
     * The unique identity of the action
     */
    final private String identity;
    /**
     * True if the action is in action
     */
    private boolean running;
    /**
     * The parent
     */
    private Terminal terminal;
    
    /**
     * Constructor for objects of class Action
     * @param actionIdentity    The unique identity of the action
     * @param initialTerminal   The parent
     */
    public Action(String actionIdentity, Terminal initialTerminal){
        this.identity = actionIdentity;
        this.running = false;
        this.terminal = initialTerminal;
    }

    /**
     * Obtain the unique identity of a action
     * @return The unique action identity
     */
    final public String getActionIdentity(){
        return this.identity;
    }
    
    /**
     * Get action parent object
     * @return The owner of the action.
     */
    public Terminal getTerminal(){
        return this.terminal;
    }
    
    /**
     * Set a new owner to the action
     * @param newTerminal Its new master.
     */
    public void setTerminal(Terminal newTerminal){
        this.terminal = newTerminal;
    }
    
    /**
     * Obtain a IOUtility from its master.</br>
     * <strong>NOTE:There is no a method called setIOUtility because it is unnecessary</strong>
     * @return A IOUtility to handle and help input and output operations.
     * @see Terminal#getIOUtility()
     * @see IOUtility
     */
    protected IOUtility getIOUtility(){
        return this.terminal.getIOUtility();
    }
    
    /**
     * Get the action owner.
     * @return The owner of the action.
     */
    protected Store getStore(){
        return this.terminal.getStore();
    }
    
    /**
     * Start the action loop until the method stop has been called.
     * @see stop()
     * @see isRunning()
     */
    public void start(){
        this.running = true;
        while(this.running)
            routine();        
    }
    
    /**
     * Stop the action loop.
     * @see start()
     * @see isRunning()
     */
    public void stop(){
        this.running = false;
    }
    
    /**
     * Check if the action is running or not
     * @return True when it is in action or false if it is not.
     * @see start()
     * @see stop()
     */
    public boolean isRunning(){
        return this.running;
    }

    /**
     * A abstract method interface will be called in each loop circle.</br>
     * <strong>NOTE:It is very important to implement this method in each derived classes</strong>
     */
    protected abstract void routine();
}
