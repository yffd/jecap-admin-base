package com.yffd.jecap.admin.base.service;

import com.yffd.jecap.admin.base.entity.IBaseEntity;
import com.yffd.jecap.admin.base.page.PageData;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface IBaseService<E extends IBaseEntity> {

    /** 添加 */
    int addBy(E entity);
    /** 添加-批量 */
    int addBatch(List<E> entityList);

    /** 修改 */
    int updateBy(E oldEntity, E newEntity);
    /** 修改 */
    int updateById(E entity);

    /** 删除 */
    int deleteBy(E entity);
    /** 删除 */
    int deleteById(Serializable id);
    /** 删除-批量 */
    int deleteByIds(Set<Serializable> ids);

    /** 存在 */
    boolean existBy(E entity);
    /** 存在 */
    boolean existById(Serializable id);

    /** 查询-单个 */
    E queryById(Serializable id);
    /** 查询-多个 */
    List<E> queryByIds(Set<? extends Serializable> ids);
    /** 查询-单个 */
    E queryBy(E entity);
    /** 查询-列表 */
    List<E> queryList(E entity);
    /** 查询-列表 */
    List<E> queryAll();
    /** 查询-分页 */
    PageData<E> queryPage(E entity, int pageNum, int pageSize);

}
