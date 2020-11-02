package com.yffd.jecap.admin.base.service;

import com.yffd.jecap.admin.base.entity.IBaseEntity;
import com.yffd.jecap.admin.base.page.PageData;
import com.yffd.jecap.admin.base.repository.IBaseRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Transactional
public abstract class AbstractBaseService<E extends IBaseEntity> implements IBaseService<E> {

    protected abstract IBaseRepository getRepo();

    @Override
    public int addBy(E entity) {
        if (null == entity) return 0;
        return this.getRepo().addBy(entity);
    }

    @Override
    public int addBatch(List<E> entityList) {
        if (CollectionUtils.isEmpty(entityList)) return 0;
        int tmp = 0;
        for (E entity : entityList) {
            tmp += this.addBy(entity);
        }
        return tmp;
    }

    @Override
    public int updateById(E entity) {
        if (null == entity) return 0;
        return this.getRepo().modifyById(entity);
    }

    @Override
    public int updateBy(E oldEntity, E newEntity) {
        if (null == oldEntity || null == newEntity) return 0;
        return this.getRepo().modifyBy(oldEntity, newEntity);
    }

    @Override
    public int deleteById(Serializable id) {
        if (null == id) return 0;
        return this.getRepo().removeById(id);
    }

    @Override
    public int deleteByIds(Set<Serializable> ids) {
        if (null == ids || ids.isEmpty()) return 0;
        return this.getRepo().removeByIds(ids);
    }

    @Override
    public int deleteBy(E entity) {
        if (null == entity) return 0;
        return this.getRepo().removeBy(entity);
    }

    @Override
    public E queryById(Serializable id) {
        return (E) this.getRepo().queryById(id);
    }

    @Override
    public E queryBy(E entity) {
        return (E) this.getRepo().queryOne(entity);
    }

    @Override
    public List<E> queryList(E entity) {
        return this.getRepo().queryList(entity);
    }

    @Override
    public List<E> queryAll() {
        return this.getRepo().queryAll();
    }

    @Override
    public PageData<E> queryPage(E entity, int pageNum, int pageSize) {
        return this.getRepo().queryPage(entity, pageNum, pageSize);
    }

}
