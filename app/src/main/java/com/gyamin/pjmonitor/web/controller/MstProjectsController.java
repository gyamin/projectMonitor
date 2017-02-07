package com.gyamin.pjmonitor.web.controller;

import com.gyamin.pjmonitor.service.MstProjectsService;
import com.gyamin.pjmonitor.web.exception.ApplicationException;
import com.gyamin.pjmonitor.web.request.MstProjectsNewRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

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
    public Object newView(Model model)
            throws ApplicationException, IllegalAccessException, NoSuchMethodException {

        // プロジェクトデータ取得処理を行う
        MstProjectsService service = new MstProjectsService();
        model = service.getDataForNew(model);

        return "mst_projects/new";
    }

    /**
     * 新規登録処理
     * @return
     */
    @RequestMapping(value = "/mst_projects/new", method = RequestMethod.POST)
    public Object create(@RequestBody @Valid MstProjectsNewRequest request, BindingResult result, Model model)
            throws ApplicationException, IllegalAccessException, NoSuchMethodException {

        // プロジェクトデータ取得処理を行う
        MstProjectsService service = new MstProjectsService();
        int ret = service.createNewProject(request);

        return "mst_projects";
    }

    /**
     * 編集画面表示
     * @return
     */
    @RequestMapping(value = "/mst_projects/edit/{id}", method = GET)
    public Object editView(@PathVariable String id, Model model)
            throws ApplicationException, IllegalAccessException, NoSuchMethodException {

        MstProjectsService service = new MstProjectsService();
        model = service.getDataForEdit(Long.parseLong(id), model);

        return "mst_projects/edit";
    }


}
