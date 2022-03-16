package com.sofipa.proyecto.papeleria.models.services;

import java.util.List;
import com.sofipa.proyecto.papeleria.models.dao.IMaxMinDeStockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sofipa.proyecto.papeleria.models.entity.MaxMinDeStock;

@Service
public class MaxMinStockServiceImpl implements IMaxMinDeStockService{
	@Autowired
	private IMaxMinDeStockDao maxMinStockDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<MaxMinDeStock> findAll() {
		return (List<MaxMinDeStock>) maxMinStockDao.findAll();
	}

	@Override
	public MaxMinDeStock save(MaxMinDeStock maxMin) {
		return maxMinStockDao.save(maxMin);
	}

	@Override
	public MaxMinDeStock findById(Long id) {
		return maxMinStockDao.findById(id).orElse(null);
	}
}
