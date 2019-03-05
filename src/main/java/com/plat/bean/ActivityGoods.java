package com.plat.bean;

import java.util.List;

import lombok.Data;

@Data
public class ActivityGoods {
	private String activityType;
	private List<String> goodsIds;

}
