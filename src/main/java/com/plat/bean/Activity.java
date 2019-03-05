package com.plat.bean;
    
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 活动设置请求参数
 * @author CR
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper= false)
public class Activity extends ActivityPriKey{     
	private static final long serialVersionUID = 1L;
	/**
	 * 满减活动满**
	 */
	private Double full; 
	/**
	 * 满减活动减**
	 */
	private Double reduce;
	/**
	 * ***元购活动价格
	 */
	private Double yg; 
	/**
	 * **元**件 价格
	 */
	private Integer piece; 
	/**
	 * **元**件 件数
	 */
	private Double chief; 
	/**
	 * 加价购活动  加钱数
	 */
	private Double addPrice;
	/**
	 * 限时折扣活动 折扣
	 */
	private Double discount;
	/**
	 * 限时折扣活动  开始 - 结束 时间
	 */
	private String startTime; 
	private String endTime; 
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件原名
	 */
	private String fileOriginalName;
	/**
	 * 文件地址
	 */
	private String filePath; 
}
