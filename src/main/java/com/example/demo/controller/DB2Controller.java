package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.DB2Bean;
import com.example.demo.service.DB2Service;

@CrossOrigin(maxAge=3600)
@RestController
public class DB2Controller {

	@Autowired
	private DB2Service db2Service;

	@RequestMapping(value = "/getallnames", method = RequestMethod.GET)
	public ResponseEntity<List<DB2Bean>> getAllNAICSNames() {
		return new ResponseEntity<List<DB2Bean>>(db2Service.getAllNAICSNames(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getbyID/{ID}",method = RequestMethod.GET)
	public ResponseEntity<List<DB2Bean>> getNAICSNameByID(@PathVariable("ID") int ID)  {
		return new ResponseEntity<List<DB2Bean>>(db2Service.getNAICSNameByID(ID),HttpStatus.OK);

	}
	
	@RequestMapping(value = "/getbyName/{Name}",method = RequestMethod.GET)
	public ResponseEntity<List<DB2Bean>> getNAICSIDByName(@PathVariable("Name") String Name)  {
		return new ResponseEntity<List<DB2Bean>>(db2Service.getNAICSIDByName(Name),HttpStatus.OK);

	}

}