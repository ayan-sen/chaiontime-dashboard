/*package com.dashboard.service;

import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dashboard.model.PointOfSale;
import com.dashboard.model.Vendor;
import com.dashboard.repository.PosRepository;

@Service
public class PosService {

	@Resource
	private PosRepository posRepository;
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long add(PointOfSale pointOfSale) {
		List<Vendor> vendors = pointOfSale.getVendors();
		if(!CollectionUtils.isEmpty(vendors))
			vendors.forEach(v -> v.setPosVendor(pointOfSale));
		return posRepository.add(pointOfSale);
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public List<PointOfSale> getAll() {
		List<PointOfSale> poses = posRepository.getAll();
		poses.stream().forEach(p -> p.getVendors().removeIf(v -> v.getActive() == 0));
		return poses;
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public PointOfSale getById(Long id) throws ObjectNotFoundException {
		PointOfSale pos = posRepository.getById(id);
		if(pos == null) {
			throw new ObjectNotFoundException("PointOfSale is not found for id :" + id);
		}
		if(pos != null && pos.getActive() == 0) {
			throw new ObjectNotFoundException("POS is inactive for id :" + id);
		}
		pos.getVendors().removeIf(v -> v.getActive() == 0);
		return pos;
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long updateById(PointOfSale pointOfSale) throws ObjectNotFoundException {
		List<Vendor> vendors = pointOfSale.getVendors();
		if(!CollectionUtils.isEmpty(vendors))
			vendors.forEach(v -> v.setPosVendor(pointOfSale));
		return posRepository.updateById(pointOfSale);
	}

	@Secured ({"ROLE_ADMIN"})
	public Long deleteById(Long id) throws ObjectNotFoundException {
		PointOfSale pos = posRepository.getById(id);
		return posRepository.deleteById(pos);
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Vendor getVendorById(String id) throws ObjectNotFoundException {
		Vendor vendor = posRepository.getVendorById(id);
		if(vendor == null) {
			throw new ObjectNotFoundException("Vendor is not found for id :" + id);
		}
		if(vendor != null && vendor.getActive() == 0) {
			throw new ObjectNotFoundException("Vendor is inactive for id :" + id);
		}
		return vendor;
	}
	
	@Secured ({"ROLE_ADMIN"})
	public Long deleteVendorById(Long id) {
		return posRepository.deleteVendorById(id);
	}
	
}
*/