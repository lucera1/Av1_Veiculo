package com.curso.resources;

import com.curso.domains.Cliente;
import com.curso.domains.GrupoFilme;
import com.curso.domains.Sessao;
import com.curso.domains.dtos.ClienteDTO;
import com.curso.domains.dtos.GrupoFilmeDTO;
import com.curso.domains.dtos.SessaoDTO;
import com.curso.services.SessaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/sessao")
public class SessaoResource {

    @Autowired
    private SessaoService sessaoService;

    @GetMapping
    private ResponseEntity<List<SessaoDTO>> findAll(){
        return ResponseEntity.ok().body(sessaoService.findAll());
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity<SessaoDTO> findById(@PathVariable Long id){
        Sessao obj = this.sessaoService.findbyId(id);
        return ResponseEntity.ok().body(new SessaoDTO(obj));
    }
    @PostMapping
    public ResponseEntity<SessaoDTO> create (@Valid @RequestBody SessaoDTO dto){
        Sessao sessao = sessaoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(sessao.getIdSessao()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value ="/{id}")
    public ResponseEntity<SessaoDTO> update(@PathVariable Long id, @Valid @RequestBody SessaoDTO objDto){
        Sessao obj = sessaoService.update(id, objDto);
        return ResponseEntity.ok().body(new SessaoDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SessaoDTO> delete(@PathVariable Long id){
        sessaoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
