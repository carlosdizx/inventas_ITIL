package com.inventas.models.dao;

import com.inventas.models.entity.Provedor;
import com.inventas.models.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvedorDao extends JpaRepository<Provedor,Integer>
{

}
