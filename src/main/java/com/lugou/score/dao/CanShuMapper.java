package com.lugou.score.dao;

import com.lugou.score.model.BaoBiaoModel;
import com.lugou.score.model.BaoBiaoPyModel;
import com.lugou.score.model.CanShuPyModel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CanShuMapper {


    Integer updateCanShu(
            @Param("chenghao") int chenghao,
            @Param("wuliaomingcheng") String wuliaomingcheng,
            @Param("xinhao") String xinhao,
            @Param("sudu") String sudu,
            @Param("liuliang") String liuliang,
            @Param("fuhe") String fuhe,
            @Param("lingdian") String lingdian,
            @Param("leijiliang") String leijiliang,
            @Param("xishouxishu") String xishouxishu,
            @Param("liuliangxianzhi") String liuliangxianzhi,
            @Param("hengsushuzhi") String hengsushuzhi,
            @Param("rengonglingdian") String rengonglingdian,
            @Param("celingshijian") String celingshiijan,
            @Param("kongtaijiexian") String kongtaijiexian,
            @Param("shifouxuanzhong") String shifouxuanzhong,
            @Param("yunxingzhuangtai") String yunxingzhuangtai,
            @Param("banchanliang") String banchanliang,
            @Param("richanliang") String richanliang,
            @Param("xunchanliang") String xunchanliang,
            @Param("yunxingshijian") String yunxingshijian,
            @Param("yunzaishijian") String yunzaishijian
    );


    List<CanShuPyModel> canshuList();


    Integer queryDayStatement(@Param("shijian") String date,@Param("chenghao") int chenghao);


    Integer updateDayStatement(
            @Param("riqi") String riqi,
            @Param("chenghao") int chenghao,
            @Param("onechanliang") String onechanliang,
            @Param("twochanliang") String twochanliang,
            @Param("threechanliang") String threechanliang,
            @Param("fourchanliang") String fourchanliang,
            @Param("oneyunxing") String oneyunxing,
            @Param("twoyunxing") String twoyunxing,
            @Param("threeyunxing") String threeyunxing,
            @Param("fouryunxing") String fouryunxing,
            @Param("oneyunzai") String oneyunzai,
            @Param("twoyunzai") String twoyunzai,
            @Param("threeyunzai") String threeyunzai,
            @Param("fouryunzai") String fouryunzai);

    Integer insertDayStatement(@Param("riqi") String riqi,
                               @Param("chenghao") int chenghao,
                               @Param("onechanliang") String onechanliang,
                               @Param("twochanliang") String twochanliang,
                               @Param("threechanliang") String threechanliang,
                               @Param("fourchanliang") String fourchanliang,
                               @Param("oneyunxing") String oneyunxing,
                               @Param("twoyunxing") String twoyunxing,
                               @Param("threeyunxing") String threeyunxing,
                               @Param("fouryunxing") String fouryunxing,
                               @Param("oneyunzai") String oneyunzai,
                               @Param("twoyunzai") String twoyunzai,
                               @Param("threeyunzai") String threeyunzai,
                               @Param("fouryunzai") String fouryunzai,
                               @Param("createTime") Date insertTime
    );

    List<BaoBiaoPyModel> getDayStatement(@Param("riqi") String date);


    List<BaoBiaoPyModel> getMonthStatement(@Param("chenghao") String chenghao,@Param("startDate") Date start,@Param("endDate") Date end);



    Integer updateOneChanliang(@Param("riqi") String riqi,
                               @Param("chenghao") int chenghao,
                               @Param("onechanliang") String onechanliang);

    Integer updateTwoChanliang(@Param("riqi") String riqi,
                               @Param("chenghao") int chenghao,
                               @Param("twochanliang") String twochanliang);

    Integer updateThreeChanliang(@Param("riqi") String riqi,
                               @Param("chenghao") int chenghao,
                               @Param("threechanliang") String threechanliang);

}
