package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Bean.DB2Bean;
import com.example.demo.DAO.DB2DAO;

@Service
public class DB2Service {

	@Autowired
	private DB2DAO db2dao;

	public List<DB2Bean> getAllNAICSNames() {
		return db2dao.getAllNAICSNames();

	}

	public List<DB2Bean> getNAICSNameByID(int ID) {
		return db2dao.getNAICSNameByID(ID);

	}

}
