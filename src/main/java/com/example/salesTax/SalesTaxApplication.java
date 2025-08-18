package com.example.salesTax;


import com.example.salesTax.dto.Receipt;
import com.example.salesTax.service.ReceiptService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ComponentScan
public class SalesTaxApplication implements CommandLineRunner {
	private final ReceiptService receiptService;

	public SalesTaxApplication(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(SalesTaxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<String> input1 = List.of(
				"1 book at 12.49",
				"1 music CD at 14.99",
				"1 chocolate bar at 0.85"
		);
		List<String> input2 = List.of(
				"1 imported box of chocolates at 10.00",
				"1 imported bottle of perfume at 47.50"
		);
		List<String> input3 = List.of(
				"1 imported bottle of perfume at 27.99",
				"1 bottle of perfume at 18.99",
				"1 packet of headache pills at 9.75",
				"1 box of imported chocolates at 11.25"
		);

		System.out.println("Output 1:");
		printReceipt(receiptService.getReceipt(input1));
		System.out.println();
		System.out.println("Output 2:");
		printReceipt(receiptService.getReceipt(input2));
		System.out.println();
		System.out.println("Output 3:");
		printReceipt(receiptService.getReceipt(input3));
	}
	private void printReceipt(Receipt receipt) {
		receipt.getItems().forEach(item ->
				System.out.printf("%s: %.2f%n", item.getNameOnReceipt(), item.getItemPrice())
		);
		System.out.printf("Sales Taxes: %.2f%n", receipt.getTotalTaxAmt());
		System.out.printf("Total: %.2f%n", receipt.getTotalAmount());
	}

}
