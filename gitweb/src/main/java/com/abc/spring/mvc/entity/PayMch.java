package com.abc.spring.mvc.entity;

import java.io.Serializable;

public class PayMch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5022829049909824037L;

	private Integer payMchId;
	private String mchId;
	private String name;
	private String reqKey;
	private String resKey;

	public Integer getPayMchId() {
		return payMchId;
	}

	public void setPayMchId(Integer payMchId) {
		this.payMchId = payMchId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReqKey() {
		return reqKey;
	}

	public void setReqKey(String reqKey) {
		this.reqKey = reqKey;
	}

	public String getResKey() {
		return resKey;
	}

	public void setResKey(String resKey) {
		this.resKey = resKey;
	}

}
