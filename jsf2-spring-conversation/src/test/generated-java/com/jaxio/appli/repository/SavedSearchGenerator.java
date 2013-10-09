/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/service/ModelGenerator.e.vm.java
 */
package com.jaxio.appli.repository;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.appli.domain.SavedSearch;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Named
@Singleton
public class SavedSearchGenerator {

    /**
     * Returns a new SavedSearch instance filled with random values.
     */
    public SavedSearch getSavedSearch() {
        SavedSearch savedSearch = new SavedSearch();

        // simple attributes follows
        savedSearch.setName("a");
        savedSearch.setFormClassname("a");
        savedSearch.setFormContent("dummy".getBytes());
        return savedSearch;
    }

}