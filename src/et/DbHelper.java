package et;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Locale;

public class DbHelper {
    public static Connection getConnetion() throws Exception {
        Locale.setDefault(Locale.ENGLISH);
        Context context = new InitialContext();
        DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/elmirtaghisoy");
        Connection c = dataSource.getConnection();
        return c;
    }
}
