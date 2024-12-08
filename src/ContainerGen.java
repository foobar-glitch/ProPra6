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

    public void print(int nrTabs){
        String tabs = "";
        for (int i = 0; i < nrTabs; i ++) {
            tabs = tabs.concat("\t");
        }
        IteratorGen<V> elems = map.getValues();
        System.out.println(tabs + name);
        System.out.println("-------------------------");
        while(elems.hasNext()){
            elems.next().print();
        }
    }

    public String getName(){return name;}

    protected LinkedMapGen<K, V> map(){return map;}

}
