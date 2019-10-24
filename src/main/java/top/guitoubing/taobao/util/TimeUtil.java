package top.guitoubing.taobao.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.guitoubing.taobao.vo.TargetVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    private static Logger logger = LogManager.getLogger(TimeUtil.class);
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    public static Long DateStringToMill(String date){
        try {
            return simpleDateFormat.parse(date).getTime();
        } catch (ParseException e) {
            logger.error("日期格式出错");
            e.printStackTrace();
        }
        return null;
    }

    public static String getRemainingTime(TargetVO targetVO) throws ParseException {
        return timeFormat.format(new Date(targetVO.getEndDateMill()-System.currentTimeMillis()));
    }

}
