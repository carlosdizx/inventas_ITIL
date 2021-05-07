package com.inventas.models.services.impl;

import com.inventas.models.dao.IEmpresaDao;
import com.inventas.models.entity.Empresa;
import com.inventas.models.services.api.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresaServiceImpl implements IEmpresaService
{
    @Autowired
    private IEmpresaDao dao;

    @Override
    @Transactional(readOnly = true)
    public List<Empresa> findAll()
    {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Empresa> paginate(Pageable pageable)
    {
        return dao.findAll(pageable);
    }

    @Override
    @Transactional
    public Empresa save(Empresa empresa)
    {
        return dao.save(empresa);
    }
}
