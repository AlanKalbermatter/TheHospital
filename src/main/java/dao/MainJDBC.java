package dao;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MainJDBC {
    private static final Logger logger = Logger.getLogger(MainJDBC.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("/home/kalber/workspace/HospitalModelWithMvn/src/main/resources/log4j2.properties");

    }
}
