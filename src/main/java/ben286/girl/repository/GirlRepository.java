package ben286.girl.repository;

/*
Created by Ben Wen on 2019/1/28.
*/

import ben286.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    // 通过年龄查询
    public List<Girl> findByAge(Integer age);
}
