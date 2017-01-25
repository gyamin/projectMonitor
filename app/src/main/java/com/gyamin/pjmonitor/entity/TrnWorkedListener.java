package com.gyamin.pjmonitor.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class TrnWorkedListener implements EntityListener<TrnWorked> {

    @Override
    public void preInsert(TrnWorked entity, PreInsertContext<TrnWorked> context) {
    }

    @Override
    public void preUpdate(TrnWorked entity, PreUpdateContext<TrnWorked> context) {
    }

    @Override
    public void preDelete(TrnWorked entity, PreDeleteContext<TrnWorked> context) {
    }

    @Override
    public void postInsert(TrnWorked entity, PostInsertContext<TrnWorked> context) {
    }

    @Override
    public void postUpdate(TrnWorked entity, PostUpdateContext<TrnWorked> context) {
    }

    @Override
    public void postDelete(TrnWorked entity, PostDeleteContext<TrnWorked> context) {
    }
}