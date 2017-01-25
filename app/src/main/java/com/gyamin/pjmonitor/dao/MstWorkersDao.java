package com.gyamin.pjmonitor.dao;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.entity.MstWorkers;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao(config = AppConfig.class)
public interface MstWorkersDao {

    /**
     * @param id
     * @return the MstWorkers entity
     */
    @Select
    MstWorkers selectById(Long id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MstWorkers entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MstWorkers entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MstWorkers entity);
}