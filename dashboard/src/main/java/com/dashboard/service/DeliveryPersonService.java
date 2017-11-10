package com.dashboard.service;

import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.dashboard.model.DeliveryPerson;
import com.dashboard.repository.DeliveryPersonRepository;

@Service
public class DeliveryPersonService {

	@Resource
	private DeliveryPersonRepository deliveryPersonRepository;
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long add(DeliveryPerson deliveryPerson) {
		return deliveryPersonRepository.add(deliveryPerson);
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public List<DeliveryPerson> getAll() {
		List<DeliveryPerson> deliveryPersons = deliveryPersonRepository.getAll();
		return deliveryPersons;
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public DeliveryPerson getById(Long id) throws ObjectNotFoundException {
		DeliveryPerson deliveryPerson = deliveryPersonRepository.getById(id);
		if(deliveryPerson == null) {
			throw new ObjectNotFoundException("DeliveryPerson is not found for id :" + id);
		}
		if(deliveryPerson != null && deliveryPerson.getActive() == 0) {
			throw new ObjectNotFoundException("DeliveryPerson is inactive for id :" + id);
		}
		return deliveryPerson;
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long updateById(DeliveryPerson deliveryPerson) throws ObjectNotFoundException {
		return deliveryPersonRepository.updateById(deliveryPerson);
	}

	@Secured ({"ROLE_ADMIN"})
	public Long deleteById(Long id) throws ObjectNotFoundException {
		DeliveryPerson pos = deliveryPersonRepository.getById(id);
		return deliveryPersonRepository.deleteById(pos);
	}
}
