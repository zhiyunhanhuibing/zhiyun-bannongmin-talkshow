package com.plat.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单管理返回实体
 * @author CR
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
public class OrderResp implements Serializable{
	private static final long serialVersionUID = 1L;
    private String orderId;
    private String orderUserWeixin;
    private String orderUserTel;
    private String orderStatus;
    private Double orderPrice;
    private Double orderPriceReceipts;
    private Date orderTime;
    private String courierNumber;
    private String courierShop;
    private Date orderEndTime;
    private String relConcession;
}
