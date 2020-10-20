package com.yffd.jecap.admin.base.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yffd.jecap.admin.base.dao.IBaseDao;
import com.yffd.jecap.admin.base.entity.IBaseEntity;
import com.yffd.jecap.admin.base.util.EntityUtil;
import com.yffd.jecap.admin.base.page.PageData;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public abstract class AbstractMybatisBaseDao<E extends IBaseEntity> implements IBaseDao<E> {

    protected abstract BaseMapper<E> getMapper();

    protected abstract Wrapper<E> getEntityWrapper(E entity);

    @Override
    public int addBy(E entity) {
        if (null == entity) return 0;
        this.beforeInsert(entity);
        return this.getMapper().insert(entity);
    }

    @Override
    public int modifyBy(E oldEntity, E newEntity) {
        if (null == oldEntity || null == newEntity) return 0;
        Wrapper<E> queryWrapper = this.getEntityWrapper(oldEntity);
        if (queryWrapper.isEmptyOfWhere()) return 0;
        this.beforeUpdate(newEntity);
        return this.getMapper().update(newEntity, queryWrapper);
    }

    @Override
    public int modifyById(E entity) {
        if (null == entity) return 0;
        this.beforeUpdate(entity);
        return this.getMapper().updateById(entity);
    }

    @Override
    public int removeBy(E entity) {
        Wrapper<E> queryWrapper = this.getEntityWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return 0;
        this.beforeDelete(entity);
        return this.getMapper().delete(queryWrapper);
    }

    @Override
    public int removeById(Serializable id) {
        if (null == id) return 0;
        this.beforeDelete(id);
        return this.getMapper().deleteById(id);
    }

    @Override
    public int removeByIds(Set<? extends Serializable> ids) {
        if (null == ids || ids.isEmpty()) return 0;
        this.beforeDelete(ids);
        return this.getMapper().deleteBatchIds(ids);
    }

    @Override
    public E queryById(Serializable id) {
        if (null == id) return null;
        this.beforeSelect(id);
        return this.getMapper().selectById(id);
    }

    @Override
    public List<E> queryByIds(Set<? extends Serializable> ids) {
        if (null == ids) return null;
        this.beforeSelect(ids);
        return this.getMapper().selectBatchIds(ids);
    }

    @Override
    public E queryOne(E entity) {
        Wrapper<E> queryWrapper = this.getEntityWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return null;
        this.beforeSelect(entity);
        return this.getMapper().selectOne(queryWrapper);
    }

    @Override
    public List<E> queryList(E entity) {
        Wrapper<E> queryWrapper = this.getEntityWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return null;
        this.beforeSelect(entity);
        return this.getMapper().selectList(queryWrapper);
    }

    @Override
    public List<E> queryAll() {
        this.beforeSelect(null);
        return this.getMapper().selectList(null);
    }

    @Override
    public PageData<E> queryPage(E entity, int pageNum, int pageSize) {
        this.beforeSelect(entity);
        Page page = this.getMapper().selectPage(new Page(pageNum, pageSize), this.getEntityWrapper(entity));
        return new PageData(
                Long.valueOf(page.getCurrent()).intValue(),
                Long.valueOf(page.getSize()).intValue(),
                Long.valueOf(page.getTotal()).intValue(), page.getRecords()
        );
    }

    protected void beforeInsert(Object obj) {
        if (null == obj) return;
        EntityUtil.initPropsForAdd(obj);
    }

    protected void beforeUpdate(Object obj) {
        if (null == obj) return;
        EntityUtil.initPropsForUpdate(obj);
    }

    protected void beforeSelect(Object obj) {
        if (null == obj) return;
        EntityUtil.initPropsForQuery(obj);
    }

    protected void beforeDelete(Object obj) {
//        if (null == obj) return;
//        EntityUtil.initPropsForDelete(obj);
    }

}
