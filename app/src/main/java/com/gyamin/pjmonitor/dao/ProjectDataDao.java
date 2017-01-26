package com.gyamin.pjmonitor.dao;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.entity.TrnWorked;
import org.seasar.doma.*;

/**
 */
@Dao(config = AppConfig.class)
public interface ProjectDataDao {

    /**
     * @param id
     * @return
     */
    @Select
    TrnWorked selectByProjectId(Long id);
}