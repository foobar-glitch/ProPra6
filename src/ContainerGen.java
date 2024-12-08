public abstract class ContainerGen<K, V  extends ContainerInterface<K>> {

    private final String name;
    private final LinkedMapGen<K, V> map;

    public ContainerGen(String name){
        this.name = name;
        this.map = new LinkedMapGen<K, V>();
    }

    public void add(V elem){
        map.put(elem.id(), elem);
    }

    public void remove(V elem){
        if(map.get(elem.id()) == null) return;
        map.remove(elem.id());
    }

    public void print(){
        IteratorGen<V> elems = map.getValues();
        System.out.println(name);
        System.out.println("-------------------------");
        while(elems.hasNext()){
            System.out.println(elems.next());
        }
    }

    public String getName(){return name;}

    protected LinkedMapGen<K, V> map(){return map;}

}
