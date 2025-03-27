package com.curso.services;


import com.curso.domains.Cliente;
import com.curso.domains.Filme;
import com.curso.domains.GrupoFilme;
import com.curso.domains.dtos.ClienteDTO;
import com.curso.domains.dtos.FilmeDTO;
import com.curso.domains.dtos.GrupoFilmeDTO;
import com.curso.repositories.GrupoFilmeRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GrupoFilmeService {

    @Autowired
    private GrupoFilmeRepository grupoFilmeRepo;

    public List<GrupoFilmeDTO> findAll(){

        return grupoFilmeRepo.findAll().stream()
                .map(obj -> new GrupoFilmeDTO(obj))
                .collect(Collectors.toList());
    }
    public GrupoFilme findbyId(Long id){
        Optional<GrupoFilme> obj = grupoFilmeRepo.findById(id);
        return obj.orElseThrow(() -> new EntityNotFoundException("Grupo não encontrado! Grupo: " + id));
    }
    public GrupoFilme findbynome(String nome){
        Optional<GrupoFilme> obj = grupoFilmeRepo.findBynome(nome);
        return obj.orElseThrow(() -> new EntityNotFoundException("Grupo não encontrado! Grupo: " + nome));
    }

    public GrupoFilme create (GrupoFilmeDTO dto){
        dto.setIdGrupoFilme(null);
        validaGrupoFilme(dto);
        GrupoFilme obj = new GrupoFilme(dto);
        return grupoFilmeRepo.save(obj);
    }
    public GrupoFilme update(Long id, GrupoFilmeDTO objDto){
        objDto.setIdGrupoFilme(id);
        GrupoFilme oldObj = findbyId(id);
        oldObj = new GrupoFilme(objDto);
        return grupoFilmeRepo.save(oldObj);
    }
    public void delete(Long id){
        GrupoFilme obj = findbyId(id);
        if(obj.getFilmes().size()>0){
            throw  new DataIntegrityViolationException("Grupo de filme nao pode ser deletado pois possui filmes vinculados!");
        }
    }
    private void validaGrupoFilme(GrupoFilmeDTO dto){
        Optional<GrupoFilme> obj = grupoFilmeRepo.findBynome(dto.getNome());
        if(obj.isPresent()&& obj.get().getIdGrupoFilme()!= dto.getIdGrupoFilme()){
            throw new DataIntegrityViolationException("Grupo filme já cadastrado!");
        }
        Optional<GrupoFilme> grupoFilme = grupoFilmeRepo.findById(dto.getIdGrupoFilme());
        if(!grupoFilme.isPresent()){
            throw new DataIntegrityViolationException("Grupo de Filmes - "+dto.getIdGrupoFilme()+"não esta cadastrado!");
        }
    }
}
