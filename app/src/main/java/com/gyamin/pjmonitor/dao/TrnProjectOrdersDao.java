package com.gyamin.pjmonitor.dao;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.entity.TrnProjectOrders;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import java.util.List;

/**
 */
@Dao(config = AppConfig.class)
public interface TrnProjectOrdersDao {

    /**
     * @param id
     * @return the TrnProjectOrders entity
     */
    @Select
    TrnProjectOrders selectById(Long id);

    /**
     * @param projectId
     * @return the TrnProjectOrders entity
     */
    @Select
    List<TrnProjectOrders> selectByProjectId(Long projectId);

    /**
     * @param
     * @return the TrnProjectOrders entity
     */
    @Select
    List<TrnProjectOrders> selectNotRelatedProjects();


    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TrnProjectOrders entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TrnProjectOrders entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TrnProjectOrders entity);
}
