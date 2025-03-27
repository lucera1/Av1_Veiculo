package com.curso.resources;

import com.curso.domains.Gerente;
import com.curso.domains.dtos.GerenteDTO;
import com.curso.services.GerenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/gerente")
public class GerenteResource {

    @Autowired
    private GerenteService gerenteService;

    @GetMapping
    public ResponseEntity<List<GerenteDTO>> findAll() {
        return ResponseEntity.ok().body(gerenteService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GerenteDTO> findById(@PathVariable Long id) {
        Gerente obj = this.gerenteService.findById(id);
        return ResponseEntity.ok().body(new GerenteDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<GerenteDTO> findByCpf(@PathVariable String cpf) {
        Gerente obj = this.gerenteService.findByCpf(cpf);
        return ResponseEntity.ok().body(new GerenteDTO(obj));
    }


    @GetMapping(value = "/email/{email}")
    public ResponseEntity<GerenteDTO> findByEmail(@PathVariable String email){
        Gerente obj = this.gerenteService.findByEmail(email);
        return ResponseEntity.ok().body(new GerenteDTO(obj));
    }

    @PostMapping
    public ResponseEntity<GerenteDTO> create(@Valid @RequestBody GerenteDTO objDto){
        Gerente newObj = gerenteService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GerenteDTO> update(@PathVariable Long id, @Valid @RequestBody GerenteDTO objDto){
        Gerente Obj = gerenteService.update(id, objDto);
        return ResponseEntity.ok().body(new GerenteDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<GerenteDTO> delete(@PathVariable Long id){
        gerenteService.delete(id);
        return ResponseEntity.noContent().build();
    }



}


