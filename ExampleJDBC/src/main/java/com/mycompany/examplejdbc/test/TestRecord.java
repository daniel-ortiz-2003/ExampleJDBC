/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examplejdbc.test;

import com.mycompany.examplejdbc.bd.DBEmployee;
import com.mycompany.examplejdbc.bd.DBKey;
import com.mycompany.examplejdbc.bd.DBRecord;
import com.mycompany.examplejdbc.model.Employee;
import com.mycompany.examplejdbc.model.Key;
import com.mycompany.examplejdbc.model.Record;
import java.util.List;

/**
 * Fecha: 20/03/2025
 * @author Daniel Albeiro Ortiz
 * Objetivo: Probar consultas y transacciones en la tabla record
 */
public class TestRecord {
    public static void main(String[] args) {
        DBRecord dbrec = new DBRecord();
        DBKey dbkey = new DBKey();
        DBEmployee dbe = new DBEmployee();
        
        //INSERTAR
        Key key = dbkey.findById(1);
        Employee employee = dbe.findById(5);
        Record record = new Record(5, "2025-03-20", "11:20:00", "12:35:00", "ENTREGADO", key, employee);
        dbrec.insert(record);
        
        //ACTUALIZAR
//        record.setDate_record("15:33:00");
        //FOREIGN KEY EMPLOYEE
//        record.setEmployee(employee);
        //FOREIGN KEY KEY
        record.setKey(key);
//        dbrec.update(record);
        
        //ELIMINAR
//        dbrec.delete(2025);
        
        //CONSULTAR TODOS
        System.out.println("********************************");
        
        List<Record> records = dbrec.findAll();
        for (Record r : records) {
            System.out.println("id: " + r.getId() + " date_record " + r.getDate_record() + " start_time " +
                                r.getStart_time() + " end_time " + r.getEnd_time() + " status " + r.getStatus() +
                                " key " + r.getKey().getId() + " employee " + r.getEmployee().getDocument());
        }
        
        //CONSULTAR POR ID
        System.out.println("********************************");
        
        Record record2 = dbrec.findById(2025);
        System.out.println("id: " + record2.getId() + " date_record " + record2.getDate_record() + " start_time " +
                                record2.getStart_time() + " end_time " + record2.getEnd_time() + " status " + record2.getStatus() +
                                " key " + record2.getKey().getId() + " employee " + record2.getEmployee().getDocument());
    }
}
