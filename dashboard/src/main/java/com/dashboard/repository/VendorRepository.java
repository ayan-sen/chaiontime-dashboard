package com.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.PointOfSale;
import com.dashboard.model.Vendor;

@Transactional
@Repository
public class VendorRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public Long add(Vendor vendor) {
		entityManager.persist(vendor);
		entityManager.flush();
		return vendor.getVendorId();
	}

	public List<Vendor> getAll() {
		String sql = "SELECT v FROM Vendor v WHERE v.active=1";
		return entityManager.createQuery(sql, Vendor.class).getResultList();
	}

	public Vendor getById(Long id) {
		return entityManager.find(Vendor.class, id);
	}

	public Long updateById(Vendor vendor) {
		entityManager.merge(vendor);
		entityManager.flush();
		return vendor.getVendorId();
	}

	public Long deleteById(Vendor vendor) {
		vendor.setActive(0);
		entityManager.merge(vendor);
		entityManager.flush();
		return vendor.getVendorId();
	}
	
	public Long deletePointOfSaleById(Long id) {
		PointOfSale pointOfSale = entityManager.find(PointOfSale.class, id);
		pointOfSale.setActive(0);
		entityManager.merge(pointOfSale);
		entityManager.flush();
		return pointOfSale.getVendorId();
	}

	public PointOfSale getPosById(String id) {
		return entityManager.find(PointOfSale.class, id);
	}
}
