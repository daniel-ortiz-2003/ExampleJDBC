/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.examplejdbc.controllers;

import com.mycompany.examplejdbc.model.Key;
import java.util.List;

/**
 * Fecha:25/03/2025
 * @author Daniel Albeiro Ortiz
 * Objetivo: Interface para el metodo Key
 */
public interface IKeyController {
    public void insert(Key key) throws Exception;
    public void update(Key key) throws Exception;
    public void delete(int id) throws Exception;
    public List <Key> findAll() throws Exception;
    public Key findById (int id) throws Exception;
}
