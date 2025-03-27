package com.curso.resources;

import com.curso.domains.Cliente;
import com.curso.domains.Filme;
import com.curso.domains.dtos.ClienteDTO;
import com.curso.domains.dtos.FilmeDTO;
import com.curso.domains.dtos.GrupoFilmeDTO;
import com.curso.services.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/filme")
public class FilmeResource {

    @Autowired
    private FilmeService filmeService;


    @GetMapping
    private ResponseEntity<List<FilmeDTO>> findAll(){
        return ResponseEntity.ok().body(filmeService.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<FilmeDTO> findbyId(@PathVariable Long id){
        Filme obj = this.filmeService.findbyId(id);
        return ResponseEntity.ok().body(new FilmeDTO(obj));
    }

    @GetMapping(value = "/titulo/{titulo}")
    public ResponseEntity<FilmeDTO> findById(@PathVariable String titulo){
        Filme obj = this.filmeService.findbytitulo(titulo);
        return ResponseEntity.ok().body(new FilmeDTO(obj));
    }
    @PostMapping
    public ResponseEntity<FilmeDTO> create (@Valid @RequestBody FilmeDTO dto){
       Filme filme = filmeService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(filme.getIdFilme()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value ="/{id}")
    public ResponseEntity<FilmeDTO> update(@PathVariable Long id, @Valid @RequestBody FilmeDTO objDto){
        Filme obj = filmeService.update(id, objDto);
        return ResponseEntity.ok().body(new FilmeDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<FilmeDTO> delete(@PathVariable Long id){
        filmeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
