package com.dashboard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.dashboard.model.Otp;

@Transactional
@Repository
public class OtpRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public Otp generate(Otp otp) {
		String sql = "SELECT o FROM Otp o WHERE o.entity = :entity AND o.entityType = :entityType";
		
		List<Otp> otps = entityManager.createQuery(sql)
										.setParameter("entity", otp.getEntity())
										.setParameter("entityType", otp.getEntityType())
										.getResultList();
		
		if(CollectionUtils.isEmpty(otps)) {
			entityManager.persist(otp);
		} else {
			Otp existingOtp = otps.get(0);
			long otpId = existingOtp.getId();
			otp.setId(otpId);
			entityManager.merge(otp);
		}
		entityManager.flush();
		return otp;
	}
	
	public boolean verify(String entity, String entityType, int otpNumber) {
		String sql = "SELECT o FROM Otp o WHERE o.entity =:entity AND o.entityType =:entityType ORDER BY timestamp DESC";
		List<Otp> otps = entityManager.createQuery(sql)
									.setMaxResults(1)
									.setParameter("entity", entity)
									.setParameter("entityType", entityType)
									.getResultList();
		
		if(!CollectionUtils.isEmpty(otps)) {
			Otp otp = otps.get(0);
			if(otp.getOtp() == otpNumber) {
				entityManager.remove(otp);
				entityManager.flush();
				return true;
			}
		}
		return false;
	}
}
