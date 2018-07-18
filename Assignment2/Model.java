/**
 * Abstract class Model - the root of all other store components.
 * 
 * @see ModelStackArray<T>
 * @see Store
 * @author Xu Waycell, Way Studios
 */
public abstract class Model{
    /**
     * The owner of the object
     */
    private Store store;
    
    /**
     * The only constructor to construct a object based on a Model class with given parent object.
     * @param initialStore The owner of the object
     */
    public Model(Store initialStore){
        this.store = initialStore;
    }
    
    /**
     * Obtain the object owner
     * @return The owner of this object, null if there is no one.
     * @see Store
     */
    public Store getStore(){
        return this.store;
    }
    
    /**
     * Set a new owner
     * @param newStore The new owner to replace the old one.
     * @see Store
     */
    public void setStore(Store newStore){
        this.store = newStore;
    }
}
