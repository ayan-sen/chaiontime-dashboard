package com.dashboard.service;

import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dashboard.model.PointOfSale;
import com.dashboard.model.Vendor;
import com.dashboard.repository.VendorRepository;

@Service
public class VendorService {

	@Resource
	private VendorRepository vendorRepository;
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long add(Vendor vendor) {
		List<PointOfSale> pointOfSales = vendor.getVendorPos();
		if(!CollectionUtils.isEmpty(pointOfSales))
			pointOfSales.forEach(v -> v.setVendorPos(vendor));
		return vendorRepository.add(vendor);
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public List<Vendor> getAll() {
		List<Vendor> vendors = vendorRepository.getAll();
		vendors.stream().forEach(v -> v.getVendorPos().removeIf(p -> p.getActive() == 0));
		return vendors;
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Vendor getById(Long id) throws ObjectNotFoundException {
		Vendor vendor = vendorRepository.getById(id);
		if(vendor == null) {
			throw new ObjectNotFoundException("Vendor is not found for id :" + id);
		}
		if(vendor != null && vendor.getActive() == 0) {
			throw new ObjectNotFoundException("Vendor is inactive for id :" + id);
		}
		vendor.getVendorPos().removeIf(v -> v.getActive() == 0);
		return vendor;
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public Long updateById(Vendor vendor) throws ObjectNotFoundException {
		List<PointOfSale> pos = vendor.getVendorPos();
		if(!CollectionUtils.isEmpty(pos))
			pos.forEach(p -> p.setVendorPos(vendor));
		return vendorRepository.updateById(vendor);
	}

	@Secured ({"ROLE_ADMIN"})
	public Long deleteById(Long id) throws ObjectNotFoundException {
		Vendor vendor = vendorRepository.getById(id);
		return vendorRepository.deleteById(vendor);
	}
	
	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public PointOfSale getPointOfSalesById(String id) throws ObjectNotFoundException {
		PointOfSale pos = vendorRepository.getPosById(id);
		if(pos == null) {
			throw new ObjectNotFoundException("PointOfSale is not found for id :" + id);
		}
		if(pos != null && pos.getActive() == 0) {
			throw new ObjectNotFoundException("PointOfSale is inactive for id :" + id);
		}
		return pos;
	}
	
	@Secured ({"ROLE_ADMIN"})
	public Long deletePointOfSaleById(Long id) {
		return vendorRepository.deletePointOfSaleById(id);
	}

	@Secured ({"ROLE_ADMIN", "ROLE_USER"})
	public List<PointOfSale> getPosNearLocation(String latitude,
			String longitude, int radious) {
		return vendorRepository.getPosNearLocation(latitude, longitude, radious);
	}
	
}
