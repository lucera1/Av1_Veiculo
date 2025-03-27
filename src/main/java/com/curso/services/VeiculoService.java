package com.curso.services;

import com.curso.domains.Veiculo;
import com.curso.domains.dtos.VeiculoDTO;
import com.curso.repositories.VeiculoRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.curso.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepo;

    public List<VeiculoDTO> findAll(){
        return veiculoRepo.findAll().stream().map(obj -> new VeiculoDTO(obj)).
                collect(Collectors.toList());
    }

    public Veiculo findbyId(Long id){
        Optional<Veiculo> obj = veiculoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veiculo não encontrado! Id: "+id));
    }

    public Veiculo findbyCpf(String cpf){
        Optional<Veiculo> obj = veiculoRepo.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cpf não encontrado! Cpf: "+cpf));
    }

    public Veiculo create(VeiculoDTO dto){
        dto.setId(null);
        validaCpf(dto);
        Veiculo obj = new Veiculo(dto);
        return veiculoRepo.save(obj);
    }

    public void validaCpf(VeiculoDTO dto){
        Optional<Veiculo> obj = veiculoRepo.findByCpf((dto.getCpf()));
        if(obj.isPresent() && obj.get().getId() != dto.getId()){
            throw new DataIntegrityViolationException("Cpf já cadastrado!");
        }

    }

    public Veiculo update(Long id, VeiculoDTO objDto){
        objDto.setId(id);
        Veiculo oldObj = findbyId(id);
        oldObj = new Veiculo(objDto);
        return veiculoRepo.save(oldObj);
    }

    public void delete(Long id){
        Veiculo obj = findbyId(id);
        veiculoRepo.deleteById(id);
    }

}

