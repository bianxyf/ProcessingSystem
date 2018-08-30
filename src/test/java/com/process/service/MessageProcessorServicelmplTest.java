package com.process.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.process.model.ProductDetail;
import com.process.model.ProductRequest;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class )
public class MessageProcessorServicelmplTest {

	@Autowired
	MessageProcessorServiceImpl messageProcessorServicelmpl;
	
	private Map<String, ProductDetail> productMap;
	private ProductRequest productRequest;
	
	@Before
	public void setup() {
		productMap = new HashMap<String, ProductDetail>();
		productRequest = new ProductRequest("apple", "20p", 10);
	}
	
	@After
	public void teardown() {
		
	}
	
	@Test
	public void processProduct1stProductToProcess_normal_1() {
		messageProcessorServicelmpl.processProduct(productMap, 1, productRequest);
		assertNotNull(productMap);
		ProductDetail detail = productMap.get("apple");
		assertNotNull(detail);
		assertEquals("2.0", String.valueOf(detail.getAmount()));
		assertEquals(10, detail.getQuantity());
	}
	
	@Test
	public void processProduct10thProductToProcess_normal_1() {
		productMap.put("apple", new ProductDetail(150, 225.0d));
		messageProcessorServicelmpl.processProduct(productMap, 10, productRequest);
		assertNotNull(productMap);
		ProductDetail detail = productMap.get("apple");
		assertNotNull(detail);
		assertEquals("227.0", String.valueOf(detail.getAmount()));
		assertEquals(160, detail.getQuantity());
	}
	
	@Test
	public void processProduct20thProductToProcess_normal_1() {
		productMap.put("apple", new ProductDetail(150, 350.0d));
		messageProcessorServicelmpl.processProduct(productMap, 20, productRequest);
		assertNotNull(productMap);
		ProductDetail detail = productMap.get("apple");
		assertNotNull(detail);
		assertEquals("352.0", String.valueOf(detail.getAmount()));
		assertEquals(160, detail.getQuantity());
	}
	
	@Test
	public void processProduct50thProductToProcess_normal_1() {
		productMap.put("apple", new ProductDetail(240, 450.0d));
		messageProcessorServicelmpl.processProduct(productMap, 50, productRequest);
		assertNotNull(productMap);
		ProductDetail detail = productMap.get("apple");
		assertNotNull(detail);
		assertEquals("452.0", String.valueOf(detail.getAmount()));
		assertEquals(250, detail.getQuantity());
	}

}
