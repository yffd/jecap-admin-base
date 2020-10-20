package com.yffd.jecap.admin.base.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yffd.jecap.admin.base.entity.IBaseEntity;
import com.yffd.jecap.admin.base.dao.IBaseDao;
import com.yffd.jecap.admin.base.page.PageData;
import com.yffd.jecap.admin.base.util.EntityUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface MybatisplusBaseDao<E extends IBaseEntity> extends IBaseDao<E>, BaseMapper<E> {

    Wrapper<E> getWrapper(E entity);

    default BaseMapper<E> getMapper() {
        return this;
    }

    default int addBy(E entity) {
        if (null == entity) return 0;
        this.beforeInsert(entity);
        return this.insert(entity);
    }

    default int modifyBy(E oldEntity, E newEntity) {
        if (null == oldEntity || null == newEntity) return 0;
        Wrapper<E> queryWrapper = this.getWrapper(oldEntity);
        if (queryWrapper.isEmptyOfWhere()) return 0;
        this.beforeUpdate(newEntity);
        return this.update(newEntity, queryWrapper);
    }

    default int modifyById(E entity) {
        if (null == entity) return 0;
        this.beforeUpdate(entity);
        return this.getMapper().updateById(entity);
    }

    default int removeBy(E entity) {
        Wrapper<E> queryWrapper = this.getWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return 0;
        this.beforeDelete(entity);
        return this.delete(queryWrapper);
    }

    default int removeById(Serializable id) {
        if (null == id) return 0;
        this.beforeDelete(id);
        return this.getMapper().deleteById(id);
    }

    default int removeByIds(Set<? extends Serializable> ids) {
        if (null == ids || ids.isEmpty()) return 0;
        this.beforeDelete(ids);
        return this.deleteBatchIds(ids);
    }

    default E queryById(Serializable id) {
        if (null == id) return null;
        this.beforeSelect(id);
        return this.selectById(id);
    }

    default List<E> queryByIds(Set<? extends Serializable> ids) {
        if (null == ids) return null;
        this.beforeSelect(ids);
        return this.selectBatchIds(ids);
    }

    default E queryOne(E entity) {
        Wrapper<E> queryWrapper = this.getWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return null;
        this.beforeSelect(entity);
        return this.selectOne(queryWrapper);
    }

    default List<E> queryList(E entity) {
        Wrapper<E> queryWrapper = this.getWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return null;
        this.beforeSelect(entity);
        return this.selectList(queryWrapper);
    }

    default List<E> queryAll() {
        this.beforeSelect(null);
        return this.selectList(null);
    }

    default PageData<E> queryPage(E entity, int pageNum, int pageSize) {
        this.beforeSelect(entity);
        Page page = this.selectPage(new Page(pageNum, pageSize), this.getWrapper(entity));
        return new PageData(
                Long.valueOf(page.getCurrent()).intValue(),
                Long.valueOf(page.getSize()).intValue(),
                Long.valueOf(page.getTotal()).intValue(), page.getRecords()
        );
    }

    default void beforeInsert(Object obj) {
        if (null == obj) return;
        EntityUtil.initPropsForAdd(obj);
    }

    default void beforeUpdate(Object obj) {
        if (null == obj) return;
        EntityUtil.initPropsForUpdate(obj);
    }

    default void beforeSelect(Object obj) {
        if (null == obj) return;
        EntityUtil.initPropsForQuery(obj);
    }

    default void beforeDelete(Object obj) {
//        if (null == obj) return;
//        EntityUtil.initPropsForDelete(obj);
    }
}
