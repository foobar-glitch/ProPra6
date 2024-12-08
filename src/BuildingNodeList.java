public class BuildingNodeList {


    private BuildingNode start = null;

    /**
     * Adds elem to NodeList
     * @param elem (elem!=null)
     */
    public void add(Building elem){
        if(start == null){start = new BuildingNode(elem); return;}
        BuildingNode tmp = start;
        while(tmp.next() != null){tmp = tmp.next();}
        tmp.setNext(new BuildingNode(elem));
    }

    /**
     * Removes first Element equal to this from this NodeList
     * @param elem (elem!=null) elem to remove
     * @return true => NodeList contained elem || false => NodeList didn't contain elem
     */
    public boolean remove(Building elem){
        if(start == null) return false;
        BuildingNode tmp = start;
        // Special case if start is removed
        if(start.value().equals(elem)){start = start.next(); return true;}
        // Else
        while(tmp.next() != null){
            // If tmp.next equals elem, remove it and fix list
            if(tmp.next().value().equals(elem)){
                tmp.setNext(tmp.next().next());
                return true;
            }
            // Else go to next Node
            tmp = tmp.next();
        }
        return false;
    }

    /**
     * Removes all occurrences of elem in NodeList
     * @param elem (!= null)
     * @return true (elem existed in NodeList) || false (elem didn't exist in NodeList)
     */
    public boolean removeAll(Building elem){
        if(!contains(elem)) return false;

        boolean state = true;
        while (state){
            state = remove(elem);
        }

        return true;
    }

    /**
     * Does NodeList contain this Object?
     * @param elem (elem!= null)
     * @return True (NodeList contains elem); False (NodeList doesn't contain elem)
     */
    public boolean contains(Building elem){
        if(start== null) return false;
        BuildingNode tmp = start;
        while (tmp != null){
            if(tmp.value().equals(elem)) return true;
            tmp = tmp.next();
        }
        return false;
    }

    /**
     * Retrieves Element at Index index, if there is no elem at index return null
     * @param index Index of element to be retrieved
     * @return Elem or Null if no element exists at this index
     */
    public Building get(int index){
        if(start == null) return null;

        int i = 0;
        BuildingNode tmp = start;
        while (tmp != null){
            if(i++ == index) return tmp.value();
            tmp = tmp.next();
        }

        return null;
    }

    /**
     * @return Number of Elements in NodeList
     */
    public int length(){

        int len = 0;
        if(start == null) return len;

        BuildingNode tmp = start;
        while(tmp != null){len++; tmp=tmp.next();}

        return len;
    }

    /**
     * Live-Iterator over all elements in NodeList
     * @return Iterator
     */
    public BuildingNodeListIterator iterator(){
        return new BuildingNodeListIterator(start);
    }

    /**
     * @return String in Array Style, containing all elements in NodeList [x0, x1, x2, ...]
     */
    @Override
    public String toString(){
        if(start == null) return "[]";
        StringBuilder stringBuilder = new StringBuilder();
        BuildingNode tmp = start;
        while(tmp != null){
            stringBuilder.append(tmp.value()).append(", ");
            tmp = tmp.next();
        }
        return "[" + stringBuilder.substring(0, stringBuilder.length()-2) + "]";
    }

}
