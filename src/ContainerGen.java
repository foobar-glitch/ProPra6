public abstract class ContainerGen<K, V  extends ContainerInterface<K>> {

    private final String name;
    private final LinkedMapGen<K, V> map;

    /**
     * Creates new Element of this with Unique name name
     * @param name name!=null, Unique name of this
     */
    public ContainerGen(String name){
        this.name = name;
        this.map = new LinkedMapGen<K, V>();
    }

    /**
     * Add elem to this
     * @param elem elem!=null, elem to add
     */
    public void add(V elem){
        map.put(elem.id(), elem);
    }

    /**
     * Remove elem from this
     * @param elem element to remove
     * @return Element which was removed or Null if no such Element was in this
     */
    public boolean remove(V elem){
        if(map.get(elem.id()) == null) return false;
        map.remove(elem.id());
        return true;
    }

    /**
     * Displays all relevant information about this in the Terminal
     */
    public void print(){
        IteratorGen<V> elems = map.getValues();
        System.out.println(name);
        System.out.println("-------------------------");
        while(elems.hasNext()){
            System.out.println("\t" + elems.next().toString());
        }
    }

    /**
     * @return Unique Name of this
     */
    public String getName(){return name;}

    /**
     * @return Map of all "subelements" which are managed in this
     */
    protected LinkedMapGen<K, V> map(){return map;}

}
