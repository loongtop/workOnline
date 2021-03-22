package com.gkhy.workonline.server.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author leo
 * @email loongtop@gmail.com
 * @date 2021-03-21 14:47:09
 */
@Data
@TableName("t_employee_ec")
public class EmployeeEcEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 员工编号
	 */
	private Integer eid;
	/**
	 * 奖罚日期
	 */
	private Date ecdate;
	/**
	 * 奖罚原因
	 */
	private String ecreason;
	/**
	 * 奖罚分
	 */
	private Integer ecpoint;
	/**
	 * 奖罚类别，0：奖，1：罚
	 */
	private Integer ectype;
	/**
	 * 备注
	 */
	private String remark;

}
