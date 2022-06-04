/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

import com.mysql.jdbc.Connection;
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
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.parametros["bd_inventario?zeroDateTimeBehavior=CONVERT_TO_NULL"], this.parametros["root"], this.parametros[""]);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return this.conexion;
    }

}
