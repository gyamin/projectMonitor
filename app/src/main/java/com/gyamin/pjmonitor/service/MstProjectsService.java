package com.gyamin.pjmonitor.service;

import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.dao.*;
import com.gyamin.pjmonitor.entity.MstProjects;
import com.gyamin.pjmonitor.entity.MstProjectsWorkers;
import com.gyamin.pjmonitor.entity.MstWorkers;
import com.gyamin.pjmonitor.entity.TrnProjectOrders;
import com.gyamin.pjmonitor.web.bean.SessionInfoBean;
import com.gyamin.pjmonitor.web.exception.ApplicationException;
import com.gyamin.pjmonitor.web.request.MstProjectsEditRequest;
import com.gyamin.pjmonitor.web.request.MstProjectsNewRequest;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MstProjectsService {

    /**
     * 一覧画面表示データ取得
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

    /**
     * 新規画面表示データ取得
     * @param model
     * @return
     */
    public Model getDataForNew(Model model) {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        MstWorkersDao mstWorkersDao = new MstWorkersDaoImpl();

        tm.required(() -> {
            model.addAttribute("workers", mstWorkersDao.selectAll());
        });
        return model;
    }

    /**
     * 編集画面表示データ取得
     * @return
     * @throws ApplicationException
     */
    public Model getDataForEdit(Long id, Model model) throws ApplicationException {

        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        MstProjectsDao mstProjectsDao = new MstProjectsDaoImpl();
        TrnProjectOrdersDao trnProjectOrdersDao = new TrnProjectOrdersDaoImpl();
        MstWorkersDao mstWorkersDao = new MstWorkersDaoImpl();

        tm.required(() -> {
            model.addAttribute("project", mstProjectsDao.selectStdById(id));
            model.addAttribute("projectOrders", trnProjectOrdersDao.selectByProjectId(id));
            model.addAttribute("projectNotRelatedOrders", trnProjectOrdersDao.selectNotRelatedProjects());
            model.addAttribute("workers", mstWorkersDao.selectAll());
        });

        return model;
    }

    private MstProjects packRequestToMstProject(MstProjectsNewRequest request) {
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
        return mstProjects;
    }

    /**
     * 新規作成
     * @param request
     * @return
     */
    public int createNewProject(MstProjectsNewRequest request) {
        MstProjects mstProjects = this.packRequestToMstProject(request);
        MstProjectsDao mstProjectsDao = new MstProjectsDaoImpl();

        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        int ret = tm.required(() -> {
            return mstProjectsDao.insert(mstProjects);
        });

        return ret;
    }

    /**
     * 編集
     * @param request
     * @param projectId
     */
    public void editProject(MstProjectsEditRequest request, String projectId) {
        MstProjectsNewRequest mstProjectsNewRequest = request;
        MstProjects mstProjects = this.packRequestToMstProject(mstProjectsNewRequest);
        mstProjects.setId(Integer.valueOf(projectId));      // idを設定

        MstProjectsDao mstProjectsDao = new MstProjectsDaoImpl();
        TrnProjectOrdersDao trnProjectOrdersDao = new TrnProjectOrdersDaoImpl();
        TransactionManager tm = AppConfig.singleton().getTransactionManager();

        tm.required(() -> {
            // プロジェクトマスタ更新
            mstProjectsDao.update(mstProjects);

            // プロジェクト受注トラン更新(プロジェクトに追加)
            if(request.getNotRelatedOrders() != null) {
                for(String id : request.getNotRelatedOrders()) {
                    TrnProjectOrders trnProjectOrders = trnProjectOrdersDao.selectById(Long.valueOf(id));
                    trnProjectOrders.setProjectId(Integer.valueOf(projectId));
                    trnProjectOrders.setModifiedAt(LocalDateTime.now());
                    trnProjectOrdersDao.update(trnProjectOrders);
                }
            }

            if(request.getRelatedOrders() != null) {
                // プロジェクト受注トラン更新(プロジェクトから削除)
                for(String id : request.getRelatedOrders()) {
                    TrnProjectOrders trnProjectOrders = trnProjectOrdersDao.selectById(Long.valueOf(id));
                    trnProjectOrders.setProjectId(null);
                    trnProjectOrders.setModifiedAt(LocalDateTime.now());
                    trnProjectOrdersDao.update(trnProjectOrders);
                }
            }
        });

    }

    public Model getDataForReport(String id, Model model) {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        MstProjectsDao dao = new MstProjectsDaoImpl();

        tm.required(() -> {
            model.addAttribute("report", dao.selectReportData(Long.valueOf(id)));
        });

        return model;
    }
}
