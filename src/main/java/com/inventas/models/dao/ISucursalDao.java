package com.inventas.models.dao;

import com.inventas.models.entity.Empresa;
import com.inventas.models.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISucursalDao extends JpaRepository<Sucursal,Integer>
{

}
