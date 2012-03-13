
package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.AnonymousAction;

/**
 * 在线咨询
 * 
 * @author Nanlei
 * @author harry
 */
public class OnlineAction extends AnonymousAction {
    private List<Map<String, Object>> recommendList;

    private List<Map<String, Object>> linkList;

    private Map<String, Object> weather;

    public List<Map<String, Object>> getRecommendList() {
        return recommendList;
    }

    public List<Map<String, Object>> getLinkList() {
        return linkList;
    }

    public Map<String, Object> getWeather() {
        return weather;
    }

    private void baseInfo() throws Exception {
        weather = getServiceManager().getIndexService().getWeather();
        recommendList = getServiceManager().getIndexService().getRecommendList();
        linkList = getServiceManager().getIndexService().getLinkList();
    }

    /**
     * 聊天咨询
     * 
     * @return
     * @throws Exception
     */
    public String chat() throws Exception {

        baseInfo();
        return "chat";
    }

    /**
     * 邮件咨询
     * 
     * @return
     * @throws Exception
     */
    public String email() throws Exception {

        baseInfo();
        return "email";
    }

}
