package com.inventas.models.services.api;

import com.inventas.models.entity.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmpresaService
{
    List<Empresa> findAll();

    Page<Empresa> paginate(Pageable pageable);

    Empresa save(Empresa empresa);
}
