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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MstProjectsController {

    /**
     * 一覧画面表示
     * @return
     */
    @RequestMapping(value = "/mst_projects", method = GET)
    public Object index(@RequestParam(required = false) String projectNo, Model model)
            throws ApplicationException, IllegalAccessException, NoSuchMethodException {

        // 一覧画面表示に必要なデータ取得を行う
        MstProjectsService service = new MstProjectsService();

        model = service.getDataForIndex(model);

        return "mst_projects/index";
    }

    /**
     * 新規画面表示
     * @return
     */
    @RequestMapping(value = "/mst_projects/new", method = GET)
    public Object create(Model model)
            throws ApplicationException, IllegalAccessException, NoSuchMethodException {

        // プロジェクトデータ取得処理を行う
        MstProjectsService service = new MstProjectsService();
        model = service.getDataForNew(model);

        return "mst_projects/new";
    }

    /**
     * 編集画面表示
     * @return
     */
    @RequestMapping(value = "/mst_projects/edit/{id}", method = GET)
    public Object edit(@PathVariable String id, Model model)
            throws ApplicationException, IllegalAccessException, NoSuchMethodException {

        MstProjectsService service = new MstProjectsService();
        model = service.getDataForEdit(Long.parseLong(id), model);

        return "mst_projects/edit";
    }


}
