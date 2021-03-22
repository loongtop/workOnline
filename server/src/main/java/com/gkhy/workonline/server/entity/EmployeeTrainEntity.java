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
@TableName("t_employee_train")
public class EmployeeTrainEntity implements Serializable {
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
	 * 培训日期
	 */
	private Date traindate;
	/**
	 * 培训内容
	 */
	private String traincontent;
	/**
	 * 备注
	 */
	private String remark;

}
