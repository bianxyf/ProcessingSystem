package com.process.service;

import static com.process.util.ConstantsUtil.SUCCESS;
import static com.process.util.ConstantsUtil.EXCEPTION;
import static com.process.util.ConstantsUtil.APPLICATION_STOPPED;

import java.text.DecimalFormat;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.process.model.ProductDetail;
import com.process.model.ProductRequest;
import com.process.util.ProductOperation;

@Service
public class MessageProcessorServiceImpl implements MessageProcessorService {

	private DecimalFormat df = new DecimalFormat("#.00"); 
	
    @Override
    public String processProduct(Map<String, ProductDetail> productMap, int count, ProductRequest productRequest){

    	try {
    		 ProductDetail productToProcess = productMap.get(productRequest.getType());
    	        if(productToProcess == null){
    	            productMap.put(productRequest.getType(), new ProductDetail());
    	            productToProcess = productMap.get(productRequest.getType());
    	        }

    	        String amount = productRequest.getAmount().replace("p", "");
    	        double value = Double.parseDouble(amount)/100d;
    	        productRequest.setAmountDouble(value);

    	        if(!StringUtils.isEmpty(productRequest.getOperation())){
    	            ProductOperation.adjustSales(productRequest, productToProcess);
    	        }else{
    	            productToProcess.setQuantity(productToProcess.getQuantity() + productRequest.getQuantity());

    	            if(productRequest.getAmount() != null){
    	                productToProcess.setAmount(productToProcess.getAmount() + (productRequest.getAmountDouble() * productRequest.getQuantity()));
    	            }
    	        }

    	        logReport(productMap, count);

    	         if(count == 50){
    	            return APPLICATION_STOPPED;
    	        }
    	}catch(Exception e){
            return EXCEPTION;
    	}
       

        return SUCCESS;
    }


    private void logReport(Map<String, ProductDetail> productMap, int count){
        if(count % 10 == 0){
            System.out.println("Processing count: " + count);
            System.out.println("Status of Sales are:");
            productMap.forEach((type, detail) -> {
            System.out.println("Sale type: " + type);
            System.out.println("Quantity sold: " + detail.getQuantity());
            
            System.out.println("Amount sold: £" + df.format(detail.getAmount()));
            System.out.println("***********************************");
            });
        }
    }

}
