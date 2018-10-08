import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ATLASConnectionTest {

    public static void main(String[] argv) {

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=tlntifz02.gitest.telenor.com)(PORT=1683))(ADDRESS=(PROTOCOL=TCP)(HOST=tlntatl12-vip.gitest.telenor.com)(PORT=1531)))(SOURCE_ROUTE=YES)(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=ATL10)))",
                                        "SYS_INT2POC", "Sept_2018");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("Connection successful with ATLAS");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

}
