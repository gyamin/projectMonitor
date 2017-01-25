package com.gyamin.pjmonitor.dao;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.entity.TrnWorked;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao(config = AppConfig.class)
public interface TrnWorkedDao {

    /**
     * @param id
     * @return the TrnWorked entity
     */
    @Select
    TrnWorked selectById(Long id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TrnWorked entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TrnWorked entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TrnWorked entity);
}