/**
 * Root class of all other menu classes
 * 
 * @author Xu Waycell, Way Studios
 */
public abstract class Menu
{
    /**
     * the unique menu identity
     */
    final private String identity;
    /**
     * menu title
     */
    private String title;
    /**
     * menu content. for example, the menu options and descriptions.
     */
    private String content;
    /**
     * true if the menu has been entered.
     */
    private boolean focus;
    /**
     * the owner
     * @see Terminal#callMenu
     */
    private Terminal terminal;
    
    /**
     * Constructor for objects of class Menu
     * @see Terminal#callMenu
     */
    public Menu(String initialIdentity, String initialTitle, String initialContent, Terminal initialTermial){
        this.identity = initialIdentity;
        initialize(initialTitle, initialContent, initialTermial);
    }
    
    /**
     * Initialize the class
     * @param initialTitle the initial menu title
     * @param initialContent the initial menu content
     * @param initialTermial the initial menu owner
     */
    private void initialize(String initialTitle, String initialContent, Terminal initialTermial){
        
        this.title = initialTitle;
        this.content = initialContent;
        this.focus = false;
        this.terminal = initialTermial;
    }
    
    /**
     * Obtain the unique menu identity
     * @return the identity string
     */
    final public String getMenuIdentity(){
        return this.identity;
    }
    
    /**
     * Get menu title
     * @return The menu title
     */
    public String getMenuTitle(){
        return this.title;
    }
    
    /**
     * Obtain menu content
     * @return The menu contents such as menu options and descriptions.
     */
    public String getMenuContent(){
        return this.content;
    }
    
    /**
     * Obtain its parent
     * @return The owner of the menu
     * @see Terminal#callMenu(String)
     * @see setTerminal(Terminal)
     */
    public Terminal getTerminal(){
        return this.terminal;
    }
    
    /**
     * Set a new menu parent to replace the older one
     * @param newTerminal The new terminal object as a master of the menu
     * @see getTerminal()
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
     * Initiate the menu loop and display its content for menu interaction.
     * @see leave()
     */
    public void enter(){
        this.focus = true;
        while(this.focus){
            printMenu();
            int option = getIOUtility().getNumbericInput("Please input a number of menu option:", "\nPlease input a NUMBER ONLY of given menu option:");
            processMenuOption(option);
        }
    }
    
    /**
     * Shutdown menu loop and leave it
     * @see enter()
     */
    public void leave(){
        this.focus = false;
    }
    
    /**
     * True if the menu has been entered
     * @return True when the menu is initiated or false it is not.
     */
    public boolean isFocus(){
        return this.focus;
    }
    
    /**
     * Print menu content including the menu title and its content to terminal
     */
    protected void printMenu(){
        getIOUtility().clearScreen();
        getIOUtility().println(this.title);
        getIOUtility().printSeparateLine();
        getIOUtility().println(this.content);
        getIOUtility().printSeparateLine();
    }
    
    /**
     * Process numberic menu option</br>
     * <strong>NOTE:It is highly essential to implement this method in any derived class</strong>
     */
    protected abstract void processMenuOption(int option);

    /**
     * Call other menus from the parent terminal via this method
     * @param menuIdentity Unique menu identity
     * @return True if successed
     */
    protected boolean callMenu(String menuIdentity){
        return getTerminal().callMenu(menuIdentity);
    }
    
    /**
     * Call actions from the parent terminal via this method
     * @param actionIdentity Unique action identity
     * @return True if successed
     */
    protected boolean callAction(String actionIdentity){
        return getTerminal().callAction(actionIdentity);
    }
    
    /**
     * Reset menu title</br>
     * <strong>NOTE:DO NOT RESET THE MENU TITLE IF IT IS NOT NECESSARY, OTHERWISE IT WILL CONFUSE THE USERS.</strong>
     * @param newTitle The new menu title.
     * @see setMenuContent(String)
     */
    protected void setMenuTitle(String newTitle){
        this.title = newTitle;
    }
    
    /**
     * Set new content for menu to replace the older one
     * @param newContent The new menu content
     * @see setMenuTitle(String)
     */
    protected void setMenuContent(String newContent){
        this.content = newContent;
    }

}
