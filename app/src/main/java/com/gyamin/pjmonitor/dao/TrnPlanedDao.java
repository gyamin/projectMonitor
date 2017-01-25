package com.gyamin.pjmonitor.dao;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.entity.TrnPlaned;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao(config = AppConfig.class)
public interface TrnPlanedDao {

    /**
     * @param id
     * @return the TrnPlaned entity
     */
    @Select
    TrnPlaned selectById(Long id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TrnPlaned entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TrnPlaned entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TrnPlaned entity);
}