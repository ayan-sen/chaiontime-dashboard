package com.dashboard.service;

import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.dashboard.model.PointOfSale;
import com.dashboard.repository.PosRepository;

@Service
public class PosService {

	@Resource
	private PosRepository posRepository;
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long add(PointOfSale pointOfSale) {
		return posRepository.add(pointOfSale);
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public List<PointOfSale> getAll() {
		List<PointOfSale> poses = posRepository.getAll();
		return poses;
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public PointOfSale getById(Long id) throws ObjectNotFoundException {
		PointOfSale pos = posRepository.getById(id);
		if(pos == null) {
			throw new ObjectNotFoundException("PointOfSale is not found for id :" + id);
		}
		return pos;
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long updateById(PointOfSale pointOfSale) throws ObjectNotFoundException {
		
		return posRepository.updateById(pointOfSale);
	}

	@Secured ({"ROLE_ADMIN"})
	public Long deleteById(Long id) throws ObjectNotFoundException {
		PointOfSale pos = posRepository.getById(id);
		return posRepository.deleteById(pos);
	}
}
