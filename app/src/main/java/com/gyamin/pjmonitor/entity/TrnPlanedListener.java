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
public class TrnPlanedListener implements EntityListener<TrnPlaned> {

    @Override
    public void preInsert(TrnPlaned entity, PreInsertContext<TrnPlaned> context) {
    }

    @Override
    public void preUpdate(TrnPlaned entity, PreUpdateContext<TrnPlaned> context) {
    }

    @Override
    public void preDelete(TrnPlaned entity, PreDeleteContext<TrnPlaned> context) {
    }

    @Override
    public void postInsert(TrnPlaned entity, PostInsertContext<TrnPlaned> context) {
    }

    @Override
    public void postUpdate(TrnPlaned entity, PostUpdateContext<TrnPlaned> context) {
    }

    @Override
    public void postDelete(TrnPlaned entity, PostDeleteContext<TrnPlaned> context) {
    }
}