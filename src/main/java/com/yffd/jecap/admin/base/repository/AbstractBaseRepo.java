package com.yffd.jecap.admin.base.repository;

import com.yffd.jecap.admin.base.dao.IBaseDao;
import com.yffd.jecap.admin.base.entity.IBaseEntity;
import com.yffd.jecap.admin.base.page.PageData;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class AbstractBaseRepo<E extends IBaseEntity> implements IBaseRepository<E> {

    protected abstract IBaseDao<E> getDao();

    @Override
    public int addBy(E entity) {
        if (null == entity) return 0;
        return this.getDao().addBy(entity);
    }

    @Override
    public int modifyBy(E oldEntity, E newEntity) {
        if (null == oldEntity || null == newEntity) return 0;
        return this.getDao().modifyBy(oldEntity, newEntity);
    }

    @Override
    public int modifyById(E entity) {
        if (null == entity) return 0;
        return this.getDao().modifyById(entity);
    }

    @Override
    public int removeBy(E entity) {
        if (null == entity) return 0;
        return this.getDao().removeBy(entity);
    }

    @Override
    public int removeById(Serializable id) {
        if (null == id) return 0;
        return this.getDao().removeById(id);
    }

    @Override
    public int removeByIds(Set<? extends Serializable> ids) {
        if (null == ids || ids.size() == 0) return 0;
        return this.getDao().removeByIds(ids);
    }

    @Override
    public E queryOne(E entity) {
        if (null == entity) return null;
        return this.getDao().queryOne(entity);
    }

    @Override
    public E queryById(Serializable id) {
        if (null == id) return null;
        return this.getDao().queryById(id);
    }

    @Override
    public List<E> queryList(E entity) {
        if (null == entity) return Collections.emptyList();
        return this.getDao().queryList(entity);
    }

    @Override
    public List<E> queryAll() {
        return this.getDao().queryAll();
    }

    @Override
    public PageData<E> queryPage(E entity, int pageNum, int pageSize) {
        return this.getDao().queryPage(entity, pageNum, pageSize);
    }

}
