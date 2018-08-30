package com.process.service;

import com.process.model.ProductDetail;
import com.process.model.ProductRequest;

import java.util.Map;

public interface MessageProcessorService {

    String processProduct(Map<String, ProductDetail> productMap, int count, ProductRequest product);

}
