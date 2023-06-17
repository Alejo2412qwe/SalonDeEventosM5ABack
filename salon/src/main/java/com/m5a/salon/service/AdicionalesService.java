/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.service;

import com.m5a.salon.genericService.GenericService;
import com.m5a.salon.genericService.GenericServiceImpl;
import com.m5a.salon.model.entity.Adicionales;
import com.m5a.salon.repository.AdicionalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author LaptopSA
 */
@Service
public class AdicionalesService extends GenericServiceImpl<Adicionales, Integer> implements GenericService<Adicionales, Integer> {

    @Autowired
    public AdicionalesRepository adicionalesRepository;

    @Override
    public CrudRepository<Adicionales, Integer> getDao() {
        return adicionalesRepository;
    }
}
