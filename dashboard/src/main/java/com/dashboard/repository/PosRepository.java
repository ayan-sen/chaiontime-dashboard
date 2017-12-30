/*package com.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dashboard.model.PointOfSale;
import com.dashboard.model.Vendor;

@Transactional
@Repository
public class PosRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public Long add(PointOfSale pointOfSale) {
		entityManager.persist(pointOfSale);
		entityManager.flush();
		return pointOfSale.getPosId();
	}

	public List<PointOfSale> getAll() {
		String sql = "SELECT p FROM PointOfSale p WHERE p.active=1";
		return entityManager.createQuery(sql, PointOfSale.class).getResultList();
	}

	public PointOfSale getById(Long id) {
		return entityManager.find(PointOfSale.class, id);
	}

	public Long updateById(PointOfSale pointOfSale) {
		entityManager.merge(pointOfSale);
		entityManager.flush();
		return pointOfSale.getPosId();
	}

	public Long deleteById(PointOfSale pointOfSale) {
		pointOfSale.setActive(0);
		entityManager.merge(pointOfSale);
		entityManager.flush();
		return pointOfSale.getPosId();
	}
	
	public Long deleteVendorById(Long id) {
		Vendor vendor = entityManager.find(Vendor.class, id);
		vendor.setActive(0);
		entityManager.merge(vendor);
		entityManager.flush();
		return vendor.getPosId();
	}

	public Vendor getVendorById(String id) {
		return entityManager.find(Vendor.class, id);
	}
}
*/