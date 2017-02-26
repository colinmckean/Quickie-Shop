package com.codeclan.example.shopkeep;

/**
 * Created by user on 24/02/2017.
 */
public class Shop {

    private double totalSales;
    private double totalRefunds;
    private String shopName;

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    public void sell(Item item, Customer customer, String paymentMethod) {
        double price = item.getItemCost();
        totalSales += price;
        customer.takeFundsFromPaymentMethod(price, paymentMethod);
    }

    public void sell(Item item, Customer customer) {
        double price = item.getItemCost();
        totalSales += price;
        customer.takeFundsFromPaymentMethod(price, "Credit Card");
    }

    public void refund(Item item, Customer customer, String paymentMethod) {
        double price = item.getItemCost();
        totalRefunds += price;
        customer.refundFundToPaymentMethod(price, paymentMethod);
    }

    public String getShopName() {
        return this.shopName;
    }

    public double getSalesReport() {
        return totalSales - totalRefunds;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public double getTotalRefunds() {
        return totalRefunds;
    }

}
