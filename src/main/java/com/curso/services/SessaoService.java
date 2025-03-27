package com.curso.services;

import com.curso.domains.Cliente;
import com.curso.domains.GrupoFilme;
import com.curso.domains.Sessao;
import com.curso.domains.dtos.ClienteDTO;
import com.curso.domains.dtos.GrupoFilmeDTO;
import com.curso.domains.dtos.SessaoDTO;
import com.curso.repositories.SessaoRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessaoService  {

    @Autowired
    private SessaoRepository sessaoRepo;

    public List<SessaoDTO> findAll(){

        return sessaoRepo.findAll().stream()
                .map(obj -> new SessaoDTO(obj))
                .collect(Collectors.toList());
    }
    public Sessao findbyId(Long id){
        Optional<Sessao> obj = sessaoRepo.findById(id);
        return obj.orElse(null);
    }
    public Sessao create (SessaoDTO dto){
        dto.setIdSessao(null);
        validaSessao(dto);
        Sessao obj = new Sessao(dto);
        return sessaoRepo.save(obj);
    }
    public Sessao update(Long id, SessaoDTO objDto){
        objDto.setIdSessao(id);
        Sessao oldObj = findbyId(id);
        oldObj = new Sessao(objDto);
        return sessaoRepo.save(oldObj);
    }
    public void delete (Long id){
        Sessao obj = findbyId(id);
        sessaoRepo.deleteById(id);
    }
    private void validaSessao(SessaoDTO dto){
        Optional<Sessao> obj = sessaoRepo.findById(dto.getIdSessao());
        if(obj.isPresent()&& obj.get().getIdSessao()!= dto.getIdSessao()){
            throw new DataIntegrityViolationException("Sessao já cadastrada!");
        }
        Optional<Sessao> sessao = sessaoRepo.findById(dto.getIdSessao());
        if(!sessao.isPresent()){
            throw new DataIntegrityViolationException("Sessao - "+dto.getIdSessao()+"não esta cadastrada!");
        }

    }

}
