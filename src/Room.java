// TODO begruendung, dass hier die Verwendung von Generezitaet sich einfach nicht anbietet
public interface Room {

    /**
     * @return Unique Name of this Room
     */
    String getName();

    /**
     * @return length of this Room in meter
     */
    double getLength();

    /**
     * @return width of this Room in meter
     */
    double getWidth();

    /**
     * @return area of this room (in m^2)
     */
    double getArea();

    /**
     * @return Usage of this room
     */
    Space space();

    /**
     * Changes/Overrides the usage of this room to space
     * @param space space!=null, New Usage of Room
     */
    void setSpace(Space space);
}