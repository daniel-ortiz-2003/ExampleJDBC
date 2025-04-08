 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.bd;

import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.utils.MessageUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Fecha: 14/03/2025
 * @author Daniel Albeiro Ortiz Manzanares
 */
public class DBKey extends DBConnection{
    public void insert(Key key){
        try {
            connect();
            String sql = "INSERT INTO `key` (name, room, count, observation) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key.getName());
            preparedStatement.setString(2, key.getRoom());
            preparedStatement.setInt(3, key.getCount());
            preparedStatement.setString(4, key.getObservation());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al insertar una llave"+
                                        e.getMessage());
        }
        finally
        {
            disconnect();
        }
    }
    
    public void update(Key key){
        try {
            connect();
            String sql = "UPDATE `key` set name = ?, room = ?, count = ?, observation = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, key.getName());
            preparedStatement.setString(2, key.getRoom());
            preparedStatement.setInt(3, key.getCount());
            preparedStatement.setString(4, key.getObservation());
            preparedStatement.setInt(5, key.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al actualizar una llave"+
                                        e.getMessage());
        }
        finally
        {
            disconnect();
        }
    }
    
    public void delete(int id){
        try {
            connect();
            String sql = "DELETE FROM `key` WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al eliminar una llave"+
                                        e.getMessage());
        }
        finally
        {
            disconnect();
        }
    }
    
    public List<Key> findAll(){
        List<Key> results = new ArrayList<>();
        try {
            connect();
            String sql = "SELECT * FROM `key`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while(resultSet.next())
            {
                Key key = new Key();
                key.setId(resultSet.getInt("id"));
                key.setName(resultSet.getString("name"));
                key.setRoom(resultSet.getString("room"));
                key.setCount(resultSet.getInt("count"));
                key.setObservation(resultSet.getString("observation"));
                results.add(key);
            }
            resultSet.close();
            
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar las llaves"+ 
                                                            e.getMessage());
        }
        finally{
            disconnect();
        }
        return results;
    }
    
    public Key findById(int id){
        Key key = null;
        try {
            connect();
            String sql = "SELECT * FROM `key` WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                key = new Key();
                key.setId(resultSet.getInt("id"));
                key.setName(resultSet.getString("name"));
                key.setRoom(resultSet.getString("room"));
                key.setCount(resultSet.getInt("count"));
                key.setObservation(resultSet.getString("observation"));
            }
            resultSet.close();
            preparedStatement.close();
            
        } catch (SQLException e) {
            MessageUtils.showErrorMessage("Error al consultar las llaves" + e.getMessage());
        }
        finally{
            disconnect();
        }
        return key;
    }
}
