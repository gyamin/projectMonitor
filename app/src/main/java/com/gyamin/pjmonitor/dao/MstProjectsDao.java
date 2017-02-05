package com.gyamin.pjmonitor.dao;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.entity.MstProjects;
import com.gyamin.pjmonitor.entity.MstProjectsWorkers;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import java.util.List;

/**
 */
@Dao(config = AppConfig.class)
public interface MstProjectsDao {

    /**
     * @param id
     * @return the MstProjects entity
     */
    @Select
    MstProjects selectById(Long id);

    /**
     * @param id
     * @return the MstProjects entity
     */
    @Select
    MstProjectsWorkers selectJoinedById(Long id);

    /**
     * @return the MstProjects entities
     */
    @Select
    List<MstProjectsWorkers> selectJoinedAll();

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MstProjects entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MstProjects entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MstProjects entity);
}
