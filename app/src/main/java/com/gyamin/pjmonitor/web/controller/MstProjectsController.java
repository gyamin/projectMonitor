package com.gyamin.pjmonitor.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyamin.pjmonitor.AppConfig;
import com.gyamin.pjmonitor.dao.MstProjectsDao;
import com.gyamin.pjmonitor.dao.MstProjectsDaoImpl;
import com.gyamin.pjmonitor.entity.MstProjects;
import com.gyamin.pjmonitor.entity.MstProjectsWorkers;
import com.gyamin.pjmonitor.service.MstProjectsService;
import com.gyamin.pjmonitor.web.exception.ApplicationException;
import org.seasar.doma.jdbc.tx.TransactionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MstProjectsController {

    /**
     * 処理
     * @return
     */
    @RequestMapping(value = "/mst_projects", method = GET)
    public Object index(@RequestParam(required = false) String projectNo)
            throws ApplicationException, IllegalAccessException, NoSuchMethodException {

        // プロジェクトデータ取得処理を行う
        MstProjectsService service = new MstProjectsService();
        List<MstProjectsWorkers> mstProjectsList = service.getMstProjectsData();

        ModelAndView model = new ModelAndView("mst_projects/index");
        model.addObject("projects", mstProjectsList);

        return model;
    }

    /**
     * 編集画面表示
     * @return
     */
    @RequestMapping(value = "/mst_projects/edit/{id}", method = GET)
    public Object edit(@PathVariable String id)
            throws ApplicationException, IllegalAccessException, NoSuchMethodException {

        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        MstProjectsDao dao = new MstProjectsDaoImpl();

        // プロジェクトデータ取得処理を行う
        MstProjectsWorkers mstProjectsWorkers = tm.required(() -> {
            return dao.selectJoinedById(Long.parseLong(id));
        });

        ModelAndView model = new ModelAndView("mst_projects/edit");
        model.addObject("item", mstProjectsWorkers);
        return model;
    }


}
