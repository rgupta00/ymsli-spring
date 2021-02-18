package com.bankapp.service.record;

import java.util.List;

import com.bankapp.entities.Record;

public interface RecordService {
	public List<Record> getAllRecords();
	public void addRecord(Record record);
}
