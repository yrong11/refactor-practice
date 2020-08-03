package com.twu.refactoring;

public class OrderReceipt {
    private Order order;
    static String HEADER = "======Printing Orders======";
    static String SALES_TAX = "Sales Tax";
    static String TOTAL_AMOUNT = "Total Amount";
	static float SALE_TAX_PRECENT = 0.1f;
    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		output.append(HEADER + "\n");
		output.append(order.toString());

		double totSalesTx = 0d;
		double totalAmount = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.toString() + "\n");
            double salesTax = lineItem.totalAmount() * SALE_TAX_PRECENT;
            totSalesTx += salesTax;
            totalAmount += lineItem.totalAmount() + salesTax;
		}

		output.append(SALES_TAX + "\t" + totSalesTx);
		output.append(TOTAL_AMOUNT + "\t" + totalAmount);
		return output.toString();
	}
}