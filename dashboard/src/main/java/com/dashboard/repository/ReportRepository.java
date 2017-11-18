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
	
	public List<Object[]> getSalesReportByPos(Date fromDate, Date toDate) throws ParseException {
		String query = "SELECT p.posArea,COUNT(o.orderId) "
						+ "FROM PointOfSale p,  Order o "
						+ "WHERE o.posId = p.posId "
						+ "AND o.orderDate BETWEEN :start AND :end "
						+ "GROUP BY p.posId";
		
		return entityManager.createQuery(query)
							.setParameter("start", fromDate)
							.setParameter("end", toDate)
							.getResultList();
	}
	
	public List<Object[]> getSalesReportByProduct(Date fromDate, Date toDate) throws ParseException {
		String query = "SELECT p.productDesc,SUM(od.quantity) "
						+ "FROM Order o, OrderDetails od,  Product p "
						+ "WHERE od.productId = p.productId "
						+ "AND o.orderId = od.orderId "
						+ "AND o.orderDate BETWEEN :start AND :end "
						+ "GROUP BY p.productDesc";
		
		return entityManager.createQuery(query)
							.setParameter("start", fromDate)
							.setParameter("end", toDate)
							.getResultList();
	}
	
	public List<Object[]> getSalesSummaryReport(Date fromDate, Date toDate) throws ParseException {
		String query = "SELECT o.orderDate,COUNT(o.orderId) "
						+ "FROM Order o "
						+ "WHERE o.orderDate BETWEEN :start AND :end "
						+ "GROUP BY o.orderDate";
		
		return entityManager.createQuery(query)
							.setParameter("start", fromDate)
							.setParameter("end", toDate)
							.getResultList();
	}
	
	
}
