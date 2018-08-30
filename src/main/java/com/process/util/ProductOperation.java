package com.process.util;

import com.process.model.ProductDetail;
import com.process.model.ProductRequest;

public class ProductOperation {

    public static void adjustSales(ProductRequest request, ProductDetail product){
        double newAmount = request.getAmountDouble() * product.getQuantity();
        switch(request.getOperation().toUpperCase()){
            case "ADD" :        product.setAmount(product.getAmount() + newAmount);
                                break;
            case "SUBTRACT" :   product.setAmount(product.getAmount() - newAmount);
                                break;
	        case "MULTIPLY" :   product.setAmount(product.getAmount() * newAmount);
                                break;
            default :           break;
        }

    }
}
