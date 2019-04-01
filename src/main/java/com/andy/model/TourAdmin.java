package com.andy.model;


import com.andy.common.Page;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Table(name = "tour_admin")//指定表名
public class TourAdmin {
	@Id//指定主键
	@KeySql(useGeneratedKeys = true)//主键自增
	private Long admin_id;
	
	private String login_name;
	
	private String admin_name;
	
	private String passwd;

	private String resource_codes;
	
	private String group_ids;

	@Transient//瞬态，不持久，该注解下的字段不回去映射数据库字段
	private String note;

}
