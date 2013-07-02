/*
 * (c) Copyright 2005-2013 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to purchase Celerio ? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Template pack-backend-jpa:src/test/java/service/RepositoryTest.e.vm.java
 */
package com.jaxio.repository;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jaxio.dao.UserDao;
import com.jaxio.dao.support.SearchParameters;
import com.jaxio.domain.User;
import com.jaxio.repository.UserRepository;

/**
 * Unit test on UserRepository
 */
@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserRepository userRepository;

    @Test
    public void findUniqueOrNoneReturnsNull() {
        when(userDao.findUniqueOrNone(any(User.class), any(SearchParameters.class))).thenReturn(null);

        User result = userRepository.findUniqueOrNone(new User());

        assertThat(result).isNull();
        verify(userDao, times(1)).findUniqueOrNone(any(User.class), any(SearchParameters.class));
    }

    @Test
    public void findUniqueOrNoneReturnsSingleValue() {
        User unique = new User();

        when(userDao.findUniqueOrNone(any(User.class), any(SearchParameters.class))).thenReturn(unique);

        User result = userRepository.findUniqueOrNone(new User());

        assertThat(result).isNotNull().isSameAs(unique);
        verify(userDao, times(1)).findUniqueOrNone(any(User.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void findUniqueOrNoneThrowsExceptionWhenNonUniqueResults() {
        when(userDao.findUniqueOrNone(any(User.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        userRepository.findUniqueOrNone(new User());
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NoResultException.class)
    public void findUniqueThrowsExceptionWhenNoResult() {
        when(userDao.findUnique(any(User.class), any(SearchParameters.class))).thenThrow(NoResultException.class);

        userRepository.findUnique(new User());
    }

    @Test
    public void findUnique() {
        User unique = new User();

        when(userDao.findUnique(any(User.class), any(SearchParameters.class))).thenReturn(unique);

        User result = userRepository.findUnique(new User());

        assertThat(result).isNotNull();
        verify(userDao, times(1)).findUnique(any(User.class), any(SearchParameters.class));
    }

    @SuppressWarnings("unchecked")
    @Test(expected = NonUniqueResultException.class)
    public void findUniqueThrowsExeptionWhenNonUniqueResult() {
        when(userDao.findUnique(any(User.class), any(SearchParameters.class))).thenThrow(NonUniqueResultException.class);

        userRepository.findUnique(new User());
    }
}