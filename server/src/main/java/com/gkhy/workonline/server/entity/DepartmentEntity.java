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
@TableName("t_department")
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 父id
	 */
	private Integer parentid;
	/**
	 * 路径
	 */
	private String deppath;
	/**
	 * 是否启用
	 */
	private Integer enabled;
	/**
	 * 是否上级
	 */
	private Integer isparent;

}
