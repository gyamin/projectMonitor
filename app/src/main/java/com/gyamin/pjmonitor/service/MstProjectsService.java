package com.gyamin.pjmonitor.service;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.dao.MstProjectsDao;
import com.gyamin.pjmonitor.dao.MstProjectsDaoImpl;
import com.gyamin.pjmonitor.dao.TrnProjectOrdersDao;
import com.gyamin.pjmonitor.dao.TrnProjectOrdersDaoImpl;
import com.gyamin.pjmonitor.entity.MstProjects;
import com.gyamin.pjmonitor.entity.MstProjectsWorkers;
import com.gyamin.pjmonitor.entity.TrnProjectOrders;
import com.gyamin.pjmonitor.web.bean.SessionInfoBean;
import com.gyamin.pjmonitor.web.exception.ApplicationException;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class MstProjectsService {
    private  ModelAndView modelAndView;

    public MstProjectsService(ModelAndView modelAndView) {
        this.modelAndView = modelAndView;
    }

    /**
     *
     * @return
     * @throws ApplicationException
     */
    public ModelAndView getDataForIndex() throws ApplicationException {

        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        MstProjectsDao dao = new MstProjectsDaoImpl();

        List<MstProjectsWorkers> mstProjectsWorkers = tm.required(() -> {
            return dao.selectStdAll();
        });

        this.modelAndView.addObject("projects", mstProjectsWorkers);

        return this.modelAndView;
    }

    /**
     *
     * @return
     * @throws ApplicationException
     */
    public ModelAndView getDataForEdit(Long id) throws ApplicationException {

        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        MstProjectsDao mstProjectsDao = new MstProjectsDaoImpl();
        TrnProjectOrdersDao trnProjectOrdersDao = new TrnProjectOrdersDaoImpl();

        tm.required(() -> {
            this.modelAndView.addObject("project", mstProjectsDao.selectStdById(id));
            this.modelAndView.addObject("", trnProjectOrdersDao.selectByProjectId(id));

        });

        return this.modelAndView;
    }



}
