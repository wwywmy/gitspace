package com.abc.spring.mvc.service;

import java.util.List;

import com.abc.spring.mvc.entity.PayMch;

public interface PayMchService {
	List<PayMch> getList();

	PayMch getPayMchById(Integer id);
}
