/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Categoria;
import jakarta.resource.cci.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manuelpiano31
 */
public class CategoriaDAOImplementar implements CategoriaDAO {

    ConexionDB conn;
    public CategoriaDAOImplementar(){
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
    }
    @Override
    public List<Categoria> Listar() {
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_categoria;");
        List<Categoria> lista = new ArrayList<>();
        try{
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                Categoria categoria = new Categoria();
                categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
                categoria.setNom_categoria(resultadoSQL.getString("nom_categoria"));
                categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));
                lista.add(categoria);
            }
        }catch(SQLException ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
        return lista;
    }

    @Override
    public List<Categoria> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Categoria editarCat(int id_cat_edit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean guardarCat(Categoria categoria) {
this.conn = FactoryConexionDB.open (FactoryConexionDB.MySQL); 
//Hacer la conexión

boolean guarda = false; //Bandera de resultado

try {

if (categoria.getId_categoria() == 0) { //Para cuando es una nueva categoria

//Agregar consulta SQL; el id categoria es autoincrementable

StringBuilder miSQL= new StringBuilder(); 
miSQL.append("INSERT INTO tb categoria (nom_categoria, estado_categoria) VALUES (""); 
miSQL.append(categoria.getNom categoria() + ",").append(categoria.getEstado_categoria());
 miSQL.append(");(");

//Invocar método para ejecutar la consulta

this.conn.ejecutarSQL (miSQL.toString());

} else if  (categoria.getId_categoria() > 0) { //Actualizar, id categoria mayores a 0

} 
catch (Exception e) {

}finally{

this.conn.cerrarConexion(); //Cerrar conexión
}
return guarda;
}

    @Override
    public boolean borrarCat(int id_cat_borrar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
