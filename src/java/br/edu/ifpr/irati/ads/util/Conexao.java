package br.edu.ifpr.irati.ads.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String PROTOCOLO = "jdbc:mysql";
    private static final String SERVIDOR = "//localhost";
    private static final String PORTA = "3306";
    private static final String BASEDADOS = "idh-reg";

    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    
    public Connection conectar() {
        try {
        
            Class.forName(DRIVER);
            String url = PROTOCOLO+":"+SERVIDOR+":"+
                    PORTA+"/"+BASEDADOS;
            
            return DriverManager.getConnection(url, USUARIO, 
                    SENHA);
        
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        } 
    }


}
