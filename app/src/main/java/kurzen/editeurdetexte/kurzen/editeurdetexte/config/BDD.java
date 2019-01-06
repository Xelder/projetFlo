package kurzen.editeurdetexte.kurzen.editeurdetexte.config;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class BDD {

    private String urlBDD= "jdbc:postgresql://localhost/ScenariOST";
    private static ConnectionSource connectionSource = null;

    public BDD(){

        try{
            connectionSource= new JdbcConnectionSource(urlBDD);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public String getUrlBDD() {
        return urlBDD;
    }

    public static ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        connectionSource.close();
    }

}
