package aviacompanies;

import exceptions.PlaneNotFoundException;
import planes.Plane;

import java.util.ArrayList;
import java.util.List;

public class Aviacompany {

    private String m_companyName;
    private List<Plane> m_planes;

    public Aviacompany(String companyName) {
        m_planes = new ArrayList<Plane>();
        m_companyName = companyName;
    }

    public Aviacompany(String companyName, List<Plane> planes) {
        m_companyName = companyName;
        m_planes = planes;
    }

    /**
     * add Plane p to the aviacompany
     *
     * @param p - specified airplane
     */
    public void addPlaneToPark(Plane p) {
        m_planes.add(p);
    }

    /**
     * @return name of the aviacompany
     */
    public String getName() {
        return m_companyName;
    }

    /**
     * add List<Plane> p to the aviacompany
     *
     * @param p – list of m_planes
     */
    public void addPlanesToPark(List<Plane> p) {
        m_planes.addAll(p);
    }

    /**
     * get all m_planes in aviacompany
     *
     * @return List of m_planes
     */
    public List<Plane> getAviapark() {
        return m_planes;
    }


    /**
     * Method searches through each parameter of plane
     *
     * @param minCapacity min capacity of plane you are looking for
     * @param maxCapacity max capacity of plane you are looking for
     * @param minVolume   min volume of plane you are looking for
     * @param maxVolume   max volume of plane you are looking for
     * @param minRange    min range of plane you are looking for
     * @param maxRange    max range of plane you are looking for
     * @param minSpeed    min speed of plane you're lloking for
     * @param maxSpeed    min speed of plane you're looking for
     * @return a plane, that suits all specified parameters
     */
    public List<Plane> findPlane(
            float minCapacity,
            float maxCapacity,
            float minVolume,
            float maxVolume,
            float minRange,
            float maxRange,
            float minSpeed,
            float maxSpeed
    ) throws PlaneNotFoundException {
        List<Plane> result = new ArrayList<Plane>();

        for (Plane p : m_planes) {
            if ((p.getCapacity() >= minCapacity && p.getCapacity() <= maxCapacity)
                    || (p.getVolume() >= minVolume && p.getVolume() <= maxVolume)
                    || (p.getRange() >= minRange && p.getRange() <= maxRange)
                    || (p.getSpeed() >= minSpeed && p.getSpeed() <= maxSpeed)) {
                result.add(p);
            } else {
                throw new PlaneNotFoundException("Requested plane was not found");
            }
        }
        return result;
    }


    /**
     * Method will show common capacity of m_planes in aviacompany
     *
     * @return common capacity
     */
    public float getCommonCapacity() {
        float commonCapacity = 0;
        for (Plane p : m_planes) {
            commonCapacity += p.getCapacity();
        }
        return commonCapacity;
    }
}