package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
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