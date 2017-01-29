package com.gyamin.pjmonitor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.dao.MstProjectsDao;
import com.gyamin.pjmonitor.dao.MstProjectsDaoImpl;
import com.gyamin.pjmonitor.entity.MstProjects;
import com.gyamin.pjmonitor.web.bean.SessionInfoBean;
import com.gyamin.pjmonitor.web.exception.ApplicationException;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class MstProjectsService {

    /**
     *
     * @return
     * @throws ApplicationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws JsonProcessingException
     */
    public List<MstProjects> getMstProjectsData() throws ApplicationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, JsonProcessingException {

        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        MstProjectsDao dao = new MstProjectsDaoImpl() {
            @Override
            public MstProjects selectById(Long id) {
                return null;
            }

            @Override
            public List<MstProjects> selectAll() {
                return null;
            }

            @Override
            public int insert(MstProjects entity) {
                return 0;
            }

            @Override
            public int update(MstProjects entity) {
                return 0;
            }

            @Override
            public int delete(MstProjects entity) {
                return 0;
            }
        };

        List<MstProjects> mstProjects = tm.required(() -> {
            return dao.selectAll();
        });

        return mstProjects;

    }
}
