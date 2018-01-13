package com.dashboard.repository;

import java.util.List;
import java.util.stream.Collectors;

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

	public List<PointOfSale> getPosNearLocation(String latitude, String longitude, int radious) {
		String sql =  "SELECT POS_ID,POS_ACTIVE,POS_AREA,POS_OWNER_NAME,POS_OWNER_MAIL,POS_LAT,POS_LONG,POS_ADDRESS,VENDOR_ID "
					+ "FROM POS "
					+ "WHERE "
					+ "ACOS( SIN( RADIANS( POS_LAT ) ) * SIN( RADIANS( '"+latitude+"' ) ) + COS( RADIANS( POS_LAT ) ) "
					+ "* COS( RADIANS( '"+latitude+"' )) * COS( RADIANS( POS_LONG ) - RADIANS( '"+longitude+"' )) ) * 6380 < " + radious;
		
		List<Object[]> posObs = entityManager.createNativeQuery(sql).getResultList();
		List<PointOfSale> poses = posObs.stream().map(p -> new PointOfSale((int)p[0], (boolean)p[1]==true?1:0, (String)p[2], (String)p[3], (String)p[4], (String)p[5], (String)p[6], (String)p[7], (int)p[8])).collect(Collectors.toList());
		return poses;
		
	}
}
