public interface Room {
    String getName();
    double getLength();
    double getWidth();
    double getArea();

    Space space();
    void setSpace(Space space);
}