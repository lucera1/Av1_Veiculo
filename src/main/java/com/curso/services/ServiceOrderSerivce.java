package com.curso.services;

import com.curso.domains.Atendente;
import com.curso.domains.Gerente;
import com.curso.domains.ServiceOrder;
import com.curso.domains.dtos.ServiceOrderDTO;
import com.curso.domains.enums.StatusPedido;
import com.curso.repositories.ServiceOrderRepository;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ServiceOrderSerivce {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private AtendenteService atendenteService;
    @Autowired
    private GerenteService gerenteService;



    public ServiceOrder findById(UUID id){
        Optional<ServiceOrder> obj = serviceOrderRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Chamado nao encontrado! id"+id));

    }
    public List<ServiceOrderDTO> findAll(){
        return serviceOrderRepository.findAll().stream()
                .map( obj-> new ServiceOrderDTO(obj)).collect(Collectors.toList());
    }
    private ServiceOrder newServiceOrder(ServiceOrderDTO obj){
        Atendente aten = atendenteService.findById(obj.getAtendente());
        Gerente gere = gerenteService.findById(obj.getGerente());

        ServiceOrder os = new ServiceOrder();
        if (obj.getId()!= null){
            os.setId(obj.getId());
        }
        if (obj.getStatusPedido().equals(2)){
            os.setEndDate(LocalDate.now());
        }
        os.setAtendente(aten);
        os.setGerente(gere);
        os.setStatusPedido(StatusPedido.toEnum(obj.getStatusPedido()));
        os.setTitleOS(obj.getTitleOS());
        os.setDescription(obj.getDescription());
        return os;
    }
    public ServiceOrder create(ServiceOrderDTO objDto){
        return serviceOrderRepository.save(newServiceOrder(objDto));
    }
    public ServiceOrder update (UUID id, ServiceOrderDTO objDto){
        objDto.setId(id);
        ServiceOrder oldObj = findById(id);
        oldObj = newServiceOrder(objDto);
        return serviceOrderRepository.save(oldObj);
    }
}


