package com.example.training;

import com.example.model.util.Common;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommonTest {

    @Test
    public void checkInputCommonTest() {
        String input = "01100";
        boolean isOk = Common.checkInput(input);

        Assert.assertTrue(isOk);
    }
}
