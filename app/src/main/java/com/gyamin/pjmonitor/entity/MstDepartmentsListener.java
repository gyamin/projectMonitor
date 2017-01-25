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
public class MstDepartmentsListener implements EntityListener<MstDepartments> {

    @Override
    public void preInsert(MstDepartments entity, PreInsertContext<MstDepartments> context) {
    }

    @Override
    public void preUpdate(MstDepartments entity, PreUpdateContext<MstDepartments> context) {
    }

    @Override
    public void preDelete(MstDepartments entity, PreDeleteContext<MstDepartments> context) {
    }

    @Override
    public void postInsert(MstDepartments entity, PostInsertContext<MstDepartments> context) {
    }

    @Override
    public void postUpdate(MstDepartments entity, PostUpdateContext<MstDepartments> context) {
    }

    @Override
    public void postDelete(MstDepartments entity, PostDeleteContext<MstDepartments> context) {
    }
}