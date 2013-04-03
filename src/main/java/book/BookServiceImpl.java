package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//@Service("bookService")
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService {

	// @Autowired
	private BookRepository bookRepository;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public List<Book> getAll() {
		return bookRepository.getAll();
	}

	public Book getById(Integer id) {
		return bookRepository.getById(id);
	}

	public Book saveOrUpdate(Book book) {
		return bookRepository.saveOrUpdate(book);
	}

	public void delete(Book book) {
		bookRepository.delete(book);
	}

	public void deleteAll() {
		for (Book book : getAll()) {
			delete(book);
		}
	}
	
	public String readLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			System.out.println("Wrong input, please try again");
			return null;
		} catch (NumberFormatException e) {
			System.out.println("Wrong input, please try again");
			return null;
		}catch (Exception e) {
			System.out.println("Something wrong Please try again");
			return null;
			}
	}

	public void insert() {
		Book newBook = getBook();	
		System.out.println("Enter the YEAR Of REALEASE");
		yN(newBook);
		
		
	}
	private Book getBook() {
		Book newBook = new Book();
		System.out.println("Enter the BOOK TITLE");
		
		newBook.setTitle(readLine());
	
		System.out.println("Enter the AUTHOR NAME");
	
		newBook.setAuthor((readLine()));
	
		System.out.println("Enter the ISBN CODE");
	
		newBook.setIsbn(readLine());
	
		System.out.println("Enter the GENRE");
	
		newBook.setGenre(readLine());
		return newBook;
	}

	public void yN(Book newBook){
		System.out.println("Do you wish to insert following book into a Library? (Y/N)");
		System.out.println(newBook.toString());
		String Yn = readLine();
		if (Yn.equalsIgnoreCase("y")){
		saveOrUpdate(newBook);}
		else if(Yn.equalsIgnoreCase("n")){
			System.out.println("The databse library was not updated");
		}else {
			System.out.println("You have made a wrong selection!");
			yN(newBook);
		}
		
	}

	public Integer count() {
		return bookRepository.count();
	}

	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	
	public void read(List<Book> booksList) {

			System.out
					.println("Enter the BOOK TITLE, AUTHOR, BOOK ID, GENRE, or YEAR OF RELEASE or use command READALL");
			boolean found = false;

			booksList = getAll();

			String search = readLine();

			for (int i = 0; i < booksList.size(); i++) {
				Book someBook = (Book) booksList.get(i);
				if (someBook.getTitle().equalsIgnoreCase(
						search)) {
					found = true;
					System.out.println(someBook.toString());
				}

				else if (someBook.getAuthor()
						.equalsIgnoreCase(search)) {
					found = true;
					System.out.println(someBook.toString());
				} else if (someBook.getGenre()
						.equalsIgnoreCase(search)) {
					found = true;
					System.out.println(someBook.toString());
				} else if (someBook.getIsbn()
						.equalsIgnoreCase(search)) {
					found = true;
					System.out.println(someBook.toString());
				}

				try {
					if (someBook.getId() == Integer
							.parseInt(search)) {
						found = true;
						System.out.println(someBook.toString());
					} else if (someBook.getYearOfRelease() == Integer
							.parseInt(search)) {
						found = true;
						System.out.println(someBook.toString());
					}
				} catch (Exception e) {
				}
			}
			if (!found) {
				System.out
						.println("there is no match for your search criteria");
			}

		}

	

	public void readAll(List<Book> booksList) {
		for (int i = 0; i < booksList.size(); i++) {
			Book someBook = ((Book) booksList.get(i));
			System.out.println(someBook.toString());
		}
	}
	
	public void save(List<Book> booksList) {
		for(int i =0; i <booksList.size(); i++){
			bookRepository.saveOrUpdate(booksList.get(i));
		}
	}
	private int getId(){
		int idToUpdate = -1;
		try{
			 idToUpdate = Integer.parseInt(readLine());
			 }
			catch(NumberFormatException e){
				System.out.println("wrong input Please insert a number");
				idToUpdate= getId();
			}
			return idToUpdate;
		}
	
	
	public void update() {
		System.out.println("Please Enter the ID of the record you wish to update or ");
		System.out.println("isert READALL to see what is th id of the rocord you wish to update");
		
		int idToUpdate = getId();
		
		Book bookToUpdate = getById(idToUpdate);
		System.out.println("CURRENT TITLE IS " + bookToUpdate.getTitle());
		System.out.println("UPDATE RECORD??? (Y/or any key to continue)");
		String choice = readLine();
		if(choice.equals("y")){
			System.out.println("ENTER NEW BOOK TITLE ");
			bookToUpdate.setTitle(readLine());
		}
		
		System.out.println("CURRENT AUTHOR IS " + bookToUpdate.getAuthor());
		System.out.println("UPDATE RECORD??? (Y/or any key to continue)");
	    choice = readLine();
		if(choice.equals("y")){
			System.out.println("ENTER NEW AUTHOR NAME ");
			bookToUpdate.setAuthor(readLine());
		}
		
		System.out.println("CURRENT ISBN IS " + bookToUpdate.getIsbn());
		System.out.println("UPDATE RECORD??? (Y/or any key to continue)");
	    choice = readLine();
		if(choice.equals("y")){
			System.out.println("ENTER NEW BOOK ISBN ");
			bookToUpdate.setIsbn(readLine());
		}
		System.out.println("CURRENT GENRE IS " + bookToUpdate.getGenre());
		System.out.println("UPDATE RECORD??? (Y/or any key to continue)");
	    choice = readLine();
		if(choice.equals("y")){
			System.out.println("ENTER NEW BOOK GENRE ");
			bookToUpdate.setGenre(readLine());
		}
		System.out.println("CURRENT YEAR OF RELEASE IS " + bookToUpdate.getYearOfRelease());
		System.out.println("UPDATE RECORD??? (Y/or any key to continue)");
	    choice = readLine();
		if(choice.equals("y")){
			System.out.println("ENTER NEW YEAR OF RELEASE HERE ");
			bookToUpdate.setYearOfRelease(Integer.parseInt(readLine()));
		}
		
		
		System.out.println(bookToUpdate.toString());
		
	}

	public void help() {
		System.out.println("INSERT" + "\t"
				+ "insert new book in the book database");
		System.out.println("READ" + "\t"
				+ "this command will display a book with given id, book title, authors name, isbn code or genre");
		System.out
				.println("READALL"
						+ "\t"
						+ "this command will display all books stored in database");
		System.out
				.println("SAVE"
						+ "\t"
						+ "this command will save the current state of the database");
		System.out
				.println("UPDATE"
						+ "\t"
						+ "this command will update current record stored in the database \n\t you need an record id to procced with the operation \n\t it is recommendet to do a READ -ALL before updating the record");

	}
}