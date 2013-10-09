/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/service/RepositoryIT.e.vm.java
 */
package com.jaxio.appli.repository;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jaxio.appli.domain.SavedSearch;

/**
 * Integration test on SavedSearchRepository
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class SavedSearchRepositoryIT {
    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(SavedSearchRepositoryIT.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private SavedSearchRepository savedSearchRepository;

    @Inject
    private SavedSearchGenerator savedSearchGenerator;

    @Test
    @Rollback
    public void saveAndGet() {
        SavedSearch savedSearch = savedSearchGenerator.getSavedSearch();

        // add it to a Set before saving (force equals/hashcode)
        Set<SavedSearch> set = newHashSet(savedSearch, savedSearch);
        assertThat(set).hasSize(1);

        savedSearchRepository.save(savedSearch);
        entityManager.flush();

        // reload it from cache and check equality
        SavedSearch model = new SavedSearch();
        model.setId(savedSearch.getId());
        assertThat(savedSearch).isEqualTo(savedSearchRepository.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(savedSearch.getId()).isEqualTo(savedSearchRepository.get(model).getId());

        // but since you do not use a business key, equality is lost.
        assertThat(savedSearch).isNotEqualTo(savedSearchRepository.get(model));
    }
}