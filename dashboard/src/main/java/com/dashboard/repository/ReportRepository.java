package com.dashboard.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
@Transactional
@Repository
public class ReportRepository {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	public List<Map<String, Object>> getSalesReport(Date fromDate, Date toDate) throws ParseException {
		String query = "SELECT p.pos_id,COUNT(o.order_id) "
						+ "FROM PointOfSale p,  Order o "
						+ "WHERE o.posId = p.posId "
						+ "AND o.orderDate BETWEEN :start AND :END"
						+ "AND o.GROUP BY p.posId";
		return entityManager.createQuery(query)
							.setParameter("start", fromDate)
							.setParameter("end", toDate)
							.getResultList();
	}
}