package com.abc.spring.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.abc.spring.mvc.entity.PayMch;

public interface PayMchDao {

	List<PayMch> queryAll(@Param("offset") int offset, @Param("limit") int limit);

	PayMch queryById(@Param("id") Integer id);
}
