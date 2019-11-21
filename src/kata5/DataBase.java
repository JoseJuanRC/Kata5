package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {

    private String url;
    private Connection connection = null;
    
    public DataBase(String url) {
        this.url = url;
    }

    void open() {
        try {
            this.connection = DriverManager.getConnection(this.url);
            System.out.println("Base de Datos abierta...");
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::open (SQLException " + ex.getMessage());
        }
    }

    void close() {
        if (this.connection != null){
            try {
                this.connection.close();
                System.out.println("Base de Datos cerrada...");
            } catch (SQLException ex) {
                System.out.println("ERROR DataBase::close (SQLException " + ex.getMessage());
            }
        }
    }

    void select_PERSONAS() {
        String SQL = "SELECT * FROM PERSONAS";        
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery(SQL);
            
            System.out.println("ID  \t NOMBRE \t APELLIDOS \t DEPARTAMENTO");
            System.out.println("--  \t ------ \t --------- \t ------------");
            while(res.next()){
                System.out.println(res.getInt("ID") + " \t " + 
                        res.getString("NOMBRE") + " \t\t " + 
                        res.getString("APELLIDOS") + " \t\t " + 
                        res.getString("DEPARTAMENTO"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::select_PERSONAS (SQLException " + ex.getMessage());
        }
        
    }

    void insert_PERSONAS(People people) {
        String SQL = "INSERT INTO PERSONAS (NOMBRE, APELLIDOS, DEPARTAMENTO) VALUES(?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(SQL);
            ps.setString(1, people.getNombre());
            ps.setString(2, people.getApellido());
            ps.setString(3, people.getDepartamento());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::insert_PERSONAS (SQLException " + ex.getMessage());
        }
    }
    
    
}
