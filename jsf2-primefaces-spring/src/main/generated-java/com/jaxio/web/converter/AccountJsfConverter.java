/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/converter/JsfConverter.e.vm.java
 */
package com.jaxio.web.converter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import com.jaxio.domain.Account;
import com.jaxio.repository.AccountRepository;
import com.jaxio.web.converter.GenericJsfConverter;

/**
 * JSF Converter for {@link Account}.
 */
@Named
@Singleton
public class AccountJsfConverter extends GenericJsfConverter<Account, String> {
    @Inject
    public AccountJsfConverter(AccountRepository accountRepository) {
        super(accountRepository, Account.class, String.class);
    }
}