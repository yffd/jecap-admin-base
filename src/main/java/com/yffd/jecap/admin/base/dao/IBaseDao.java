package com.yffd.jecap.admin.base.dao;

import com.yffd.jecap.admin.base.entity.IBaseEntity;
import com.yffd.jecap.admin.base.page.PageData;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface IBaseDao<E extends IBaseEntity> {

    int addBy(E entity);

    int modifyBy(E oldEntity, E newEntity);

    int modifyById(E entity);

    int removeBy(E entity);

    int removeById(Serializable id);

    int removeByIds(Set<? extends Serializable> ids);

    E queryById(Serializable id);

    List<E> queryByIds(Set<? extends Serializable> ids);

    E queryOne(E entity);

    List<E> queryList(E entity);

    List<E> queryAll();

    PageData<E> queryPage(E entity, int pageNum, int pageSize);


}
