/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registroestudiante;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Juan Jose Ospina B
 */
public class Registroestudiante {

    private static String url = "jdbc:mysql://localhost/registroestudiante";//127.0.0.1
    private static String usuario = "root";
    private static String contraseña = "juanjose2809";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("conexion establecida a la base de datos");
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return conexion;
    }

    public static void main(String[] args) {
        try {
            Connection conexion = conectar();
//            String sql = "INSERT INTO id_estu (nombre,id_estu,codigo) values ('carlos',1212,3232)";
//            String sql = "delete from id_estu where id_estu =112";
//              String sql = "update id_estu set nombre='luis' ,id_estu=011, codigo=02 where id_estu=1232";
//String sql = "select * from id_estu";
            String sql = "create database prueba";

            PreparedStatement sentecia = conexion.prepareStatement(sql);
            sentecia.executeUpdate();
            conexion.close();

        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }

    }
}
