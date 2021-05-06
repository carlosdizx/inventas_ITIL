package com.inventas.models.services.impl;

import com.inventas.models.dao.IEmpresaDao;
import com.inventas.models.entity.Empresa;
import com.inventas.models.services.api.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServiceImpl implements IEmpresaService
{
    @Autowired
    private IEmpresaDao dao;

    @Override
    public Empresa save(Empresa empresa)
    {
        return dao.save(empresa);
    }
}
