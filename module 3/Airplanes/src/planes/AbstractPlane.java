package planes;


public abstract class AbstractPlane {
    String m_planeName;
    float capacity;
    float range;
    float speed;
    float volume;


    abstract float getCapacity();

    abstract float getVolume();

    abstract float getRange();

    abstract float getSpeed();

    abstract String getName();

}
