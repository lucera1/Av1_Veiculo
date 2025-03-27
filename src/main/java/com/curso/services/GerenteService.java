package com.curso.services;

import com.curso.domains.Gerente;
import com.curso.domains.dtos.GerenteDTO;
import com.curso.repositories.GerenteRepository;

import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;

    public List<GerenteDTO> findAll(){
        return gerenteRepository.findAll().stream()
                .map(obj -> new GerenteDTO(obj)).collect(Collectors.toList());
    }

    public Gerente findById(Long id){
        Optional<Gerente> obj = gerenteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id:"+id));
    }

    public Gerente findByCpf(String cpf){
        Optional<Gerente> obj = gerenteRepository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! CPF: "+cpf));
    }

    public Gerente findByEmail(String email){
        Optional<Gerente> obj = gerenteRepository.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! CPF: "+email));

    }

    public Gerente create (GerenteDTO objDto){
        objDto.setId(null);
        ValidaPorCPFeEmail(objDto);
        Gerente newObj = new Gerente(objDto);
        return gerenteRepository.save(newObj);
    }
    public Gerente update(Long id, GerenteDTO objDto){
        objDto.setId(id);
        Gerente oldObj = findById(id);
        ValidaPorCPFeEmail(objDto);
        oldObj = new Gerente(objDto);
        return gerenteRepository.save(oldObj);
    }

    public void delete (Long id){
        Gerente obj = findById(id);
        if (obj.getServiceOrders().size()>0){
            throw new DataIntegrityViolationException("Gerente  nao pode ser deletado pois possuiu ordens de serviço!");
        }
        gerenteRepository.deleteById(id);
    }

    private void ValidaPorCPFeEmail(GerenteDTO objDto){
        Optional<Gerente> obj = gerenteRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent()&& obj.get().getId()!= objDto.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }
        Optional<Gerente> obj2 = gerenteRepository.findByEmail(objDto.getEmail());
        if(obj2.isPresent() && obj2.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}


