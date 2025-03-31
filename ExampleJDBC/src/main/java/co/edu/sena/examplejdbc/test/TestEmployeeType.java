/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBEmployeeType;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Daniel Albeiro Ortiz Manzanares
 * Objetivo: Probar consultas/transacciones en tabla employee_type
 */
public class TestEmployeeType {
    public static void main(String[] args) {
        DBEmployeeType dBEmployeeType = new DBEmployeeType();
        
        //insertar
        
        EmployeeType employeeType = new EmployeeType(6, "SUBDIRECTOR");
//      dBEmployeeType.insert(employeeType);
        
        //actualizar
        
//        employeeType.setId(5);
//        employeeType.setDescript("COORDINADOR");
//        dBEmployeeType.update(employeeType);

        //eliminar
        
//        dBEmployeeType.delete(5);
        
        //consultar todos
        System.out.println("*****************************************");
        
        List<EmployeeType> findAll = dBEmployeeType.findAll();
        
        for (EmployeeType e : findAll) {
            System.out.println("id: " + e.getId() + " descript: " + e.getDescript());
        }
        
        //consultar por id
        
        System.out.println("*****************************************");
        
        EmployeeType employeeType2 = dBEmployeeType.findById(3);
        
        if (employeeType2 != null)
        {
            System.out.println("id: " + employeeType2.getId() + 
                            " descript " + employeeType2.getDescript());
        }
        else
        {
            System.out.println("No existe el EmployeeType con ese id");
        }
    }
}
