package ben286.girl.controller;

/*
Created by Ben Wen on 2019/1/28.
*/

import ben286.girl.aspect.HttpAspect;
import ben286.girl.domain.Result;
import ben286.girl.exception.GirlException;
import ben286.girl.repository.GirlRepository;
import ben286.girl.service.GirlService;
import ben286.girl.domain.Girl;
import ben286.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping("/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        // getOne()方法返回的是引用，老版本findOne()返回的是实体，这是新版本的查询方式
        return girlRepository.findById(id).get();
    }

    @PutMapping("/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);

        return girlRepository.save(girl);
    }

    @DeleteMapping("/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/girls/two")
    public void girlInsertTwo() {
        girlService.insertTwo();
    }

    @GetMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) {
        girlService.getAge(id);
    }// 抛出异常后切面方法不执行?
}
