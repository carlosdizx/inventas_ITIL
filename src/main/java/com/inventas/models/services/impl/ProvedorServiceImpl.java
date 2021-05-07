package com.inventas.models.services.impl;

import com.inventas.models.dao.IProvedorDao;
import com.inventas.models.dao.ISucursalDao;
import com.inventas.models.entity.Provedor;
import com.inventas.models.entity.Sucursal;
import com.inventas.models.services.api.IProvedorService;
import com.inventas.models.services.api.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProvedorServiceImpl implements IProvedorService
{
    @Autowired
    private IProvedorDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Provedor> findAll()
    {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Provedor> paginate(Pageable pageable)
    {
        return dao.findAll(pageable);
    }

    @Override
    @Transactional
    public Provedor save(Provedor provedor)
    {
        return dao.save(provedor);
    }

    @Override
    public Provedor findById(Integer id)
    {
        return dao.findById(id).orElse(null);
    }
}
