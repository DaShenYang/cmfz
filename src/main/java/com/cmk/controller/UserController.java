package com.cmk.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import com.cmk.dto.TemplatePageDto;
import com.cmk.entity.Province;
import com.cmk.entity.User;
import com.cmk.service.UserService;
import io.goeasy.GoEasy;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/activeUser")
    public Map<String, Object> activeUser() {
        Map<String, Object> map = new HashMap();
        int[] a = {7, 14, 21, 28, 35};
        List<Integer> list = new ArrayList<>();

        String[] c = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + "天";

        }
        list = userService.selectCounts(a);
        map.put("intervals", c);
        map.put("counts", list);
        return map;
    }


    @RequestMapping("/distribution")
    public List<Province> distribution(int sex) {

        return userService.distribution(sex);
    }


    @RequestMapping("/queryAllUserByPage")
    public TemplatePageDto<User> queryAllUserByPage(int page, int rows) {
        return userService.queryAllUserByPage(page, rows);
    }


    @RequestMapping("/update")
    public void update(User user) {

        userService.update(user);

        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-6181be6f6c304014bef36247abb9ef87");
        List<Province> provinceList = userService.distribution(0);
        goEasy.publish("1228", JSONObject.toJSONString(provinceList));

        List<Province> provinceList2 = userService.distribution(1);
        goEasy.publish("1828", JSONObject.toJSONString(provinceList2));
    }


    @RequestMapping("/poiExport")
    public String poiExport(HttpSession session, HttpServletResponse response) {
        List<User> list = userService.queryAllUser();

        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/");

        for (User user : list) {
            user.setHeadPic(realPath + user.getHeadPic());
        }


        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息", "1226制作"),
                User.class, list);

        try {
            //workbook.write(new FileOutputStream(new File("E:/user.xls")));


            String encode = URLEncoder.encode("user.xls", "UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" + encode);
            response.setContentType("application/vnd.ms-excel");
            workbook.write(response.getOutputStream());

            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }


    @RequestMapping("/poiImport")
    public void poiImport() {
        ImportParams importParams = new ImportParams();
        importParams.setTitleRows(1);
        importParams.setHeadRows(1);
        List<User> list = ExcelImportUtil.importExcel(new File("E:/user.xls"), User.class, importParams);


        for (User user : list) {
            System.out.println(user);
        }
    }
}
