package utils;

import exceptions.CompanyNotFoundException;
import exceptions.DBNotFoundException;
import planes.Plane;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;


public class DBUtils implements DataSrcUtils {

    protected static PreparedStatement preparedStatement;
    private static volatile DBUtils instance;
    private static Connection c;
    private static ResultSet rs;
    protected final String db_props = "database.properties";
    private String user;
    private String password;
    private String driverName;
    private String db_url;

    /**
     * create only 1 instance of DBUtils, to open only 1 connection to database
     * lazy initialization
     * high performance
     *
     * @return localInstance
     */
    public static DBUtils getInstance() {
        DBUtils localInstance = instance;
        if (localInstance == null) {
            synchronized (DBUtils.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DBUtils();
                    try {
                        instance.openDBConnection();
                    } catch (DBNotFoundException e) {
                        System.err.println("Requested database not found " + e.getMessage());
                    }
                }
            }
        }
        return localInstance;
    }

    /**
     * make a request to database
     *
     * @param rq - template for query
     */
    public static ResultSet executeRequest(String rq) {

        try {
            preparedStatement = c.prepareStatement(rq);

            System.out.println("XXXX REQUEST:" + preparedStatement);
            rs = preparedStatement.executeQuery();
            System.out.println("Query successful -> OK");
        } catch (SQLException e) {
            System.err.println("Failed to make a request");
            System.err.println("SQLException: " + e.getMessage());
        }
        return rs;
    }

    /**
     * Read properties from file
     */
    private void readProperties() {
        Properties props = new Properties();

        try {
            FileInputStream file_in = new FileInputStream(db_props);
            props.load(file_in);
            file_in.close();
        } catch (IOException e) {
            System.err.println("Unable to load properties");
            return;
        }

        driverName = props.getProperty("driver");
        db_url = props.getProperty("db_url");
        user = props.getProperty("user");
        password = props.getProperty("password");
    }

    private void loadDriver() {
        try {
            Class.forName(driverName);
            System.out.println("\nDriver loaded successfully -> OK");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }
    }

    private void openDBConnection() throws DBNotFoundException {
        readProperties();
        loadDriver();
        try {
            c = DriverManager.getConnection(db_url, user, password);
            System.out.println("Connection to database opened");
        } catch (SQLException e) {
            System.err.println("Failed to open connection. url " + db_url);
            System.err.println("SQLException: \t" + e.getMessage());
            throw new DBNotFoundException();
        }
    }


    public String getAviacompany(String companyName) throws CompanyNotFoundException {
        System.out.println("\nLooking for " + companyName + " in database");

        String stmt = "SELECT `company_name` FROM `aviacompanies` WHERE `company_name` = '" + companyName + "'";
        String company = null;
        ResultSet rs = executeRequest(stmt);

        try {
            while (rs.next()) {
                if (rs.wasNull()) {
                    throw new CompanyNotFoundException();
                } else {
                    System.out.println();
                    company = rs.getString("company_name");
                    System.out.println("Company " + company + " was found in DB");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }


    public List<Plane> getAirplanes() {
        String stmt = "SELECT * FROM airplanes";

        ResultSet rs = DBUtils.executeRequest(stmt);

        try {
            while (rs.next()) {
                System.out.println();
                System.out.println(rs.getString(
                        "plane_name") +
                        "\nid:            " +
                        rs.getInt("plane_id") +
                        "\nrange:         " +
                        rs.getInt("plane_range") +
                        "\ncapacity:      " +
                        rs.getInt("plane_capacity") +
                        "\nvolume:        " +
                        rs.getInt("plane_volume") +
                        "\nspeed:         " +
                        rs.getInt("plane_speed"));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public boolean isCompanyPresent(String company) throws CompanyNotFoundException {
        String c = getAviacompany(company);
        return !c.isEmpty();
    }


}
