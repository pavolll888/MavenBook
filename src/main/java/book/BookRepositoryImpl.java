package book;


import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
 
//@Repository("bookRepository")
@Transactional(propagation = Propagation.MANDATORY, readOnly = true)
public class BookRepositoryImpl implements BookRepository {
 
    //@Autowired
    private SessionFactory sessionFactory;
 
  
    @SuppressWarnings("unchecked")
	public List<Book> getAll() {
        return getSession().createCriteria(Book.class).list();
    }
 
    public Book getById(Integer id) {
        return (Book) getSession().get(Book.class, id);
    }
 
    @Transactional(readOnly = false)
    public Book saveOrUpdate(Book book) {
        if (book.getId() != null){
            getSession().merge(book);
        } else {
            getSession().save(book);
        }
        return book;
    }
 
    @Transactional(readOnly = false)
    public void delete(Book book) {
        getSession().delete(book);
    }
 
    public Integer count() {
        return (Integer) getSession().createCriteria(Book.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }
 
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}   
    
}