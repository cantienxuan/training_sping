package com.example.training;

import com.example.model.repository.AreaRepository;
import com.example.model.service.AreaService;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(MockitoJUnitRunner.class)
public class AreaServiceTest {

    @MockBean
    AreaRepository areaRepository;

    @Mock
    AreaService areaService;

    @Test
    public void searchByPostCodeResponse() {
        String input = "00100";
        try {
            Mockito.when(areaService.searchByPostCodeResponse(input)).thenThrow(new NotFoundException("khong co du lieu"));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }



    }

}
