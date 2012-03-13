
package ula.action.front;

import java.util.List;
import java.util.Map;

import ula.action.AnonymousAction;

/**
 * 关于我们
 * 
 * @author Nanlei
 * @author harry
 */
public class AboutAction extends AnonymousAction {
    private List<Map<String, Object>> recommendList;

    private List<Map<String, Object>> linkList;

    private Map<String, Object> weather;

    private Map<String, Object> about;

    public List<Map<String, Object>> getRecommendList() {
        return recommendList;
    }

    public List<Map<String, Object>> getLinkList() {
        return linkList;
    }

    public Map<String, Object> getWeather() {
        return weather;
    }

    public Map<String, Object> getAbout() {
        return about;
    }

    private void baseInfo() throws Exception {
        weather = getServiceManager().getIndexService().getWeather();
        recommendList = getServiceManager().getIndexService().getRecommendList();
        linkList = getServiceManager().getIndexService().getLinkList();
    }

    /**
     * 公司介绍
     * 
     * @return
     * @throws Exception
     */
    public String company() throws Exception {

        this.about = getServiceManager().getFrontService().getAboutByType("company");
        baseInfo();

        return "company";
    }

    /**
     * 业务范围
     * 
     * @return
     * @throws Exception
     */
    public String business() throws Exception {

        this.about = getServiceManager().getFrontService().getAboutByType("business");
        baseInfo();

        return "business";
    }

    /**
     * 团队介绍
     * 
     * @return
     * @throws Exception
     */
    public String team() throws Exception {

        this.about = getServiceManager().getFrontService().getAboutByType("team");
        baseInfo();

        return "team";
    }

    /**
     * 美好回忆
     * 
     * @return
     * @throws Exception
     */
    public String memory() throws Exception {

        this.about = getServiceManager().getFrontService().getAboutByType("memory");
        baseInfo();

        return "memory";
    }

}
