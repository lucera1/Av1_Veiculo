package com.curso.services;

import com.curso.domains.Cliente;
import com.curso.domains.Filme;
import com.curso.domains.GrupoFilme;
import com.curso.domains.dtos.ClienteDTO;
import com.curso.domains.dtos.FilmeDTO;
import com.curso.repositories.FilmeRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepo;

    public List<FilmeDTO> findAll(){

        return filmeRepo.findAll().stream()
                .map(obj -> new FilmeDTO(obj))
                .collect(Collectors.toList());
    }
    public Filme findbyId(Long id){
        Optional<Filme> obj = filmeRepo.findById(id);
        return obj.orElseThrow(() -> new EntityNotFoundException("Filme não encontrado! Filme: " + id));
    }

    public Filme findbytitulo(String titulo){
        Optional<Filme> obj = filmeRepo.findBytitulo(titulo);
        return obj.orElseThrow(() -> new EntityNotFoundException("Filme não encontrado! Filme: " + titulo)
        );
    }

        public Filme create (FilmeDTO dto){
        dto.setIdFilme(null);
        validaFilme(dto);
        Filme obj = new Filme(dto);
        return filmeRepo.save(obj);

        }
    public Filme update(Long id, FilmeDTO objDto){
        objDto.setIdFilme(id);
        Filme oldObj = findbyId(id);
        oldObj = new Filme(objDto);
        return filmeRepo.save(oldObj);
    }
    public void delete(Long id){
        Filme obj = findbyId(id);
        filmeRepo.deleteById(id);
    }
        private void validaFilme(FilmeDTO dto){
        Optional<Filme> obj = filmeRepo.findBytitulo(dto.getTitulo());
        if(obj.isPresent()&& obj.get().getIdFilme()!= dto.getIdFilme()){
            throw new DataIntegrityViolationException("Titulo já cadastrado!");
        }
        }
    }



