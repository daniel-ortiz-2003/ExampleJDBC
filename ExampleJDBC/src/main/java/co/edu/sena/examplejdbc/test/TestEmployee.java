/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejdbc.test;

import co.edu.sena.examplejdbc.bd.DBEmployee;
import co.edu.sena.examplejdbc.bd.DBEmployeeType;
import co.edu.sena.examplejdbc.model.EmployeeType;
import co.edu.sena.examplejdbc.model.Employee;
import java.util.List;

/**
 * Fecha: 13/03/2025
 * @author Daniel Albeiro Ortiz Manzanares
 * Objetivo: Probar consultas y transacciones en la tabla Employee
 */
public class TestEmployee {
    public static void main(String[] args) {
        DBEmployee dbe = new DBEmployee();
        DBEmployeeType dbet = new DBEmployeeType();
        //insertar
        EmployeeType employeeType = dbet.findById(1);
        Employee employee = new Employee(1116, "hoola", "Av Sa", "320", employeeType);
//        dbe.insert(employee);
        
        //actualizar
        employee.setFullname("ELTON TITO");
        employeeType = dbet.findById(2); //FOREIGN KEY
        employee.setEmployeeType(employeeType);
//        dbe.update(employee);
        
//        //eliminar
//        dbe.delete(1678493);

        //consultar todos
        List<Employee> employees = dbe.findAll();
        for (Employee e : employees) {
            System.out.println("document: " + e.getDocument() + " fullname: " + e.getFullname()+
                                " address: " + e.getAddress() + " phone: " + e.getPhone() +
                                " type: " + e.getEmployeeType().getDescript());
        }
        
        //consultar por id
        System.out.println("********************************");
        Employee employee2 = dbe.findById(1678493);
        System.out.println("document: " + employee2.getDocument() + " fullname: " +
                            employee2.getFullname() + " address: " + employee2.getAddress() +
                            " phone: " + employee2.getPhone() + " type: " + employee2.getEmployeeType().getDescript());
        
    }
}
