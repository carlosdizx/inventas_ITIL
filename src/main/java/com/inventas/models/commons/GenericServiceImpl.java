package com.inventas.models.commons;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T,ID extends Serializable> implements GenericServiceApi<T,ID>
{
    @Override
    @Transactional
    public T save(T entity)
    {
        return getDao().save(entity);
    }

    @Override
    @Transactional
    public void delete(ID id)
    {
        getDao().deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public T findByID(ID id)
    {
        final Optional<T> optionalT =getDao().findById(id);
        return optionalT.isPresent()?optionalT.get():null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> getAll()
    {
        final List<T> list = new ArrayList<T>();
        getDao().findAll().forEach(list::add);
        return list;
    }

    public abstract CrudRepository<T,ID> getDao();
}
