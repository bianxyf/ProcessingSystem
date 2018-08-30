package com.process.model;

import java.io.Serializable;
import java.util.Optional;

public class ProductRequest implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductRequest(String type, String amount){
        this.type = type;
        setAmount(amount);
        amtDouble = Double.parseDouble(getAmount()) / 100d;
    }

	public ProductRequest(String type, String amount, int quantity){
        this.type = type;
        setAmount(amount);
        amtDouble = Double.parseDouble(getAmount()) / 100d;
        this.quantity = quantity;
    }
	
    private int quantity;
    private String type;
    private String amount;
    private double amtDouble;
    private String operation;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return Optional.ofNullable(amount).get().replace("p", "");
    }

    public void setAmount(String amount) {
        this.amount = Optional.ofNullable(amount).get().replace("p", "");
    }

    public double getAmountDouble() {
        return amtDouble;
    }

    public void setAmountDouble(double amountDouble) {
        this.amtDouble = amountDouble;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
