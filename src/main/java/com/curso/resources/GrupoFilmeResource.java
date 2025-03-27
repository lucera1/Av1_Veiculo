package com.curso.resources;

import com.curso.domains.Cliente;
import com.curso.domains.Filme;
import com.curso.domains.GrupoFilme;
import com.curso.domains.dtos.ClienteDTO;
import com.curso.domains.dtos.FilmeDTO;
import com.curso.domains.dtos.GrupoFilmeDTO;
import com.curso.services.GrupoFilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/grupofilme")
public class GrupoFilmeResource {

    @Autowired
    private GrupoFilmeService grupoFilmeService;

    @GetMapping
    public ResponseEntity<List<GrupoFilmeDTO>> findAll(){
        return ResponseEntity.ok().body(grupoFilmeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GrupoFilmeDTO> findbyId(@PathVariable Long id){
        GrupoFilme obj = this.grupoFilmeService.findbyId(id);
        return ResponseEntity.ok().body(new GrupoFilmeDTO(obj));
    }
    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<GrupoFilmeDTO> findById(@PathVariable String nome){
        GrupoFilme obj = this.grupoFilmeService.findbynome(nome);
        return ResponseEntity.ok().body(new GrupoFilmeDTO(obj));
    }
   @PostMapping
    public ResponseEntity<GrupoFilmeDTO> create (@Valid @RequestBody GrupoFilmeDTO dto){
        GrupoFilme grupoFilme = grupoFilmeService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(grupoFilme.getIdGrupoFilme()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value ="/{id}")
    public ResponseEntity<GrupoFilmeDTO> update(@PathVariable Long id, @Valid @RequestBody GrupoFilmeDTO objDto){
        GrupoFilme obj = grupoFilmeService.update(id, objDto);
        return ResponseEntity.ok().body(new GrupoFilmeDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<GrupoFilmeDTO> delete(@PathVariable Long id){
        grupoFilmeService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
