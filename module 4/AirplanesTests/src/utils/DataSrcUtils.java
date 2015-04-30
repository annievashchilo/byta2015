package utils;

import exceptions.CompanyNotFoundException;
import planes.Plane;

import java.util.List;


public interface DataSrcUtils {

    String getAviacompany(String companyName) throws CompanyNotFoundException;

    List<Plane> getAirplanes();

    boolean isCompanyPresent(String company) throws CompanyNotFoundException;
}
