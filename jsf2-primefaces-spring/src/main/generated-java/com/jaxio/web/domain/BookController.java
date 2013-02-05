/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/Controller.e.vm.java
 */
package com.jaxio.web.domain;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import com.jaxio.dao.support.SearchParameters;
import com.jaxio.domain.Book;
import com.jaxio.repository.BookRepository;
import com.jaxio.web.conversation.Conversation;
import com.jaxio.web.conversation.ConversationContext;
import com.jaxio.web.conversation.ConversationFactory;

/**
 * Stateless controller for Book conversation start. Provides also auto-complete support. 
 */
@Named
@Singleton
public class BookController implements ConversationFactory {
    public final static String editUri = "/domain/bookEdit.faces";
    public final static String selectUri = "/domain/bookSelect.faces";
    private BookRepository bookRepository;

    @Inject
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // --------------------------------
    // ConversationFactoryImpl
    // --------------------------------

    @Override
    public boolean canCreateConversation(HttpServletRequest request) {
        return selectUri.equals(request.getServletPath());
    }

    @Override
    public Conversation createConversation(HttpServletRequest request) {
        String uri = request.getServletPath();
        if (selectUri.equals(uri)) {
            Conversation conversation = Conversation.newInstance(request);
            ConversationContext<Book> ctx = newSearchContext();
            ctx.setLabelWithKey("book");
            conversation.setNextContext(ctx);
            return conversation;
        }

        throw new IllegalStateException("Unexpected conversation creation demand");
    }

    // --------------------------------
    // Autocomplete support
    // --------------------------------

    /**
     * This method is used from primefaces autocomplete components.
     */
    public List<Book> complete(String value) {
        SearchParameters sp = new SearchParameters().anywhere().searchPattern(value);
        return bookRepository.find(sp);
    }

    // --------------------------------
    // Helper 
    // --------------------------------    

    /**
     * Helper to construct a new ConversationContext for edition.
     */
    public static ConversationContext<Book> newEditContext(Book book) {
        ConversationContext<Book> ctx = new ConversationContext<Book>();
        BookEditForm bookEditForm = new BookEditForm();
        bookEditForm.setBook(book);
        ctx.addBean("bookEditForm", bookEditForm); // will be autowired by our ConversationScope...
        ctx.setViewUri(editUri);
        return ctx;
    }

    /**
     * Helper to construct a new ConversationContext for search/selection.
     */
    public static ConversationContext<Book> newSearchContext() {
        ConversationContext<Book> ctx = new ConversationContext<Book>();
        ctx.setViewUri(selectUri);
        return ctx;
    }
}