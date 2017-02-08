package com.gyamin.pjmonitor.service;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.dao.*;
import com.gyamin.pjmonitor.entity.MstProjects;
import com.gyamin.pjmonitor.entity.MstProjectsWorkers;
import com.gyamin.pjmonitor.entity.MstWorkers;
import com.gyamin.pjmonitor.web.bean.SessionInfoBean;
import com.gyamin.pjmonitor.web.exception.ApplicationException;
import com.gyamin.pjmonitor.web.request.MstProjectsNewRequest;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MstProjectsService {

    /**
     *
     * @return
     * @throws ApplicationException
     */
    public Model getDataForIndex(Model model) throws ApplicationException {

        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        MstProjectsDao dao = new MstProjectsDaoImpl();

        List<MstProjectsWorkers> mstProjectsWorkers = tm.required(() -> {
            return dao.selectStdAll();
        });

        model.addAttribute("projects", mstProjectsWorkers);

        return model;
    }

    public Model getDataForNew(Model model) {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        MstWorkersDao mstWorkersDao = new MstWorkersDaoImpl();

        tm.required(() -> {
            model.addAttribute("workers", mstWorkersDao.selectAll());
        });
        return model;
    }

    /**
     *
     * @return
     * @throws ApplicationException
     */
    public Model getDataForEdit(Long id, Model model) throws ApplicationException {

        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        MstProjectsDao mstProjectsDao = new MstProjectsDaoImpl();
        TrnProjectOrdersDao trnProjectOrdersDao = new TrnProjectOrdersDaoImpl();

        tm.required(() -> {
            model.addAttribute("project", mstProjectsDao.selectStdById(id));
            model.addAttribute("projectOrders", trnProjectOrdersDao.selectByProjectId(id));
            model.addAttribute("projectNotRelatedOrders", trnProjectOrdersDao.selectNotRelatedProjects());
        });

        return model;
    }


    public int createNewProject(MstProjectsNewRequest request) {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        // オブジェクトにリクエストパラメータを設定
        MstProjects mstProjects = new MstProjects();
        mstProjects.setProjectNo(request.getProjectNo());
        mstProjects.setProjectName(request.getProjectName());
        mstProjects.setSalesWorkersId(request.getSalesWorkersId());
        mstProjects.setCustomerId(request.getCustomerId());
        mstProjects.setPlWorkersId(request.getPlWorkersId());
        mstProjects.setScheduledStartDate(request.getScheduledStartDate());
        mstProjects.setScheduledEndDate(request.getScheduledEndDate());
        mstProjects.setStatus(request.getStatus());
        mstProjects.setCreatedAt(LocalDateTime.now());

        MstProjectsDao mstProjectsDao = new MstProjectsDaoImpl();

        int ret = tm.required(() -> {
            return mstProjectsDao.insert(mstProjects);
        });

        return ret;
    }
}
