package com.plat.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 小程序用户管理表查询请求返回实体
 * @author CR
 *
 */
@Data
public class UserResp implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 用户名
	 */
    private String userName;
    /**
     * 微信号
     */
    private String weixin;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * vip等级  1 VIP  0 
     */
    private String vip;
    /**
     * vip到期时间
     */
    private Date vipLimitTime;
    /**
     * 余额
     */
    private Double balance;
    /**
     * 优惠豆
     */
    private Integer concessionBean;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后修改时间
     */
    private Date updateTime;
    /**
     * 地址
     */
    private String address;
    /**
     * 图像地址
     */
    private String imgUrl;
}
