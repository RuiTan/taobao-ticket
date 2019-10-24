package top.guitoubing.taobao.service;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaobaoServiceTest {

    @Autowired
    TaobaoService taobaoService;

    @Test
    void testGenerate(){
        taobaoService.generateTaobao(
                "https://detail.tmall.com/item.htm?id=605486432628&spm=a1z0k.7386009.0.d4919233.4a6432a3auhR2Q&_u=t2dmg8j26111",
                "2019-10-24 18:10:00"
        );
    }

}
