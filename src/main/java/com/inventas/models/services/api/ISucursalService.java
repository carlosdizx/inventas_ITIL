package com.inventas.models.services.api;

import com.inventas.models.entity.Empresa;
import com.inventas.models.entity.Sucursal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISucursalService
{
    List<Sucursal> findAll();

    Page<Sucursal> paginate(Pageable pageable);

    Sucursal save(Sucursal sucursal);

    Sucursal findById(Integer id);
}
