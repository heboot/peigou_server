package com.lugou.score.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lugou.score.core.Result;
import com.lugou.score.core.ResultGenerator;
import com.lugou.score.model.BaoBiaoModel;
import com.lugou.score.model.BaoBiaoPyModel;
import com.lugou.score.model.CanShuModel;
import com.lugou.score.model.CanShuPyModel;
import com.lugou.score.service.CommonService;
import com.lugou.score.utils.DataUtils;
import com.lugou.score.utils.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = {"/dianzicheng"})
public class CommonController {


    @Resource
    private CommonService commonService;

    @Value("${spring.profiles.active}")
    private String env;//当前激活的配置文件

//    [{"日期":"2020-03-24","秤号":1,"一班产量":null,"二班产量":"0","三班产量":null,"四班产量":null,"一班运行":null,"二班运行":"0","三班运行":null,"四班运行":null,"一班运载":null,"二班运载":"0","三班运载":null,"四班运载":null},{"日期":"2020-03-24","秤号":2,"一班产量":null,"二班产量":"0","三班产量":null,"四班产量":null,"一班运行":null,"二班运行":"0","三班运行":null,"四班运行":null,"一班运载":null,"二班运载":"0","三班运载":null,"四班运载":null},{"日期":"2020-03-24","秤号":3,"一班产量":null,"二班产量":"0","三班产量":null,"四班产量":null,"一班运行":null,"二班运行":"0","三班运行":null,"四班运行":null,"一班运载":null,"二班运载":"0","三班运载":null,"四班运载":null},{"日期":"2020-03-24","秤号":4,"一班产量":null,"二班产量":"0","三班产量":null,"四班产量":null,"一班运行":null,"二班运行":"0","三班运行":null,"四班运行":null,"一班运载":null,"二班运载":"0","三班运载":null,"四班运载":null},{"日期":"2020-03-24","秤号":5,"一班产量":null,"二班产量":"0","三班产量":null,"四班产量":null,"一班运行":null,"二班运行":"0","三班运行":null,"四班运行":null,"一班运载":null,"二班运载":"0","三班运载":null,"四班运载":null},{"日期":"2020-03-24","秤号":6,"一班产量":null,"二班产量":"0","三班产量":null,"四班产量":null,"一班运行":null,"二班运行":"0","三班运行":null,"四班运行":null,"一班运载":null,"二班运载":"0","三班运载":null,"四班运载":null},{"日期":"2020-03-24","秤号":7,"一班产量":null,"二班产量":"0","三班产量":null,"四班产量":null,"一班运行":null,"二班运行":"0","三班运行":null,"四班运行":null,"一班运载":null,"二班运载":"0","三班运载":null,"四班运载":null},{"日期":"2020-03-24","秤号":8,"一班产量":null,"二班产量":"0","三班产量":null,"四班产量":null,"一班运行":null,"二班运行":"0","三班运行":null,"四班运行":null,"一班运载":null,"二班运载":"0","三班运载":null,"四班运载":null},{"日期":"2020-03-24","秤号":9,"一班产量":null,"二班产量":"0","三班产量":null,"四班产量":null,"一班运行":null,"二班运行":"0","三班运行":null,"四班运行":null,"一班运载":null,"二班运载":"0","三班运载":null,"四班运载":null},{"日期":"2020-03-24","秤号":10,"一班产量":null,"二班产量":"0","三班产量":null,"四班产量":null,"一班运行":null,"二班运行":"0","三班运行":null,"四班运行":null,"一班运载":null,"二班运载":"0","三班运载":null,"四班运载":null}]

    private Date currentDate;

    /**
     * 提交参数数据
     *
     * @param
     * @param
     * @return
     */
    @PostMapping("/submitData")
    public Result login(@RequestParam String data
    ) {
        System.out.println("收到提交数据>" + data);
        List<CanShuModel> canShuModelList = JSON.parseArray(data, CanShuModel.class);
//        for (CanShuModel canShuModel : canShuModelList) {
//            commonService.updateCanshuTable(canShuModel);
//            BaoBiaoModel baoBiaoModel = new BaoBiaoModel();
//            baoBiaoModel.set秤号(canShuModel.get秤号());
//            baoBiaoModel.set一班产量(canShuModel.get流量());
//            baoBiaoModel.set二班产量(canShuModel.get班产量());
//            baoBiaoModel.set三班产量(canShuModel.get日产量());
//            baoBiaoModel.set四班产量(canShuModel.get累计量());
//            baoBiaoModel.set日期(DateUtil.date2Str(new Date(),DateUtil.FORMAT_YMD));
//            commonService.excuteStatement(baoBiaoModel);
//        }

        //0点班   8.1     16.1   0.1
        currentDate = new Date();
        int currentHour = DateUtil.getHour(currentDate);
        if (currentHour > 0 && currentHour < 8) {
            for (CanShuModel canShuModel : canShuModelList) {
                commonService.updateChanliang(canShuModel.get秤号(), 1, canShuModel.get班产量());
            }
        } else if (currentHour > 8 && currentHour < 16) {
            for (CanShuModel canShuModel : canShuModelList) {
                commonService.updateChanliang(canShuModel.get秤号(), 2, canShuModel.get班产量());
            }

        } else if (currentHour > 16 && currentHour < 24) {
            for (CanShuModel canShuModel : canShuModelList) {
                commonService.updateChanliang(canShuModel.get秤号(), 3, canShuModel.get班产量());
            }

        }

        return ResultGenerator.genSuccessResult();
    }


