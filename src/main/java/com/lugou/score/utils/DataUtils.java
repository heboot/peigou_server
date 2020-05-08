package com.lugou.score.utils;

import com.lugou.score.model.BaoBiaoPyModel;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataUtils {

    public static String getDeviceName(int chenghao) {
        switch (chenghao) {
            case 1:
                return "主井";
            case 2:
                return "32012";
            case 3:
                return "筛上品";
            case 4:
                return "31强带";

        }
        return "物料名";
    }

    public static String getChanliang1(List<BaoBiaoPyModel> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        if (list.size() > 3) {
            return getRileiji(list.get(0).getOnechanliang(), list.get(1).getOnechanliang(), list.get(2).getOnechanliang(), list.get(3).getOnechanliang());
        } else if (list.size() == 3) {
            return getRileiji(list.get(0).getOnechanliang(), list.get(1).getOnechanliang(), list.get(2).getOnechanliang());
        } else if (list.size() == 2) {
            return getRileiji(list.get(0).getOnechanliang(), list.get(1).getOnechanliang(), "");
        } else if (list.size() == 1) {
            return getRileiji(list.get(0).getOnechanliang(), "", "");
        }
        return "";

    }

    public static String getChanliang2(List<BaoBiaoPyModel> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        if (list.size() > 3) {
            return getRileiji(list.get(0).getTwochanliang(), list.get(1).getTwochanliang(), list.get(2).getTwochanliang(), list.get(3).getTwochanliang());
        } else if (list.size() == 3) {
            return getRileiji(list.get(0).getTwochanliang(), list.get(1).getTwochanliang(), list.get(2).getTwochanliang());
        } else if (list.size() == 2) {
            return getRileiji(list.get(0).getTwochanliang(), list.get(1).getTwochanliang(), "");
        } else if (list.size() == 1) {
            return getRileiji(list.get(0).getTwochanliang(), "", "");
        }
        return "";

    }

    public static String getChanliang3(List<BaoBiaoPyModel> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        if (list.size() > 3) {
            return getRileiji(list.get(0).getThreechanliang(), list.get(1).getThreechanliang(), list.get(2).getThreechanliang(), list.get(3).getThreechanliang());
        } else if (list.size() == 3) {
            return getRileiji(list.get(0).getThreechanliang(), list.get(1).getThreechanliang(), list.get(2).getThreechanliang());
        } else if (list.size() == 2) {
            return getRileiji(list.get(0).getThreechanliang(), list.get(1).getThreechanliang(), "");
        } else if (list.size() == 1) {
            return getRileiji(list.get(0).getThreechanliang(), "", "");
        }
        return "";

    }

    public static String getChanliang4(List<BaoBiaoPyModel> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        if (list.size() > 3) {
            return getRileiji(list.get(0).getFourchanliang(), list.get(1).getFourchanliang(), list.get(2).getFourchanliang(), list.get(3).getFourchanliang());
        } else if (list.size() == 3) {
            return getRileiji(list.get(0).getFourchanliang(), list.get(1).getFourchanliang(), list.get(2).getFourchanliang());
        } else if (list.size() == 2) {
            return getRileiji(list.get(0).getFourchanliang(), list.get(1).getFourchanliang(), "");
        } else if (list.size() == 1) {
            return getRileiji(list.get(0).getFourchanliang(), "", "");
        }
        return "";

    }

    public static String getRileiji(String data1, String data2, String data3) {
        Double d1 = StringUtils.isEmpty(data1) ? 0.00 : Double.parseDouble(data1);
        Double d2 = StringUtils.isEmpty(data2) ? 0.00 : Double.parseDouble(data2);
        Double d3 = StringUtils.isEmpty(data3) ? 0.00 : Double.parseDouble(data3);
        return String.valueOf(d1 + d2 + d3);
    }

    public static String getRileiji(String data1, String data2, String data3, String data4) {
        Double d1 = StringUtils.isEmpty(data1) ? 0.00 : Double.parseDouble(data1);
        Double d2 = StringUtils.isEmpty(data2) ? 0.00 : Double.parseDouble(data2);
        Double d3 = StringUtils.isEmpty(data3) ? 0.00 : Double.parseDouble(data3);
        Double d4 = StringUtils.isEmpty(data3) ? 0.00 : Double.parseDouble(data4);
        return String.valueOf(d1 + d2 + d3 + d4);
    }

    public static Date getMonthStartDate(int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return c.getTime();
    }

    public static Date getMonthEndDate(int month) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MONTH, month);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return ca.getTime();
    }

    public static double formatNumber(String number) {
        double result = 0.0;
        if (StringUtils.isEmpty(number)) {
            result = 0.0;
        } else {
            try {
                result = Double.parseDouble(number);
            } catch (Exception ex) {
                result = 0.0;
            }
        }
        return result;
    }


}
