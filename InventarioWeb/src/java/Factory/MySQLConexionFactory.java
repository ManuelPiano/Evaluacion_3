/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author manuelpiano31
 */
public final class MySQLConexionFactory extends ConexionDB {

    public MySQLConexionFactory(String[] criterios) {
        this.parametros = criterios;
        this.open();
    }

    @Override
    public Connection open() {
    try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_inventario?zeroDateTimeBehavior=convertToNull", "root", "");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return this.conexion;
    }

}