    /**
     * 提交报表数据
     *
     * @param
     * @param
     * @return
     */
    @PostMapping("/submitStatementData")
    public Result submitStatementData(@RequestParam String data
    ) {
        System.out.println("收到提交报表数据>" + data);
        List<BaoBiaoModel> baoBiaoModelList = JSON.parseArray(data, BaoBiaoModel.class);
        for (BaoBiaoModel baoBiaoModel : baoBiaoModelList) {
            commonService.excuteStatement(baoBiaoModel);
        }
        return ResultGenerator.genSuccessResult();
    }


    @RequestMapping("/canshuList")
    public Result getCanshuDataList() {
        return ResultGenerator.genSuccessResult(JSON.toJSONString(commonService.canshuList()));
    }

    @PostMapping("/dayStatement")
    public Result dayStatement(@RequestParam String date) {
        return ResultGenerator.genSuccessResult(JSON.toJSONString(commonService.getDayStatement(date)));
    }


//    layui 需要的接口

    @RequestMapping("/canshuLayList")
    public Result getCanshuDataLayList() {
        PageHelper.startPage(1, 10);
        List<CanShuPyModel> canShuModels = commonService.canshuList();
        PageInfo<CanShuPyModel> pageInfo = new PageInfo<>(canShuModels);
        List<CanShuPyModel> responseList = pageInfo.getList();
        if (responseList != null && responseList.size() > 3) {
            responseList.get(0).setShebeiming("主井");
            responseList.get(1).setShebeiming("32012");
            responseList.get(2).setShebeiming("筛上品");
            responseList.get(3).setShebeiming("31强带");
        }
        return ResultGenerator.genSuccessListResult(responseList, (int) pageInfo.getTotal());
    }

    @RequestMapping("/layDayStatement")
    public Result layDayStatement() {

        PageHelper.startPage(1, 4);
        List<BaoBiaoPyModel> canShuModels = commonService.getDayStatement(DateUtil.getCurDateStr(DateUtil.FORMAT_YMD));
        PageInfo<BaoBiaoPyModel> pageInfo = new PageInfo<>(canShuModels);
        List<BaoBiaoPyModel> responseList = pageInfo.getList();
        if (responseList != null && responseList.size() > 3) {
            responseList.get(0).setShebeiming("主井");
            responseList.get(1).setShebeiming("32012");
            responseList.get(2).setShebeiming("筛上品");
            responseList.get(3).setShebeiming("31强带");
        }
        BaoBiaoPyModel totalModel = new BaoBiaoPyModel();
        totalModel.setShebeiming("合计");

        totalModel.setOnechanliang(DataUtils.getChanliang1(responseList));
        totalModel.setTwochanliang(DataUtils.getChanliang2(responseList));
        totalModel.setThreechanliang(DataUtils.getChanliang3(responseList));
        totalModel.setFourchanliang(DataUtils.getChanliang4(responseList));

        responseList.add(totalModel);

        return ResultGenerator.genSuccessListResult(responseList, (int) pageInfo.getTotal());
//        return ResultGenerator.genSuccessResult(JSON.toJSONString(commonService.getDayStatement(date)));
    }


    @PostMapping("/monthStatement")
    public Result monthStatement(@RequestParam String chenghao, @RequestParam String startDate, @RequestParam String endDate) {
        Date start = DateUtil.parse(startDate, DateUtil.FORMAT_YMD);
        Date end = DateUtil.parse(endDate, DateUtil.FORMAT_YMD);
        return ResultGenerator.genSuccessResult(JSON.toJSONString(commonService.getMonthStatement(chenghao, start, end)));
    }


    //
    private Date monthDate;

    @RequestMapping("/layMonthStatement")
    public Result layMonthStatement(@RequestParam String chenghao, @RequestParam String date) {
        int month = 1;
        if (date.indexOf("-") <= 0) {
            monthDate = new Date(Long.parseLong(date));
            month = DateUtil.getMonth(monthDate);
        } else {
            month = Integer.parseInt(date.split("-")[1]);
        }


        PageHelper.startPage(1, 10);
        List<BaoBiaoPyModel> canShuModels = commonService.getMonthStatement(chenghao, DateUtil.getMonthStartDate(month - 1), DateUtil.getMonthEndDate(month - 1));
        PageInfo<BaoBiaoPyModel> pageInfo = new PageInfo<>(canShuModels);
        return ResultGenerator.genSuccessListResult(pageInfo.getList(), (int) pageInfo.getTotal());
    }


}
