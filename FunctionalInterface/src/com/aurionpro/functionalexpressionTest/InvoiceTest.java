
package com.aurionpro.functionalexpressionTest;

import java.util.Arrays;
import java.util.List;

import com.aurionpro.functionalexpression.Invoice;

public class InvoiceTest {
	public static void main(String[] args) {

		List<Invoice> invoices = Arrays.asList(

				new Invoice("Pen", 10, 5.0), new Invoice("Notebook", 2, 50.0), new Invoice("Pencil", 5, 10.0),
				new Invoice("Scale", 2, 10.0), new Invoice("Eraser", 3, 3.0)

		);
		
		Consumer<Invoice> i = invoice -> {
			syso
			
		}
	}

}
