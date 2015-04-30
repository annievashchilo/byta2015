package planes;

public class Plane extends AbstractPlane {

    private String m_planeName;

    public Plane(String name) {
        m_planeName = name;
    }

    public float getCapacity() {
        return 0;
    }

    public float getVolume() {
        return 0;
    }

    public float getRange() {
        return 0;
    }

    public float getSpeed() {
        return 0;
    }

    public String getName() {
        return m_planeName;
    }

    @Override
    public String toString() {
        return String.format(
                "%s '%s': v=%.2f, c=%.2f, r=%.2f, s=%.2f",
                getClass().getSimpleName(),
                m_planeName,
                getCapacity(),
                getVolume(),
                getRange(),
                getSpeed()
        );
    }
}
