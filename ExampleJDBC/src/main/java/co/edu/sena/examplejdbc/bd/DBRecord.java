/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import co.edu.sena.examplejdbc.model.Record;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha: 20/03/2025
 * @author Daniel Albeiro Ortiz Manzanares
 * Objetivo: Permite consultas y transacciones en la tabla Record
 */
public class DBRecord extends DBConnection {
    public void insert(Record record) {
        //METODO PARA INSERTAR
        try {
            connect();
            String sql = "INSERT INTO `record` (`id`, `date_record`, `start_time`, `end_time`, `employee_id`, `key_id`, `status`) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, record.getId());
            preparedStatement.setString(2, record.getDate_record());
            preparedStatement.setString(3, record.getStart_time());
            preparedStatement.setString(4, record.getEnd_time());
            preparedStatement.setString(5, record.getStatus());
            preparedStatement.setLong(6, record.getEmployee().getDocument()); //FOREIGN KEY
            preparedStatement.setInt(7, record.getKey().getId()); //FOREIGN KEY
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } 
        catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al insertar Registro "+
                                                e.getMessage());
        }
        finally{
            disconnect();
        }
    }
    
    public void update(Record record){
        //METODO PARA ACTUALIZAR
        try {
            connect();
            String sql = "UPDATE `record` SET `date_record`= = ?, `start_time` = ?, `end_time` = ?, `employee_id` = ?, `key_id` = ?, `status` = ? WHERE `id` = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, record.getDate_record());
            preparedStatement.setString(2, record.getStart_time());
            preparedStatement.setString(3, record.getEnd_time());
            preparedStatement.setString(4, record.getStatus());
            preparedStatement.setInt(5, record.getKey().getId()); //FOREIGN KEY
            preparedStatement.setLong(6, record.getEmployee().getDocument()); //FOREIGN KEY
            preparedStatement.setInt(7, record.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } 
        catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al actualizar Registro "+
                                                e.getMessage());
        }
        finally{
            disconnect();
        }
    }
    
    public void delete(int id){
        //METODO PARA ELIMINAR
        try {
            connect();
            String sql = "DELETE FROM `record` WHERE `id` = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } 
        catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al eliminar empleado "+
                                                e.getMessage());
        } 
        finally {
            disconnect();
        }
    }
    
    public List <Record> findAll(){
        //METODO PARA CONSULTAR TODOS
        List<Record> results = new ArrayList();
        DBKey dbkey = new DBKey();
        DBEmployee dbe = new DBEmployee();
        try {
            connect();
            String sql = "SELECT FROM `record`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                Record record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDate_record(resultSet.getString("date_record"));
                record.setDate_record(resultSet.getString("start_time"));
                record.setDate_record(resultSet.getString("end_time"));
                record.setDate_record(resultSet.getString("status"));
                //FOREIGN KEY EMPLOYEE
                Employee employee = dbe.findById(resultSet.getLong("document"));
                record.setEmployee(employee);
                //FOREIGN KEY KEY
                Key key = dbkey.findById(resultSet.getInt("id"));
                record.setKey(key);
            }
        } 
        catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar tipo de registros" +
                                        e.getMessage());
        } 
        finally {
            disconnect();
        }
        return results;
    }
    
    public Record findById(int id){
        //METODO PARA CONSULTAR POR ID
        Record record = null;
        DBKey dbkey = new DBKey();
        DBEmployee dbe = new DBEmployee();
        try {
            connect();
            String sql = "SELECT * FROM `record` WHERE `id` = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                record = new Record();
                record.setId(resultSet.getInt("id"));
                record.setDate_record(resultSet.getString("date_record"));
                record.setDate_record(resultSet.getString("start_time"));
                record.setDate_record(resultSet.getString("end_time"));
                record.setDate_record(resultSet.getString("status"));
                //FOREGIN KEY EMPLOYEE
                Employee employee = dbe.findById(resultSet.getLong("document"));
                record.setEmployee(employee);
                //FOREIGN KEY KEY
                Key key = dbkey.findById(resultSet.getInt("id"));
                record.setKey(key);
            }
            resultSet.close();
            preparedStatement.close();
        } 
        catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar tipo de registro" +
                                            e.getMessage());
        } 
        finally {
            disconnect();
        }
        return record;
    }
    
}
