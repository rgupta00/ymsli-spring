package com.bankapp.dao.record;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.Record;
@Repository
public class RecordDaoImpl implements RecordDao {

	private SessionFactory sessionFactory;

	@Autowired
	public RecordDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Record> getAllRecords() {
		return getSession().createQuery("select r from Record r").getResultList();
	}

	@Override
	public void addRecord(Record record) {
		getSession().save(record);
	}

}
