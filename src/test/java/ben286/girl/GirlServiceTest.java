package ben286.girl;

/*
Created by Ben Wen on 2019/1/30.
*/

import ben286.girl.domain.Girl;
import ben286.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(12);
        Assert.assertEquals(Integer.valueOf(21), girl.getAge());
    }
}
