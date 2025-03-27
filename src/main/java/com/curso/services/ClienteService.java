package com.curso.services;

import com.curso.domains.Cliente;
import com.curso.domains.Filme;
import com.curso.domains.dtos.ClienteDTO;
import com.curso.domains.dtos.FilmeDTO;
import com.curso.repositories.ClienteRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    public List<ClienteDTO> findAll(){
        return clienteRepo.findAll().stream()
                .map(obj -> new ClienteDTO(obj))
                .collect(Collectors.toList());
    }

    public Cliente findbyId(Long id){
        Optional<Cliente> obj = clienteRepo.findById(id);
        return obj.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado! Id: " + id));
    }

    public Cliente findbynome(String nome){
        Optional<Cliente> obj = clienteRepo.findBynome(nome);
        return obj.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado! Nome: " + nome));
    }
    public Cliente create (ClienteDTO dto){
        dto.setIdCliente(null);
        validaCliente(dto);
        Cliente obj = new Cliente(dto);
        return clienteRepo.save(obj);
    }
    public Cliente update(Long id, ClienteDTO objDto){
        objDto.setIdCliente(id);
        Cliente oldObj = findbyId(id);
        oldObj = new Cliente(objDto);
        return clienteRepo.save(oldObj);
    }
    public void delete(Long id){
        Cliente obj = findbyId(id);
        clienteRepo.deleteById(id);
    }

    private void validaCliente(ClienteDTO dto){
        Optional<Cliente> obj = clienteRepo.findBynome(dto.getNome());
        if(obj.isPresent()&& obj.get().getIdCliente()!= dto.getIdCliente()){
            throw new DataIntegrityViolationException("Cliente já cadastrado!");
        }
   }
}
