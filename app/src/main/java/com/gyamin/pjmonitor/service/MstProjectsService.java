package com.gyamin.pjmonitor.service;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.dao.MstProjectsDao;
import com.gyamin.pjmonitor.dao.MstProjectsDaoImpl;
import com.gyamin.pjmonitor.entity.MstProjects;
import com.gyamin.pjmonitor.entity.MstProjectsWorkers;
import com.gyamin.pjmonitor.web.bean.SessionInfoBean;
import com.gyamin.pjmonitor.web.exception.ApplicationException;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MstProjectsService {

    /**
     *
     * @return
     * @throws ApplicationException
     */
    public List<MstProjectsWorkers> getMstProjectsData() throws ApplicationException {

        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        MstProjectsDao dao = new MstProjectsDaoImpl();

        List<MstProjectsWorkers> mstProjectsWorkers = tm.required(() -> {
            return dao.selectJoinedAll();
        });

        return mstProjectsWorkers;

    }
}
