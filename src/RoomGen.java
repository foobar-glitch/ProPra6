public interface RoomGen<K, V> {
    K getName();
    double getLength();
    double getWidth();
    double getArea();

    V getValue();
    void setValue(V room);
}