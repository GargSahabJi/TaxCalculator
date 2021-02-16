/*
* Class name: PriceCalculationService 
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 16/Feb/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 16/Feb/2021
*
* Description: Calculate the tax price according to the item type
*/
package com.nagarro.taxcalculator.service;

import java.util.ArrayList;

import com.nagarro.taxcalculator.item.Item;

public class PriceCalculationService {

    public void gg(ArrayList<Item> itemsInfo) {
        for (Item item : itemsInfo) {
            String type = item.getItemType();
            double itemsPrice = item.getItemPrice();
            int itemsQuantity = item.getItemQuantity();
            ServiceImpl service = null;
            switch (type) {
            case "Raw":
                service = new RawItemServiceImpl();
                break;
            case "Manufactured":
                service = new ManufacturedItemServiceImpl();
                break;
            case "Imported":
                service = new ImportedItemServiceImpl();
                break;
            }
            double taxPrice = service.priceCalculation(itemsPrice, itemsQuantity);
            item.setTaxPrice(taxPrice);
        }
    }

}
