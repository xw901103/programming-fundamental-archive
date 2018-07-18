import java.util.*;
/**
 * IOUtility is a class to help and pack output and input operation
 * 
 * @author Xu Waycell, Way Studios
 */
public class IOUtility
{
    /**
     * A input stream scanner which has been configured specially
     */
    private Scanner scanner;

    /**
     * Constructor for objects of class IOUtility
     */
    public IOUtility(){
        this.scanner = new Scanner(System.in);
        //replace the delimiter from whitespace to the new line, therefore we can get a whole string after user hit enter.
        this.scanner.useDelimiter("\n");
    }

    /**
     * Print given message to terminal
     * @param message the message will be displayed
     */
    public void print(String message){
        System.out.print(message);
    }

    /**
     * Print a line of given message to terminal
     * @param message the message will be displayed
     */
    public void println(String message){
        System.out.println(message);
    }

    /**
     * Clear up all output contents of the terminal.
     * 
     * NOTE:It only works in native java terminal.
     */
    public void clearScreen(){
        //comment following line if you wanna see all messages or the solution is not compatible.
        System.out.print("\f");
    }

    /**
     * Obtain a numberic input figure via message interaction
     * @param message the normal message
     * @param advancedMessage the advanced message once user did not input the value in a acceptable way.
     * @return the user input value
     */
    public int getNumbericInput(String message, String advancedMessage){
        print(message);
        while(!this.scanner.hasNextInt()){
            //silly method to flush the buffer of Scanner
            this.scanner.next();
            print(advancedMessage);
        }
        return this.scanner.nextInt();
    }

    /**
     * Obtain a float input figure via message interaction
     * @param message the normal message
     * @param advancedMessage the advanced message once user did not input the value in a acceptable way.
     * @return the user input value
     */
    public float getFloatInput(String message, String advancedMessage){
        print(message);
        while(!this.scanner.hasNextFloat()){
            this.scanner.next();
            System.out.print(advancedMessage);
        }
        return this.scanner.nextFloat();
    }

    /**
     * Obtain a string input figure via message interaction
     * @param message the normal message
     * @param advancedMessage the advanced message once user did not input the value in a acceptable way.
     * @return the user input value
     */
    public String getStringInput(String message, String advancedMessage){
        while(true){
            String tmp;
            do{
                print(message);
                tmp = this.scanner.next();
                if(tmp.length()==0)
                    println(advancedMessage);
            } while(tmp.length()==0);
            return tmp;
        }
    }

    /**
     * Obtain a boolean input figure via message interaction. y or Y for true and n or N for false.
     * @param message the normal message
     * @return the user input value, y or Y return true and n or N return false
     */
    public boolean getBooleanInput(String message){
        while(true){
            String tmp;
            do{
                print(message);
                tmp = this.scanner.next();
            } while(tmp.length()==0);

            char cond = tmp.charAt(0);
            if(cond == 'y' || cond == 'Y')
                return true;
            if(cond == 'n' || cond == 'N')
                return false;
        }
    }

    /**
     * Print a line of * in the terminal to separate context
     */
    public void printSeparateLine(){
        //for default shell 80 charaters
        System.out.println("*******************************************************************************");
    }

    /**
     * Block standard in stream until that user hit enter.
     * @param message the mssage as a notification will be displayed
     */
    public void waitEnter(String message){
        print(message);
        this.scanner.next();
    }

    /**
     * Log given message from a sender with a timestamp in milliseconds.
     * @param sender the log message sender
     * @param content the log message itself
     */
    public void log(String sender, String content){
        //for this assignment, all log messages will be printed out to terminal.
        //comment the following line if you do not want to see any log.
        System.out.printf("LOG %s:%s - %s \n", System.currentTimeMillis(), sender, content);
    }
}
