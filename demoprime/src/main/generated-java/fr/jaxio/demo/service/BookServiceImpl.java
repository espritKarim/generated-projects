/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/service/ServiceImpl.e.vm.java
 */
package fr.jaxio.demo.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import javax.inject.Named;
import javax.inject.Singleton;
import org.springframework.transaction.annotation.Transactional;

import fr.jaxio.demo.dao.support.GenericDao;
import fr.jaxio.demo.service.support.GenericEntityServiceImpl;
import fr.jaxio.demo.domain.Book;
import fr.jaxio.demo.dao.BookDao;

/**
 * Default implementation of the {@link BookService} interface.
 * Note: you may use multiple DAO from this layer.
 * @see BookService
 */
@Named("bookService")
@Singleton
public class BookServiceImpl extends GenericEntityServiceImpl<Book, Integer> implements BookService {

    private static final Logger log = Logger.getLogger(BookServiceImpl.class);

    protected BookDao bookDao;

    @Inject
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * Dao getter used by the {@link GenericEntityServiceImpl}.
     */
    @Override
    public GenericDao<Book, Integer> getDao() {
        return bookDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book getNew() {
        return new Book();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Book getNewWithDefaults() {
        Book result = getNew();
        result.initDefaultValues();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(Book book) {
        if (book == null) {
            if (log.isDebugEnabled()) {
                log.debug("Skipping deletion for null model!");
            }

            return;
        }

        // remove the reference from the associated account
        if (book.getAccount() != null) {
            book.getAccount().removeBook(book);
        }

        super.delete(book);
    }
}