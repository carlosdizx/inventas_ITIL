package com.inventas.controllers;

import com.inventas.models.entity.Provedor;
import com.inventas.models.entity.Sucursal;
import com.inventas.models.services.api.IProvedorService;
import com.inventas.models.services.api.ISucursalService;
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
@RequestMapping("/provedor")
public class ProvedorRestController
{
    @Autowired
    private IProvedorService service;

    @GetMapping("/all")
    public List<Provedor> findAll()
    {
        return service.findAll();
    }

    @GetMapping("/page/{page}")
    public Page<Provedor> paginate(@PathVariable Integer page)
    {
        return (Page<Provedor>) service.paginate(PageRequest.of(page,4));
    }

    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> save(@RequestBody Provedor pProvedor)
    {
        final Map<String,Object> response =new HashMap<>();
        try
        {
            final Provedor provedor = service.save(pProvedor);
            if (provedor==null)
            {
                response.put("Mensaje","El provedor no se pudo registrar, verifique los datos!");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            response.put("Mensaje","El provedor se registro con exito!");
            response.put("Provedor",provedor);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (DataAccessException e)
        {
            response.put("Mensaje","No se ha logrado realizar la insercion en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(@RequestBody Provedor pProvedor, @PathVariable Integer id)
    {
        final Map<String,Object> response =new HashMap<>();
        try
        {
            final Provedor provedor = service.findById(id);
            if (provedor==null)
            {
                response.put("Mensaje","El provedor no se pudo actualizar su informacion, verifique los datos!");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            provedor.setTipoDocumento(pProvedor.getTipoDocumento());
            provedor.setDocumento(pProvedor.getDocumento());
            provedor.setTelefono(pProvedor.getTelefono());
            provedor.setCorreo(pProvedor.getCorreo());
            provedor.setNombre(pProvedor.getNombre());
            response.put("Mensaje","El provedor fue actualizado con exito!");
            response.put("Provedor",service.save(provedor));
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
        catch (DataAccessException e)
        {
            response.put("Mensaje","No se ha logrado realizar la actualizacion en la base de datos");
            response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage() ));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
