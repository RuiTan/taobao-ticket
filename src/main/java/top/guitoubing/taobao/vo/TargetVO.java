package top.guitoubing.taobao.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.guitoubing.taobao.util.TimeUtil;

@Data
@AllArgsConstructor
public class TargetVO {

    private String targetURL;
    private String endDate;

    public Long getEndDateMill(){
        return TimeUtil.DateStringToMill(endDate);
    }

}
