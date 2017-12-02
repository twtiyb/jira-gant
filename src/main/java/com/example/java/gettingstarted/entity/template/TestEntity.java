package com.example.java.gettingstarted.entity.template;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by chunchun.xu on 2017/12/2.
 */

@Data
@Entity
public class TestEntity {
	@Id
	String id;
	String name;
}
