// TODO begruendung, dass hier die Verwendung von Generezitaet sich einfach nicht anbietet
public interface Room {
    String getName();
    double getLength();
    double getWidth();
    double getArea();

    Space space();
    void setSpace(Space space);
}