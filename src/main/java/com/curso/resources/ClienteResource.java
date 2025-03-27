package com.curso.resources;


import com.curso.domains.Cliente;
import com.curso.domains.dtos.ClienteDTO;
import com.curso.domains.dtos.GrupoFilmeDTO;
import com.curso.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll(){
        return ResponseEntity.ok().body(clienteService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){
        Cliente obj = this.clienteService.findbyId(id);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }
    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable String nome){
        Cliente obj = this.clienteService.findbynome(nome);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> create (@Valid @RequestBody ClienteDTO dto){
        Cliente cliente = clienteService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getIdCliente()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO objDto){
        Cliente obj = clienteService.update(id, objDto);
        return ResponseEntity.ok().body(new ClienteDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
