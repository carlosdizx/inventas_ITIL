package com.inventas.models.services.impl;

import com.inventas.models.dao.IEmpresaDao;
import com.inventas.models.dao.ISucursalDao;
import com.inventas.models.entity.Empresa;
import com.inventas.models.entity.Sucursal;
import com.inventas.models.services.api.IEmpresaService;
import com.inventas.models.services.api.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SucursalServiceImpl implements ISucursalService
{
    @Autowired
    private ISucursalDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Sucursal> findAll()
    {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Sucursal> paginate(Pageable pageable)
    {
        return dao.findAll(pageable);
    }

    @Override
    @Transactional
    public Sucursal save(Sucursal sucursal)
    {
        return dao.save(sucursal);
    }

    @Override
    public Sucursal findById(Integer id)
    {
        return dao.findById(id).orElse(null);
    }
}
