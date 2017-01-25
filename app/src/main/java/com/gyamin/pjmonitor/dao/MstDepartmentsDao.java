package com.gyamin.pjmonitor.dao;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.entity.MstDepartments;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao(config = AppConfig.class)
public interface MstDepartmentsDao {

    /**
     * @param id
     * @return the MstDepartments entity
     */
    @Select
    MstDepartments selectById(Long id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MstDepartments entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MstDepartments entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MstDepartments entity);
}