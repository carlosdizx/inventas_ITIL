package com.inventas.controllers;

import com.inventas.models.entity.Empresa;
import com.inventas.models.services.api.IEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/empresa")
public class EmpresaRestController
{
    @Autowired
    private IEmpresaService service;

    @GetMapping("/all")
    public List<Empresa> findAll()
    {
        return service.findAll();
    }

    @GetMapping("/page/{page}")
    public Page<Empresa> paginate(@PathVariable Integer page)
    {
        return (Page<Empresa>) service.paginate(PageRequest.of(page,10));
    }

    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> save(@RequestBody Empresa pEmpresa)
    {
        final Map<String,Object> response =new HashMap<>();
        try
        {
            final Empresa empresa = service.save(pEmpresa);
            if (empresa==null)
            {
                response.put("Mensaje","La empresa no se pudo registrar, verifique los datos!");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            response.put("Mensaje","La empresa se registro con exito!");
            response.put("Empresa",empresa);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (DataAccessException e)
        {
            response.put("Mensaje","No se ha logrado realizar la insercion en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
