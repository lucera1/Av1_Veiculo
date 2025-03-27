package com.curso.services;

import com.curso.domains.Atendente;
import com.curso.domains.dtos.AtendenteDTO;
import com.curso.repositories.AtendenteRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtendenteService {

    @Autowired
    private AtendenteRepository atendenteRepository;

    public List<AtendenteDTO> findAll(){
        return atendenteRepository.findAll().stream()
                .map(obj -> new AtendenteDTO(obj)).collect(Collectors.toList());
    }

    public Atendente findById(Long id){
        Optional<Atendente> obj = atendenteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id:"+id));
    }

    public Atendente findByCpf(String cpf){
        Optional<Atendente> obj = atendenteRepository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! CPF: "+cpf));
    }

    public Atendente findByEmail(String email){
        Optional<Atendente> obj = atendenteRepository.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! CPF: "+email));

    }

    public Atendente create (AtendenteDTO objDto){
        objDto.setId(null);
        ValidaPorCPFeEmail(objDto);
        Atendente newObj = new Atendente(objDto);
        return atendenteRepository.save(newObj);
    }
    public Atendente update(Long id, AtendenteDTO objDto){
        objDto.setId(id);
        Atendente oldObj = findById(id);
        ValidaPorCPFeEmail(objDto);
        oldObj = new Atendente(objDto);
        return atendenteRepository.save(oldObj);
    }

    public void delete (Long id){
        Atendente obj = findById(id);
        if (obj.getServiceOrders().size()>0){
            throw new DataIntegrityViolationException("Atendente  nao pode ser deletado pois possuiu ordens de serviço!");
        }
        atendenteRepository.deleteById(id);
    }

    private void ValidaPorCPFeEmail(AtendenteDTO objDto){
        Optional<Atendente> obj = atendenteRepository.findByCpf(objDto.getCpf());
        if (obj.isPresent()&& obj.get().getId()!= objDto.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }
        Optional<Atendente> obj2 = atendenteRepository.findByEmail(objDto.getEmail());
        if(obj2.isPresent() && obj2.get().getId() != objDto.getId()){
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}
