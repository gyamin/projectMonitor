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
public class MstProjectsListener implements EntityListener<MstProjects> {

    @Override
    public void preInsert(MstProjects entity, PreInsertContext<MstProjects> context) {
    }

    @Override
    public void preUpdate(MstProjects entity, PreUpdateContext<MstProjects> context) {
    }

    @Override
    public void preDelete(MstProjects entity, PreDeleteContext<MstProjects> context) {
    }

    @Override
    public void postInsert(MstProjects entity, PostInsertContext<MstProjects> context) {
    }

    @Override
    public void postUpdate(MstProjects entity, PostUpdateContext<MstProjects> context) {
    }

    @Override
    public void postDelete(MstProjects entity, PostDeleteContext<MstProjects> context) {
    }
}