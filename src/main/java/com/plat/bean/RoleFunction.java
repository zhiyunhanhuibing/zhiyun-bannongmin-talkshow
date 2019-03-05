package com.plat.bean;

import java.io.Serializable;

import lombok.Data;

/**
 * 角色-功能关联关系
 * @author CR
 *
 */
@Data
public class RoleFunction implements Serializable{
	private static final long serialVersionUID = 1L;
    private int rid;
    private String fid;
}
