/**
 * A last in first out array container for model and derived classes.</br>
 * <strong>This container can only handle a class derived from class Model</strong></br>
 * <strong>NOTE:This class requires the latest version of java runtime support.</strong>
 * 
 * @see Model
 * @author Xu Waycell, Way Studios
 */
public class ModelStackArray<T>
{
    /**
     * A native java array
     * This array is using to contain Model class handle
     */
    private Model[] array;
    /**
     * Total element counter, from 0 to the end of last valid object
     * This counter should not equal or cross over the length of array
     */
    private int total;
    
    /**
     * The iterator class for this stack
     * @author Xu Waycell, Way Studios
     */
    public class Iterator{
        /**
         * The position of the native array data, from 0 to total-1
         */
        private int current;
        /**
         * The parent object will be affected by the iterator
         */
        private ModelStackArray<T> master;
        
        /**
         * Constructor, iterator can only be assembled by the master container object.</br>
         * <strong>NOTE:The initial position of a new iterator will be at zero.</strong>
         * @see ModelStackArray<T>#getIterator()
         * @param initialMaster The parent will be affected by this iterator.
         */
        private Iterator(ModelStackArray<T> initialMaster){
            this.master = initialMaster;
            this.current = 0;
        }
        
        /**
         * Check current position, return false if it is at a valid element
         * @return return false if it is at the last valid element otherwise return true. 
         */
        public boolean hasNext(){
            if(this.current < this.master.getTotal())
                return true;
            return false;
        }
        
        /**
         * Return the current object and move the index to next element.</br>
         * <strong>NOTE:this method will return null if the index is not valid.</strong>
         * @return The object pointing by current index
         */
        public T next(){
            return this.master.at(this.current++);
        }
    }
    
    /**
     * Constructor for objects of class ModelStackArray will construct a container in given maximum capacity.
     * @param capacity The maximum capacity of this stack container.
     */
    public ModelStackArray(int capacity){
        array = new Model[capacity];
        total = 0;
    }
    
    /**
     * Obtain the total valid element number
     * @return The count of all elements
     */
    public int getTotal(){
        return this.total;
    }
    
    /**
     * Obtain the maximum capacity of this container
     * @return The maximum number of objects this array can contain
     */
    public int getCapacity(){
        return this.array.length;
    }
    
    /**
     * To append a new object to the stack at the top of it.</br>
     * <strong>NOTE:The element which pushes in this container must be a class derived from Model.</strong>
     * @param newElement The element will be push into the top position of the stack.
     * @return Return the top element of this stack or null if push operation failed.
     */
    @SuppressWarnings("unchecked")
    public T push(T newElement){
        if(this.total>=this.array.length)
            return null;
        this.array[this.total++] = (Model)newElement;
        return (T)this.array[(this.total-1)];
    }
    
    /**
     * Remove the latest object which has been inserted
     * @return The object has been removed from the stack
     */
    @SuppressWarnings("unchecked")
    public T pop(){
        //check border before anything
        if(this.total<=0)
            return null;

        T element = (T)this.array[--this.total];
        this.array[this.total] = null;
        return element;
    }
    
    /**
     * Obtain a object at the given position
     * return The element at the given index
     * @param index The position of the element located in the array
     * @return The object if valid index or null if it is not.
     */
    @SuppressWarnings("unchecked")
    public T at(int index){
        if(index<0 || index>=this.total)
            return null;
        return (T)this.array[index];
    }
    
    /**
     * Obtain the latest inserted object
     * @return The object at the top of the stack
     */
    @SuppressWarnings("unchecked")
    public T top(){
        return (T)this.array[(this.total-1)];
    }
    
    /**
     * Check if there is no more space for new objects
     * @return True if out of space or false when it is not.
     * @see ModelStackArray(int)
     * @see isEmpty()
     */
    public boolean isFull(){
        return this.total>=this.array.length;
    }
    
    /**
     * Check if the container it is empty
     * @return True if there is no object in the container or false it is not.
     * @see isFull()
     */
    public boolean isEmpty(){
        return this.total<=0;
    }
    
    /**
     * Obtain a new iterator for iteration
     * @return A new assembled iterator
     */
    public Iterator getIterator(){
        return new Iterator(this);
    }

}
