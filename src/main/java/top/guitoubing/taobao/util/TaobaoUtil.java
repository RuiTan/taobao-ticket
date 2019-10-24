package top.guitoubing.taobao.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;
import top.guitoubing.taobao.vo.TargetVO;

import java.text.ParseException;

@Component
public class TaobaoUtil implements Runnable{

    private static Logger logger = LogManager.getLogger(TaobaoUtil.class);
    private WebDriver webDriver;
    private TargetVO targetVO;

    public TaobaoUtil() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    public TaobaoUtil init(TargetVO targetVO){
        this.targetVO = targetVO;
        return this;
    }

    private void process() throws ParseException, InterruptedException {
        login();
        target();
    }

    private void login() throws InterruptedException, ParseException {
        webDriver.get(Constants.LoginURL);
        logger.warn("请在10秒内扫描二维码登录");
        Thread.sleep(10000);
        logger.info("登录成功：" + DateUtil.getJavaCalendar(System.currentTimeMillis()));
    }

    private void target() throws ParseException {
        logger.info("进入抢券页面");
        webDriver.get(targetVO.getTargetURL());
        WebElement waitBtn;
        while (true) {
            waitBtn = webDriver.findElement(By.className(Constants.waitBtnClass));
            if (waitBtn == null) {
                tempProp();
                logger.info("开抢！！！");
                submit();
                break;
            }else {
                logger.warn("抢券还未开始...，剩余时间：" + TimeUtil.getRemainingTime(targetVO) + "秒");
            }
        }
    }

    private void tempProp() {
        WebElement category = webDriver.findElement(By.className(Constants.saleCategory));
        if (null != category) {
            category.click();
        }
        logger.warn("无需选择商品信息");
    }

    private void submit(){
        logger.info("进入提交订单页面");
        WebElement submitBtn;
        while (true) {
            submitBtn = webDriver.findElement(By.className(Constants.submitOrderClass));
            if (null == submitBtn) {
                logger.warn("获取提交订单按钮失败，正在重试");
            }else {
                submitBtn.click();
                logger.info("提交订单成功");
                break;
            }
        }
    }

    @Override
    public void run() {
        try {
            process();
        } catch (ParseException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
