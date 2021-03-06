package ua.mega.services;

import java.util.List;

import ua.mega.domain.Book;
import ua.mega.domain.Customer;
import ua.mega.domain.Order;

public class AccountsServiceMockImpl implements AccountsService
{	
	public void raiseInvoice(Book requiredBook) 
	{
		// a very basic implementation for testing
		System.out.println("Raised the invoice for " + requiredBook);
	}

	@Override
	public Customer findCustomer(String id) throws CustomerNotFoundException {
		if (id.equals("1"))
			return new Customer("Fred Jackson");
		else throw new CustomerNotFoundException();
	}

}
