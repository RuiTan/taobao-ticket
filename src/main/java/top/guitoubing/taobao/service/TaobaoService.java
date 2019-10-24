package top.guitoubing.taobao.service;

import org.springframework.stereotype.Service;
import top.guitoubing.taobao.util.TaobaoUtil;
import top.guitoubing.taobao.util.ThreadPoolUtil;
import top.guitoubing.taobao.vo.TargetVO;

@Service
public class TaobaoService {

    public void generateTaobao(String url, String date){
        TargetVO targetVO = new TargetVO(url, date);
        ThreadPoolUtil.getCachedThreadPool().execute(new TaobaoUtil().init(targetVO));
    }

}
