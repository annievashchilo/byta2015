package planes;

public class SuperGuppy extends Plane {

    private final float capacity = 2000f;        // грузоподъемность
    private final float volume = 42420f;         // объём
    private final float range = 14500f;          // дальность полёта
    private final float speed = 1000;            // скорость
    private String m_name;

    public SuperGuppy(String name) {
        super(name);
    }

    public float getCapacity() {
        return capacity;
    }

    public float getVolume() {
        return volume;
    }

    public float getRange() {
        return range;
    }

    public float getSpeed() {
        return speed;
    }

    public String getName() {
        return m_name;
    }
}
