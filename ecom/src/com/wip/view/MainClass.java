package com.wip.view;

import java.util.Scanner;

import com.wip.controller.ProductController;
import com.wip.controller.ProductInterface;

public class MainClass {

	public static void main(String[] args) {

		System.out.println("Welcome to Ecommerce - App !!!!");
		ProductInterface pc = new ProductController();
		Scanner sc = new Scanner(System.in);
		String continueChoice=null;
		
		do {
			System.out.println("Enter your choice:");
			System.out.println("1. Add Product");
			System.out.println("2. View Product");
			System.out.println("3. Add Elec. Product");
			System.out.println("4. View Elec. Product");
			System.out.println("5. Update Product");
			System.out.println("6. Delete Product");
			System.out.println("7.Add Product via Procedure");
			 System.out.println("8. Get Product By ID");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				pc.addProduct();
				break;
			}
			case 2: {

				pc.viewProduct();
				break;
			}
			case 3: {

				pc.viewProduct();
				break;
			}
			case 4: {

				pc.viewProduct();
				break;
			}
			case 5: {

				pc.updateProduct();
				break;
			}
			case 6: {

				pc.deleteProduct();
				break;
			}
			case 7: {

				pc.insertProductUsingProcedure();
				break;
			}
			 case 8:
		            pc.getProductById(); 
		            break;
			default: {
				System.out.println("Choose the right choice ....");
			}
			}
			System.out.println("Do u wanna to continue? Y or y");
			continueChoice = sc.next();
		} while (continueChoice.equals("Y") || continueChoice.equals("y"));
		
		System.out.println("Thanks for using the system...");
		System.exit(0);
	}
}
