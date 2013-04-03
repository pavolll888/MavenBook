package book;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String title;
	private String author;
	private String isbnCode;
	private String genre;
	private Integer yearOfRelease;
	//private Timestamp timestamp  = new Timestamp(new Date());
	
	public Book() {}
	
	
	public Book(String title, String author, String isbn, String genre,
			Integer yearOfRelease) {
		super();
		this.title = title;
		this.author = author;
		this.isbnCode = isbn;
		this.genre = genre;
		this.yearOfRelease = yearOfRelease;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BOOK ID" + "\t"+ "\t"+ "\t");
		builder.append(id + "\n");
		builder.append("TITLE "+ "\t"+ "\t"+ "\t");
		builder.append(title+ "\n");
		builder.append("AUTHOR"+ "\t"+ "\t"+ "\t");
		builder.append(author+ "\n");
		builder.append("ISBN CODE"+ "\t"+ "\t");
		builder.append(isbnCode+ "\n");
		builder.append("GENRE"+ "\t"+ "\t"+ "\t");
		builder.append(genre+ "\n");
		builder.append("YEAR OF RELEASE"+ "\t"+ "\t");
		builder.append(yearOfRelease+ "\n");
		return builder.toString();
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getIsbn() {
		return isbnCode;
	}
	
	public void setIsbn(String isbn) {
		this.isbnCode = isbn;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public Integer getYearOfRelease() {
		return yearOfRelease;
	}
	
	public void setYearOfRelease(Integer yearOfEdition) {
		this.yearOfRelease = yearOfEdition;
	}

	
}