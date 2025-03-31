/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBKey;
import co.edu.sena.examplejdbc.model.Key;
import java.util.List;

/**
 *
 * @author Daniel Albeiro Ortiz Manzanares
 */
public class TestKey {
    public static void main(String[] args) {
        DBKey dbKey = new DBKey();
        
        //insertar
        
        Key key = new Key(1, "Sala Informatica", "Sala 1", 2, "Llavero con algo azul");
//        dbKey.insert(key);
        
        //actualizar
        
//        key.setId(5);
//        key.setName("Bicentenario");
//        key.setRoom("Sala 202");
//        key.setCount(1);
//        key.setObservation("Cambio de llavero");
//        dbKey.update(key);

        //eliminar
        
//        dbKey.delete(5);

        //consultar todos
        
        System.out.println("***********************************");
        
        List<Key> findAll = dbKey.findAll();
        
        for (Key k : findAll) {
            System.out.println("id: " + k.getId() + " name: " + k.getName()+
            " room: " + k.getRoom() + " count: " + k.getRoom() + " observation: " 
                                                            + k.getObservation());
        }
        
        //consultar por id
        
        System.out.println("*************************************");
        
        Key key2 = dbKey.findById(3);
        
        if(key2 != null)
        {
            System.out.println("id: " + key2.getId() + " name: " + key2.getName()+
            " room: " + key2.getRoom() + " count: " + key2.getRoom() + " observation: " 
                                                            + key2.getObservation());
        }
        else
        {
            System.out.println("No existe una llave con ese id");
        }
    }
}
