package com.ikeguang.monitor.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ikeguang.monitor.mysql.model.MonitorTable;
import com.ikeguang.monitor.mysql.repository.MonitorTableRepository;
import com.ikeguang.monitor.mysql.service.MonitorTableService;

/**
 * @ Author: keguang @ Date: 2019/7/25 11:21 @ version: v1.0.0 @ description:
 */
@Service
public class MonitorTableServiceImpl implements MonitorTableService {

	@Autowired
	private MonitorTableRepository monitorTableRepository;

	@Override
	public Page<MonitorTable> getMonitorTableList(int pageNum, int pageSize) {
		Sort sort = Sort.by(Direction.DESC, "id");
		Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
		return monitorTableRepository.findAll(pageable);
	}

	@Override
	public List<MonitorTable> findByStatusAndRealtime(String status, String realtime) {
		return monitorTableRepository.findByStatusAndRealtime(status, realtime);
	}

	@Override
	public MonitorTable findMonitorTableById(Long id) {
		return monitorTableRepository.findById(id).orElse(null);
	}

	@Override
	public MonitorTable findByTableName(String tableName) {
		return monitorTableRepository.findByTableName(tableName);
	}

	@Override
	public void edit(MonitorTable monitorTable) {
		monitorTableRepository.save(monitorTable);
	}

	@Override
	public void save(MonitorTable monitorTable) {
		monitorTableRepository.save(monitorTable);
	}

	@Override
	public void deleteById(long id) {
		monitorTableRepository.deleteById(id);
	}

}
