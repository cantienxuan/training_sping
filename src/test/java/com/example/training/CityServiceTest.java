package com.example.training;

import com.example.model.Entities.City;
import com.example.model.Entities.Prefecture;
import com.example.model.repository.CityRepository;
import com.example.model.service.CityService;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {

    @MockBean
    CityRepository cityRepository;


    @Mock
    private CityService cityService;

    @Test
    public void getResponseListTest() {
        List<City> prefectureList = new ArrayList<>();
        City city = new City();
        Prefecture prefecture = new Prefecture();
        prefecture.setPrefectureCode("10000");
        prefecture.setPrefectureId(10);
        prefecture.setPrefectureKana("aaa");
        prefecture.setPrefectureName("abbb");
        city.setPrefecture(prefecture);
        city.setCityCode("1111");
        prefectureList.add(city);

        Mockito.when(cityService.getResponseList(prefectureList)).thenReturn(null);
    }

    @Test
    public void searchByPrefectureCodeResponse() {
        String input = "00100";
        try {
            Mockito.when(cityService.searchByPrefectureCodeResponse(input)).thenThrow(new NotFoundException("khong co du lieu"));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }



    }


}
