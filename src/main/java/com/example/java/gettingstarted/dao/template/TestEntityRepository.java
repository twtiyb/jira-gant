package com.example.java.gettingstarted.dao.template;

import com.example.java.gettingstarted.entity.template.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chunchun.xu on 2017/12/2.
 */

@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, String> {

}
