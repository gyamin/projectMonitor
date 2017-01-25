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
public class MstPaymentsListener implements EntityListener<MstPayments> {

    @Override
    public void preInsert(MstPayments entity, PreInsertContext<MstPayments> context) {
    }

    @Override
    public void preUpdate(MstPayments entity, PreUpdateContext<MstPayments> context) {
    }

    @Override
    public void preDelete(MstPayments entity, PreDeleteContext<MstPayments> context) {
    }

    @Override
    public void postInsert(MstPayments entity, PostInsertContext<MstPayments> context) {
    }

    @Override
    public void postUpdate(MstPayments entity, PostUpdateContext<MstPayments> context) {
    }

    @Override
    public void postDelete(MstPayments entity, PostDeleteContext<MstPayments> context) {
    }
}