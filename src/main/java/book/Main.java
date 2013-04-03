package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

public class Main {
	static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"spring.xml");
	static BookService service = (BookService) ctx.getBean("bookService");
	static List<Book> booksList;
	public static void main(String... args) {

		// Spring class calls spring configuration file
		// <context:annotation-config/> was declared to look for annotation
		// config
		
		// service was made and found by the annotation bookService
		// @Service("bookService")/BookServiceImpl
		
		
		

		Book firstBook = new Book("Head First Java", "Kathy Sierra",
				"978-0-596-00465-1", "Java", 2003);
		Book secondBook = new Book("Algorithms in a Nutshell",
				"Stanley Selkow", "978-0-596-51624-6", "Algorithms", 2008);
		Book thirdBook = new Book("Android Cookbook", "Ian F. Darwin",
				"978-1-4493-8841-6", "Cook Book", 2012);
		
		service.saveOrUpdate(firstBook);
		service.saveOrUpdate(secondBook);
		service.saveOrUpdate(thirdBook);
		booksList = service.getAll();
		

		boolean exit = false;
		while (!exit) {
			System.out.println();
			System.out.println("Enter command:");
			
				String command = service.readLine();

				if (command.equalsIgnoreCase("help")) {
					service.help();
					
				}
				if (command.equalsIgnoreCase("insert")) {
					service.insert();

				}
				if (command.equalsIgnoreCase("read")) {
					service.read(booksList);
								
				}
				if (command.equalsIgnoreCase("save")) {
					service.save(booksList);
				}
				
				if (command.equalsIgnoreCase("readall")) {
					service.readAll(booksList);
					
				}	
				if (command.equalsIgnoreCase("update")) {
					service.update();					
				}
				if (command.equalsIgnoreCase("exit")) {
					System.exit(0);
				}

			
		}

		service.getAll().toString();
	}
}