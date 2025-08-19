package com.example.salesTax;


import com.example.salesTax.service.Shop;
import com.example.salesTax.entity.Item;
import com.example.salesTax.entity.Receipt;
import com.example.salesTax.entity.TaxPolicy;
import com.example.salesTax.util.InputParser;
import java.util.Scanner;
public class SalesTaxApplication {

		public static void main(String[] args) {
			InputParser parser = new InputParser();
			TaxPolicy taxPolicy = new TaxPolicy();
			Shop shop = new Shop();
			Scanner scanner = new Scanner(System.in);

			System.out.println("Enter items and Press Enter on an empty line to finish.");

			while (true) {
				String line = scanner.nextLine();
				if (line == null || line.trim().isEmpty()) {
					break;
				}
				try {
					Item item = parser.parse(line);
					shop.addItem(item);
				} catch (IllegalArgumentException e) {
					System.err.println("Skipping invalid line: " + e.getMessage());
				}
			}

			System.out.println("\nOUTPUT:");
			Receipt receipt = shop.generateReceipt(taxPolicy);
			receipt.printReceipt();

			scanner.close();
		}

}
