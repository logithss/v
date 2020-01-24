/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

/**
 *
 * @author child
 */
public class Billing {
    public static float computeBill(float price)
    {
        return (price * 1.08f);
    }
    
    public static float computeBill(float price, int quantity)
    {
        return ((price * quantity) * 1.08f);
    }
    
    public static float computeBill(float price, int quantity, float couponValue)
    {
        return (((price * quantity) - couponValue) * 1.08f);
    }
}
