/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/domain/SearchForm.e.vm.java
 */
package com.jaxio.web.domain;

import static com.jaxio.dao.support.EntitySelector.newEntitySelector;
import static com.jaxio.domain.Document_.account;
import static com.jaxio.domain.Document_.accountId;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import com.jaxio.dao.support.EntitySelector;
import com.jaxio.dao.support.SearchParameters;
import com.jaxio.domain.Account;
import com.jaxio.domain.Document;
import com.jaxio.web.domain.support.GenericSearchForm;

/**
 * Bean used to back the search page.
 * It exposes a {@link Document} instance so it can be used in search by Example query.
 */
@Named
@Scope("conversation")
public class DocumentSearchForm extends GenericSearchForm<Document, DocumentSearchForm> {
    private static final long serialVersionUID = 1L;

    private Document document = new Document();
    private EntitySelector<Document, Account, String> accountSelector = newEntitySelector(accountId);

    public Document getDocument() {
        return document;
    }

    @Override
    protected Document getEntity() {
        return document;
    }

    // Selectors for x-to-one associations
    public EntitySelector<Document, Account, String> getAccountSelector() {
        return accountSelector;
    }

    public SearchParameters toSearchParameters() {
        return new SearchParameters() //
                .anywhere() //
                .addLeftJoinAttribute(account) //
                .entitySelector(accountSelector) //
        ;
    }

    @Override
    public DocumentSearchForm newInstance() {
        return new DocumentSearchForm();
    }

    @Override
    public void resetWithOther(DocumentSearchForm other) {
        this.document = other.getDocument();
        this.accountSelector = other.getAccountSelector();
    }
}