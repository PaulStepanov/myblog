package database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Павел on 02-Sep-16.
 */
class SETTINGS {
    private static SETTINGS settings = new SETTINGS();
    private Properties propertie=new Properties();

    private SETTINGS() {
        try {
            propertie.load(new FileInputStream(this.getClass().getClassLoader().getResource("sql.properties").getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getProp(String propname) {
        return settings.propertie.getProperty(propname);
    }

}
