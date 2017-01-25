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
public class MstWorkersListener implements EntityListener<MstWorkers> {

    @Override
    public void preInsert(MstWorkers entity, PreInsertContext<MstWorkers> context) {
    }

    @Override
    public void preUpdate(MstWorkers entity, PreUpdateContext<MstWorkers> context) {
    }

    @Override
    public void preDelete(MstWorkers entity, PreDeleteContext<MstWorkers> context) {
    }

    @Override
    public void postInsert(MstWorkers entity, PostInsertContext<MstWorkers> context) {
    }

    @Override
    public void postUpdate(MstWorkers entity, PostUpdateContext<MstWorkers> context) {
    }

    @Override
    public void postDelete(MstWorkers entity, PostDeleteContext<MstWorkers> context) {
    }
}