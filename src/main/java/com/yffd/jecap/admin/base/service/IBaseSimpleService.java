package com.yffd.jecap.admin.base.service;

import com.yffd.jecap.admin.base.entity.IBaseEntity;
import com.yffd.jecap.admin.base.page.PageData;

public interface IBaseSimpleService<E extends IBaseEntity> {

    int add(E entity);

    int updateById(E entity);

    void deleteById(String id);

    E queryById(String id);

    PageData<E> queryPage(E entity, int pageNum, int pageSize);

}
