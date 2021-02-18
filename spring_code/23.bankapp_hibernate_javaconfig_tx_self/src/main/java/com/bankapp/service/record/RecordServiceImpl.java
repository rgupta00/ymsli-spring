package com.bankapp.service.record;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.record.RecordDao;
import com.bankapp.entities.Record;

@Service
@Transactional
public class RecordServiceImpl implements RecordService {

	private RecordDao recordDao;

	@Autowired
	public RecordServiceImpl(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	@Override
	public List<Record> getAllRecords() {
		return recordDao.getAllRecords();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void addRecord(Record record) {
		recordDao.addRecord(record);
	}

}
