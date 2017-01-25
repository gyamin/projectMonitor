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
public class TrnProjectOrdersListener implements EntityListener<TrnProjectOrders> {

    @Override
    public void preInsert(TrnProjectOrders entity, PreInsertContext<TrnProjectOrders> context) {
    }

    @Override
    public void preUpdate(TrnProjectOrders entity, PreUpdateContext<TrnProjectOrders> context) {
    }

    @Override
    public void preDelete(TrnProjectOrders entity, PreDeleteContext<TrnProjectOrders> context) {
    }

    @Override
    public void postInsert(TrnProjectOrders entity, PostInsertContext<TrnProjectOrders> context) {
    }

    @Override
    public void postUpdate(TrnProjectOrders entity, PostUpdateContext<TrnProjectOrders> context) {
    }

    @Override
    public void postDelete(TrnProjectOrders entity, PostDeleteContext<TrnProjectOrders> context) {
    }
}