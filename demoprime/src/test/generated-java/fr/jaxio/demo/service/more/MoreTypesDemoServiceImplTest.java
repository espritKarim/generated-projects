/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/test/java/service/ServiceImplTest.e.vm.java
 */
package fr.jaxio.demo.service.more;

import static org.fest.assertions.Assertions.*;
import static com.google.common.collect.Lists.newArrayList;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Test;

import fr.jaxio.demo.domain.more.MoreTypesDemo;
import fr.jaxio.demo.service.more.MoreTypesDemoServiceImpl;
import fr.jaxio.demo.dao.more.MoreTypesDemoDao;
import fr.jaxio.demo.dao.support.SearchParameters;

/**
 * Unit test on MoreTypesDemoServiceImpl
 */
public class MoreTypesDemoServiceImplTest {

    private MoreTypesDemoServiceImpl moreTypesDemoServiceImpl;
    private MoreTypesDemoDao moreTypesDemoDao;

    @Before
    public void setUp() {
        // called before each test.
        moreTypesDemoServiceImpl = new MoreTypesDemoServiceImpl();
        moreTypesDemoDao = mock(MoreTypesDemoDao.class);
        moreTypesDemoServiceImpl.setMoreTypesDemoDao(moreTypesDemoDao);
    }

    @Test
    public void testFindUniqueOrNoneCaseNone() {
        MoreTypesDemo none = null;

        when(moreTypesDemoDao.findUniqueOrNone(any(MoreTypesDemo.class), any(SearchParameters.class))).thenReturn(none);

        MoreTypesDemo result = moreTypesDemoServiceImpl.findUniqueOrNone(new MoreTypesDemo());

        assertThat(result).isNull();
        verify(moreTypesDemoDao, times(1)).findUniqueOrNone(any(MoreTypesDemo.class), any(SearchParameters.class));
    }

    @Test
    public void testFindUniqueOrNoneCaseUnique() {
        MoreTypesDemo unique = new MoreTypesDemo();

        when(moreTypesDemoDao.findUniqueOrNone(any(MoreTypesDemo.class), any(SearchParameters.class))).thenReturn(unique);

        MoreTypesDemo result = moreTypesDemoServiceImpl.findUniqueOrNone(new MoreTypesDemo());

        assertThat(result).isNotNull();
        verify(moreTypesDemoDao, times(1)).findUniqueOrNone(any(MoreTypesDemo.class), any(SearchParameters.class));
    }

    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueOrNoneCaseMultiple() {
        when(moreTypesDemoDao.findUniqueOrNone(any(MoreTypesDemo.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        moreTypesDemoServiceImpl.findUniqueOrNone(new MoreTypesDemo());
    }

    @Test(expected = NoResultException.class)
    public void testFindUniqueCaseNone() {
        when(moreTypesDemoDao.findUnique(any(MoreTypesDemo.class), any(SearchParameters.class))).thenThrow(NoResultException.class);

        moreTypesDemoServiceImpl.findUnique(new MoreTypesDemo());
    }

    @Test
    public void testFindUniqueCaseUnique() {
        MoreTypesDemo unique = new MoreTypesDemo();

        when(moreTypesDemoDao.findUnique(any(MoreTypesDemo.class), any(SearchParameters.class))).thenReturn(unique);

        MoreTypesDemo result = moreTypesDemoServiceImpl.findUnique(new MoreTypesDemo());

        assertThat(result).isNotNull();
        verify(moreTypesDemoDao, times(1)).findUnique(any(MoreTypesDemo.class), any(SearchParameters.class));
    }

    @Test(expected = NonUniqueResultException.class)
    public void testFindUniqueCaseMultiple() {
        when(moreTypesDemoDao.findUnique(any(MoreTypesDemo.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        moreTypesDemoServiceImpl.findUnique(new MoreTypesDemo());
    }
}