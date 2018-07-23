package com.example.demo.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.plugins.MockMaker;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.Bean.DB2Bean;
import com.example.demo.service.DB2Service;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DB2Controller.class, secure = false)
public class DB2ControllerTest {

	List<DB2Bean> mockList;
	DB2Bean bean1;
	DB2Bean bean2;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DB2Service db2Service;

	@Before
	public void setup() {
		bean1 = new DB2Bean();
		bean1.setNAICS_ID("441110");
		bean1.setNAICS_NM("Tobacco Farming");

		bean2 = new DB2Bean();
		bean2.setNAICS_ID("11233");
		bean2.setNAICS_NM("Turkey Production");

		mockList = new ArrayList<DB2Bean>();
	}

	@Test
	public void testGetAllNAICSNames() throws Exception {
		mockList.add(bean1);
		mockList.add(bean2);

		Mockito.when(db2Service.getAllNAICSNames()).thenReturn(mockList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getallnames").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "[{\"naics_NM\":\"Tobacco Farming\",\"naics_ID\":\"441110\"},{\"naics_NM\":\"Turkey Production\",\"naics_ID\":\"11233\"}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);

	}

	@Test
	public void testGetNAICSNameByID() throws Exception {
		mockList.add(bean1);

		Mockito.when(db2Service.getNAICSNameByID(441110)).thenReturn(mockList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getbyID/441110").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "[{\"naics_NM\":\"Tobacco Farming\",\"naics_ID\":\"441110\"}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}

	@Test
	public void testGetNAICSIDByName() throws Exception {
		mockList.add(bean2);

		Mockito.when(db2Service.getNAICSIDByName("Turkey Production")).thenReturn(mockList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getbyName/Turkey Production").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "[{\"naics_NM\":\"Turkey Production\",\"naics_ID\":\"11233\"}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}

	@Test
	public void sampleTest() {
		assertTrue(true);
	}

}
