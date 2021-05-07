package com.inventas.controllers;

import com.inventas.models.entity.Empresa;
import com.inventas.models.entity.Sucursal;
import com.inventas.models.services.api.IEmpresaService;
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
@RequestMapping("/sucursal")
public class SucursalRestController
{
    @Autowired
    private ISucursalService service;

    @GetMapping("/all")
    public List<Sucursal> findAll()
    {
        return service.findAll();
    }

    @GetMapping("/page/{page}")
    public Page<Sucursal> paginate(@PathVariable Integer page)
    {
        return (Page<Sucursal>) service.paginate(PageRequest.of(page,4));
    }

    @PostMapping("/")
    public ResponseEntity<Map<String,Object>> save(@RequestBody Sucursal pSucursal)
    {
        final Map<String,Object> response =new HashMap<>();
        try
        {
            final Sucursal sucursal = service.save(pSucursal);
            if (sucursal==null)
            {
                response.put("Mensaje","La sucrusal no se pudo registrar, verifique los datos!");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            response.put("Mensaje","La sucursal se registro con exito!");
            response.put("Sucursal",sucursal);
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
    public ResponseEntity<Map<String,Object>> update(@RequestBody Sucursal pSucursal, @PathVariable Integer id)
    {
        final Map<String,Object> response =new HashMap<>();
        try
        {
            final Sucursal sucursal = service.findById(id);
            if (sucursal==null)
            {
                response.put("Mensaje","La sucrusal no se pudo actualizar su informacion, verifique los datos!");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            sucursal.setMunicipio(pSucursal.getMunicipio());
            sucursal.setDepartamento(pSucursal.getDepartamento());
            sucursal.setPais(pSucursal.getPais());
            sucursal.setDireccion(pSucursal.getDireccion());
            sucursal.setCodigoPostal(pSucursal.getCodigoPostal());
            sucursal.setTelefono(pSucursal.getTelefono());
            sucursal.setCelular(pSucursal.getCelular());
            sucursal.setCorreo(pSucursal.getCorreo());
            sucursal.setEstado(pSucursal.isEstado());
            response.put("Mensaje","La sucursal fue actualizada con exito!");
            response.put("Sucursal",service.save(sucursal));
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
