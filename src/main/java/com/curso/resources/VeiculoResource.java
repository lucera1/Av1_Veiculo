package com.curso.resources;

import com.curso.domains.Veiculo;
import com.curso.domains.dtos.VeiculoDTO;
import com.curso.services.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping //exemplo: localhost:8080/veiculo
    public ResponseEntity<List<VeiculoDTO>> findAll(){
        return ResponseEntity.ok().body(veiculoService.findAll());

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id){
        Veiculo obj = this.veiculoService.findbyId(id);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable String cpf){
        Veiculo obj = this.veiculoService.findbyCpf(cpf);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO dto){
        Veiculo veiculo = veiculoService.create(dto);
        //Cria a URI para o recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(veiculo.getId()).toUri();
        //Retorna a resposta com o status 201 Created e o local do recurso criado
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @Valid @RequestBody VeiculoDTO objDto){
        Veiculo Obj = veiculoService.update(id,objDto);
        return ResponseEntity.ok().body(new VeiculoDTO(Obj));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> delete(@PathVariable Long id){
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
