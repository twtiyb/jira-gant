package com.example.java.gettingstarted.entity;

import lombok.Data;

/**
 * Created by chunchun.xu on 2017/12/2.
 */

@Data
public class WebResponse<T> {
	public Integer status = 0 ;
	public String msg;
	public T data;
	public Integer pagesize;
	public Integer current;
	public Integer total_items;

	public WebResponse setStatus(Integer status) {
		 this.status = status;
		 return this;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
