/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/main/java/printer/Printer.e.vm.java
 */
package com.jaxio.appli.printer;

import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.appli.domain.Role;
import com.jaxio.appli.domain.Role_;
import com.jaxio.appli.printer.support.GenericPrinter;

/**
 * {@link GenericPrinter} for {@link Role} 
 *
 * @see GenericPrinter
 * @see TypeAwarePrinter
 */
@Named
@Singleton
public class RolePrinter extends GenericPrinter<Role> {
    public RolePrinter() {
        super(Role.class, Role_.roleName);
    }

    @Override
    public String print(Role role, Locale locale) {
        if (role == null) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        appendIfNotEmpty(ret, role.getRoleName());
        return ret.toString();
    }
}