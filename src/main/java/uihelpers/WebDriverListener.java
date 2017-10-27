package uihelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverListener implements WebDriverEventListener {

//    final ThreadLocal<Logger> logger = ThreadLocal.withInitial(() -> LoggerFactory.getLogger(WebDriverListener.class));
//    private static Logger logger = LoggerFactory.getLogger(WebDriverListener.class);

    private WebDriver webDriver;

    public WebDriverListener(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
//        logger
//                .get()
//                .info(String.format("Before Navigate To: %s", url));
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
//        logger.get().info(String.format("After Navigate To: %s", url));
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
//        logger.get().info(String.format("Before Find By: %s", by.toString()));
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
//        logger.get().info(String.format("After Find By: %s", by.toString()));
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
//        String stringParam = "";
//        for (CharSequence charseq : keysToSend){
//            stringParam += charseq.toString();
//        }
//        logger.get().info(String.format("Before Change Value Of: %s", stringParam.trim()));
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
//        String stringParam = "";
//        for (CharSequence charseq : keysToSend){
//            stringParam += charseq.toString();
//        }
//        logger.get().info(String.format("After Change Value Of: %s", stringParam.trim()));
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }
}
