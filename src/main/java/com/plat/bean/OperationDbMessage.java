package com.plat.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OperationDbMessage implements Serializable{
	private static final long serialVersionUID = 4541632282397229320L;
    /**
     *  状态码 200 成功
     */
	private Integer statusCode;
	/**
	 * 信息
	 */
	private String statusMessage;
}
