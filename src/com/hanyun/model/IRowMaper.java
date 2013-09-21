package com.hanyun.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据装载器，将ResultSet填写各模型的属性
 * @author IntSilence
 *
 * @param <T>
 */
public interface IRowMaper<T> {
	
	/**
	 * 将当前行装载到对象中
	 * 
	 * @param rs 结果集
	 * @param index 行数
	 * @return 装载完毕的对象
	 */
	T mapRow(ResultSet rs, int index) throws SQLException;

}
