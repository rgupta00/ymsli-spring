package com.bankapp.dao.record;
import java.util.*;

import com.bankapp.entities.Record;
public interface RecordDao {
	public List<Record> getAllRecords();
	public void addRecord(Record record);
}
