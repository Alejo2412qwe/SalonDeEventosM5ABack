/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.salon.service;

import com.m5a.salon.genericService.GenericService;
import com.m5a.salon.genericService.GenericServiceImpl;
import com.m5a.salon.model.entity.ImagenesProductos;
import com.m5a.salon.repository.ImgProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author LaptopSA
 */
@Service
public class ImagenesProductosService extends GenericServiceImpl<ImagenesProductos, Integer> implements GenericService<ImagenesProductos, Integer> {

    @Autowired
    public ImgProductosRepository imgProductosRepository;

    @Override
    public CrudRepository<ImagenesProductos, Integer> getDao() {
        return imgProductosRepository;
    }
}
