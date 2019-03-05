package com.plat.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * 活动设置主键
 * @author CR
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActivityPriKey implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
    private String id;
    /**
     * 活动类型
     */
    private String activiType;
    /**
     * 活动名称
     */
    private String activityName;
}
