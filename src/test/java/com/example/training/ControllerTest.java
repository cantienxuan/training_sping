package com.example.training;

import com.example.web.PostServiceController;
import com.example.model.service.CityService;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;


@RunWith(MockitoJUnitRunner.class)
public class ControllerTest extends AbstractControllerTest{

    @Mock
    private CityService cityService;

    @Override
    protected Object getTestedController() {
        cityService = mock(CityService.class);
        return new PostServiceController();
    }
}
