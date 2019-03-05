package com.plat.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 订单管理实体
 * @author CR
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
public class OrderReq extends PageReq{
	private static final long serialVersionUID = 1L;
    private String orderId;
    private String orderUserWeixin;
    private String orderUserTel;
    private String orderStatus;
    private String orderStartTime;
    private String orderEndTime;
    private String orderEndStartTime;
    private String orderEndEndTime;
}
