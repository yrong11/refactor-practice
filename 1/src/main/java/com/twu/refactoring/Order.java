package com.twu.refactoring;

import java.util.List;

public class Order {
    String name;
    String addr;
    List<LineItem> lineItemList;

    public Order(String nm, String addr, List<LineItem> lineItemList) {
        this.name = nm;
        this.addr = addr;
        this.lineItemList = lineItemList;
    }

    public String getCustomerName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + this.addr;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }
}
