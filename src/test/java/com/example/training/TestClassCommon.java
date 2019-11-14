package com.example.training;

import com.example.model.City;
import com.example.model.PrefectureCodeResponse;
import com.example.repository.CityRepository;
import com.example.service.CityService;
import com.example.service.impl.CityServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;


@RunWith(SpringRunner.class)
public class TestClassCommon {


    @org.springframework.boot.test.context.TestConfiguration
    public static class TestConfiguration {
        @Bean
        CityService cityService() {
            return new CityServiceImpl();
        }
    }


    @Autowired
    private CityService cityService;

    @MockBean
    CityRepository cityRepository;


    @Captor
    private ArgumentCaptor<City> cityArgumentCaptor;



    @Before
    public void setUp() {
        Mockito.when(cityRepository.findAll()).thenReturn(IntStream.range(0, 10)
                .mapToObj(i -> new City())
                .collect(Collectors.toList()));
    }

    @Test
    public void Test1() {
        Assert.assertNotEquals(10, cityService.getAll());
        Mockito.verify(cityRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testGetCity() {
        cityService.getAll();
        Mockito.verify(cityRepository).findAll((Pageable) cityArgumentCaptor.capture());
        Assert.assertThat(cityArgumentCaptor.getValue().getPrefecture(), is(notNullValue()));
    }





}
