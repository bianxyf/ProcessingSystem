package com.process.util;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.process.model.ProductDetail;
import com.process.model.ProductRequest;

public class ProductOperationTest {

    private ProductDetail productDetail;
    private ProductRequest request;

    @Before
    public void setup(){
        productDetail = new ProductDetail(15, 4.5d);
        request = new ProductRequest("apple", "20p");
    }

    @After
    public void tearDown(){

    }

    @Test
    public void shoudVerifyAdjustSalesAdd_passed_1(){
        request.setOperation("add");
        ProductOperation.adjustSales(request, productDetail);
        assertEquals("7.5", Double.toString(productDetail.getAmount()));
    }
    
    @Test
    public void shoudVerifyAdjustSalesSubtract_normal_1(){
        request.setOperation("subtract");
        ProductOperation.adjustSales(request, productDetail);
        assertEquals("1.5", Double.toString(productDetail.getAmount()));
    }
    
    @Test
    public void shoudVerifyAdjustSalesSubtract_normal_2(){
        request.setOperation("subtract");
        productDetail.setAmount(1.5);
        ProductOperation.adjustSales(request, productDetail);
        assertEquals("-1.5", Double.toString(productDetail.getAmount()));
    }
    
    @Test
    public void shoudVerifyAdjustSalesMultiply_normal_1(){
        request.setOperation("multiply");
        ProductOperation.adjustSales(request, productDetail);
        assertEquals("13.5", Double.toString(productDetail.getAmount()));
    }
    
    @Test
    public void shoudVerifyAdjustSalesNoOperation_normal_1(){
        request.setOperation("other");
        ProductOperation.adjustSales(request, productDetail);
        assertEquals("4.5", Double.toString(productDetail.getAmount()));
    }
    
    @Test(expected = NullPointerException.class)
    public void shoudVerifyAdjustSales_exception_1(){
        request.setOperation("other");
        ProductOperation.adjustSales(request, null);
    }

}
