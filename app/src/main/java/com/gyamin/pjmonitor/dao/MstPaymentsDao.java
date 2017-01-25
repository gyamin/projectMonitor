package com.gyamin.pjmonitor.dao;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.entity.MstPayments;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao(config = AppConfig.class)
public interface MstPaymentsDao {

    /**
     * @param id
     * @return the MstPayments entity
     */
    @Select
    MstPayments selectById(Long id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MstPayments entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MstPayments entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MstPayments entity);
}