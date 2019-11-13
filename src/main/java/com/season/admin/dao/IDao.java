/*
 * @date 2016年12月09日 18:16
 */
package com.season.admin.dao;

import com.season.core.Page;
import com.season.orm.filter.Criteria;

import java.util.List;

/**
 * @author june
 */
public interface IDao<T>{
    /**
     * 保存pojo
     * @param t 实例
     * @return 保存后的对象,带主键
     */
    T save(T t);

    /**
     * 更新pojo
     * @param t 实例
     * @param updateColumns 要更新的列,如果不指定,更新所有列
     * @return 更新数量
     */
    int update(T t, String... updateColumns);

    /**
     * 删除pojo
     * @param t 实例,主键必须有值,否则抛出运行异常
     * @return 删除数量
     */
    int delete(T t);

    /**
     * 根据主键删除pojo
     * @param id 主键id
     * @return 删除的数量
     */
    int deleteById(Long id);

    //-------------------------START pojo对象相关操作方法,查询都以find开头--------------------------------

    /**
     * 根据一些列的值进行查询,并只返回指定的列
     * @param selectColumns 要返回的列,必须是数据库列名而非pojo的字段名
     * @param whereColumns 要查询的列,必须是数据库列名而非pojo的字段名
     * @param params 查询的列的值
     * @return 结果集
     */
    List<T> findByColumns(String[] selectColumns, String[] whereColumns, Object... params);

    /**
     * 根据一些列的值进行查询,返回所有列
     * @param whereColumns 要查询的列,必须是数据库列名而非pojo的字段名
     * @param params 查询的列的值
     * @return 结果集
     */
    List<T> findByColumns(String[] whereColumns, Object... params);

    /**
     * 根据某列进行查询
     * @param whereColumn 哪一列,必须是数据库列名而非pojo的字段名
     * @param columnValue 值
     * @return 结果集
     */
    List<T> findByColumn(String whereColumn, Object columnValue);

    /**
     * 根据主键查询对象，多主键必须都传
     * @param ids 主键
     * @return pojo
     */
    T findById(Object... ids);

    /**
     * 查询pojo的所有数据
     * @return 结果集
     */
    List<T> findAll();

    /**
     * 根据封装的检索参数进行检索
     * @param criteria 检索参数
     * @return 单表查询结果
     */
    List<T> search(Criteria criteria);

    /**
     * 根据封装的检索参数进行分页检索
     * @param criteria 检索参数
     * @param pageNo 当前页
     * @param pageSize 分页大小
     * @return page
     */
    Page<T> pageSearch(Criteria criteria, Integer pageNo, Integer pageSize);

    /**
     * 清空缓存
     * @param t 对象
     */
    void clearCache(T t);

}
