package utils;

import exceptions.CompanyNotFoundException;


public interface DataSrcUtils {

    //TODO: fix this
    public String getAviacompany(String companyName) throws CompanyNotFoundException;

    public void getAirplanes();
}
