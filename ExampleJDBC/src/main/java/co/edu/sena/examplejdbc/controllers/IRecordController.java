/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejdbc.controllers;

import co.edu.sena.examplejdbc.model.Record;
import java.util.List;

/**
 * Fecha:25/03/2025
 * @author Daniel Albeiro Ortiz Manzanares
 * Objetivo: Interface para el metodo record
 */
public interface IRecordController {
    public void insert(Record record) throws Exception;
    public void update(Record record) throws Exception;
    public void delete(int id) throws Exception;
    public List <Record> findAll() throws Exception;
    public Record findById(int id) throws Exception;
}
