package base.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Utils
{
    public static String configFile = "system.properties";
    public static String URL;
    public static String host;
    public static String port;
    public static String browserType;
    public static String runType;
    public static String POS;
    public static int timeout = 60000;
    public static int loggerSeverity;
    public static String pathToScreenshots;
    public static String pathToTestData;
    private static Logger logger = Logger.getLogger(Utils.class.getName());
    private static Properties PROPERTIES = new Properties();

    static
    {
        try
        {
            PROPERTIES.load(new FileInputStream(configFile));
            loadProperties();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Handler getHandler()
    {
        PropertyConfigurator.configure("log4j.properties");
        return Handler.getInstance();
    }

    public static String getConfigFile()
    {
        return configFile;
    }

    public static String getURL()
    {
        return URL;
    }

    public static void setURL(String URL)
    {
        Utils.URL = URL;
    }

    public static void setURL(String URL, String POS)
    {
        Utils.URL = URL + POS;
    }

    public static void setHost(String host)
    {
        Utils.host = host;
    }

    public static void setPort(String port)
    {
        Utils.port = port;
    }

    public static void setBrowserType(String browserType)
    {
        Utils.browserType = browserType;
    }

    public static void setRunType(String runType)
    {
        Utils.runType = runType;
    }

    public static void setPOS(String POS)
    {
        Utils.POS = POS;
    }

    public static void setTimeout(int timeout)
    {
        Utils.timeout = timeout;
    }

    public static void setLoggerSeverity(int loggerSeverity)
    {
        Utils.loggerSeverity = loggerSeverity;
    }

    public static String getPathToScreenshots()
    {
        return pathToScreenshots;
    }

    public static void setPathToScreenshots(String pathToScreenshots)
    {
        Utils.pathToScreenshots = pathToScreenshots;
    }

    public static void setPathToTestData(String pathToTestData)
    {
        Utils.pathToTestData = pathToTestData;
    }


    public static void loadProperties()
    {
        Properties props;

        props = new Properties();
        try
        {
            props.load(new FileInputStream(Utils.configFile));
            setBrowserType(props.getProperty("browserType"));
            setHost(props.getProperty("host"));
            setPort(props.getProperty("port"));
            setPOS(props.getProperty("POS"));
            setURL(props.getProperty("URL"), POS);
            setRunType(props.getProperty("runType"));
            setTimeout(Integer.parseInt(props.getProperty("timeout")));
            setLoggerSeverity(Integer.parseInt(props.getProperty("severity")));
            setPathToScreenshots(props.getProperty("pathToScreenshots"));
            setPathToTestData(props.getProperty("pathToData"));
        } catch (IOException e)
        {
            e.printStackTrace();
            logger.trace(e.getLocalizedMessage());
        }
    }
}
