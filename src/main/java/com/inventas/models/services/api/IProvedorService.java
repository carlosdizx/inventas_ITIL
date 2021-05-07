package com.inventas.models.services.api;

import com.inventas.models.entity.Provedor;
import com.inventas.models.entity.Sucursal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProvedorService
{
    List<Provedor> findAll();

    Page<Provedor> paginate(Pageable pageable);

    Provedor save(Provedor provedor);

    Provedor findById(Integer id);
}
