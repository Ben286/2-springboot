package ben286.girl.service;

/*
Created by Ben Wen on 2019/1/29.
*/

import ben286.girl.enums.ResultEnum;
import ben286.girl.exception.GirlException;
import ben286.girl.repository.GirlRepository;
import ben286.girl.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(21);
        girlB.setCupSize("B");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) {
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if (age < 20) {
            throw new GirlException(ResultEnum.UNDER_GRADUATE);
        } else if (age < 30) {
            throw new GirlException(ResultEnum.GRADUATE_STUDENT);
        }
    }

    /**
     * 通过ID查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return girlRepository.findById(id).get();
    }
}
