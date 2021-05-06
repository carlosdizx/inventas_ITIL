package com.inventas.models.dao;

import com.inventas.models.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpresaDao extends JpaRepository<Empresa,Integer>
{

}
