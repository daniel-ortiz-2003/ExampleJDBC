/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.bd.DBRecord;
import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 * Fecha:25/03/2025
 * @author Daniel Albeiro Ortiz Manzanares
 * Objetivo: Implementar la interface para controlar el metodo Record
 */
public class RecordController implements IRecordController{
    
    private DBRecord dbr = new DBRecord();

    @Override
    public void insert(Record record) throws Exception {
        if(record == null)
        {
            throw new Exception("El registro es obligatorio");
        }
        
        if(record.getId() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        if("".equals(record.getDate_record()))
        {
            throw new Exception("La fecha de registro es obligatoria");
        }
        
        if("".equals(record.getStart_time()))
        {
            throw new Exception("La hora de inicio del registro es obligatoria");
        }
        
        //FK
        if(record.getEmployee() == null)
        {
            throw new Exception("El registro del empleado es obligatorio");
        }
        
        //FK
        if(record.getKey() == null)
        {
            throw new Exception("El registro de la llave es obligatorio");
        }
        
        //insertar
        dbr.insert(record);
    }

    @Override
    public void update(Record record) throws Exception {
        if(record == null)
        {
            throw new Exception("El registro es obligatorio");
        }
        
        if(record.getId() == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        if("".equals(record.getDate_record()))
        {
            throw new Exception("La fecha de registro es obligatoria");
        }
        
        if("".equals(record.getStart_time()))
        {
            throw new Exception("La hora de inicio del registro es obligatoria");
        }
        
        //FK
        if(record.getEmployee() == null)
        {
            throw new Exception("El registro del empleado es obligatorio");
        }
        
        //FK
        if(record.getKey() == null)
        {
            throw new Exception("El registro de la llave es obligatoria");
        }
        
        //consultar si el registro existe en la bd
        Record recordExists = dbr.findById(record.getId());
        if(recordExists == null)
        {
            throw new Exception("El registro no existe");
        }
        
        //actualizar
        dbr.update(record);
    }

    @Override
    public void delete(int id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        
        Record recordExists = dbr.findById(id);
        if(recordExists == null)
        {
            throw new Exception("El registro no existe");
        }
        
        //eliminar
        dbr.delete(id);
    }

    @Override
    public List <Record> findAll() throws Exception {
        return dbr.findAll();
    }

    @Override
    public Record findById(int id) throws Exception {
        if(id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        return dbr.findById(id);
    }
}
