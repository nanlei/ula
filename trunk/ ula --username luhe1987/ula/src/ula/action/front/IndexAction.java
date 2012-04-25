
package ula.action.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.opensymphony.xwork2.ActionContext;

import ula.action.AnonymousAction;
import ula.util.MapUtil;

/**
 * 首页请求处理Action
 * 
 * @author Nanlei
 */
public class IndexAction extends AnonymousAction {
    private List<Map<String, Object>> recommendList;

    private List<Map<String, Object>> productList;

    private List<Map<String, Object>> linkList;

    private Map<String, Object> weather;

    private List<Map<String, Object>> exchangeRateList;

    private Map<String, Object> recommend;

    private List<Map<String, Object>> product;

    private Map<String, Object> hotel;

    private List<Map<String, Object>> albumPicList;

    private List<Integer> picIndex;

    private HashMap<String, Object> jsonModel;

    private String referer;

    public List<Map<String, Object>> getRecommendList() {
        return recommendList;
    }

    public List<Map<String, Object>> getProductList() {
        return productList;
    }

    public List<Map<String, Object>> getLinkList() {
        return linkList;
    }

    public Map<String, Object> getWeather() {
        return weather;
    }

    public Map<String, Object> getRecommend() {
        return recommend;
    }

    public List<Map<String, Object>> getProduct() {
        return product;
    }

    public Map<String, Object> getHotel() {
        return hotel;
    }

    public List<Map<String, Object>> getAlbumPicList() {
        return albumPicList;
    }

    public List<Integer> getPicIndex() {
        return picIndex;
    }

    public HashMap<String, Object> getJsonModel() {
        return jsonModel;
    }

    public void setJsonModel(HashMap<String, Object> jsonModel) {
        this.jsonModel = jsonModel;
    }

    public String getReferer() {
        return referer;
    }

    public List<Map<String, Object>> getExchangeRateList() {
        return exchangeRateList;
    }

    /**
     * 进入首页的方法
     * 
     * @return
     */
    public String index() throws Exception {
        
        recommendList = getServiceManager().getIndexService().getRecommendList();
        productList = getServiceManager().getIndexService().getProductList();
        linkList = getServiceManager().getIndexService().getLinkList();
        weather = getServiceManager().getIndexService().getWeather();
        exchangeRateList = getServiceManager().getIndexService().getExchangeRate();
        
        this.setAlertLanguages();
        
        return SUCCESS;
    }

    /**
     * 查看首页推荐
     * 
     * @return
     * @throws Exception
     */
    public String recommend() throws Exception {
        recommendList = getServiceManager().getIndexService().getRecommendList();
        linkList = getServiceManager().getIndexService().getLinkList();
        weather = getServiceManager().getIndexService().getWeather();
        recommend = getServiceManager().getIndexService().getRecommendById(getParametersAsMap());

        return "recommend";
    }

    /**
     * 产品
     * 
     * @return
     * @throws Exception
     */
    public String product() throws Exception {
        recommendList = getServiceManager().getIndexService().getRecommendList();
        linkList = getServiceManager().getIndexService().getLinkList();
        weather = getServiceManager().getIndexService().getWeather();
        product = getServiceManager().getIndexService().getProductById(getParametersAsMap());
        return "product";
    }

    /**
     * 酒店查询
     * 
     * @return
     * @throws Exception
     */
    public String hotel() throws Exception {
        hotel = getServiceManager().getIndexService().getHotelById(getParametersAsMap());
        hotel.put(
                "LOCATION",
                getServiceManager().getHotelService().getParamValueByName(
                        (String)hotel.get("LOCATION")));
        hotel.put(
                "LEVEL",
                getServiceManager().getHotelService().getParamValueByName(
                        (String)hotel.get("LEVEL")));
        hotel.put("FUNC",
                getServiceManager().getHotelService()
                        .getParamValueByName((String)hotel.get("FUNC")));
        albumPicList = getServiceManager().getHotelService().getHotelAlbumPicByHotelId(
                String.valueOf(hotel.get("ID")));
        picIndex = new ArrayList<Integer>();
        for (int i = 0; i < albumPicList.size(); i++) {
            Map<String, Object> map = albumPicList.get(i);
            picIndex.add((Integer)map.get("PICID"));
        }
        // baseInfo
        recommendList = getServiceManager().getIndexService().getRecommendList();
        linkList = getServiceManager().getIndexService().getLinkList();
        weather = getServiceManager().getIndexService().getWeather();
        return "hotel";
    }

    /**
     * 订阅资源的方法
     * 
     * @return
     */
    public String subscribe() {

        HashMap<String, Object> map = new HashMap<String, Object>();
        String email = MapUtil.getStringFromMap(getParametersAsMap(), "email");

        Locale curLoc = ActionContext.getContext().getLocale();
        ResourceBundle props = ResourceBundle.getBundle("globalMessages", curLoc);

        String resultKey = "result";
        String msgKey = "msg";

        int flag = getServiceManager().getSubscriberService().getCheckSubscriber(email);
        if (flag > 0) {
            // 邮件地址已经存在
            map.put(resultKey, 2);
            map.put(msgKey, props.getString("front.subscribe.email.existed"));
        } else {
            try {
                getServiceManager().getSubscriberService().addSubscriber(email, getIP());
                // 订阅成功
                map.put(resultKey, 1);
                map.put(msgKey, props.getString("front.subscribe.success"));
            } catch (Exception e) {
                log.error(ExceptionUtils.getStackTrace(e));
                // 订阅失败
                map.put(resultKey, 0);
                map.put(msgKey, props.getString("front.subscribe.failure"));
            }
        }
        setJsonModel(map);
        return "subscribe";
    }

    /**
     * 取消订阅资源的方法
     * 
     * @return
     */
    public String cancelSubscribe() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String email = MapUtil.getStringFromMap(getParametersAsMap(), "email");

        Locale curLoc = ActionContext.getContext().getLocale();
        ResourceBundle props = ResourceBundle.getBundle("globalMessages", curLoc);

        String resultKey = "result";
        String msgKey = "msg";

        int flag = getServiceManager().getSubscriberService().getCheckSubscriber(email);
        if (flag > 0) {
            try {
                getServiceManager().getSubscriberService().deleteSubscriberByEmail(email);
                // 取消订阅成功
                map.put(resultKey, 1);
                map.put(msgKey, props.getString("front.subscribe.canceled"));
            } catch (Exception e) {
                log.error(ExceptionUtils.getStackTrace(e));
                // 取消订阅失败
                map.put(resultKey, 0);
                map.put(msgKey, props.getString("front.subscribe.cancel.failure"));

            }
        } else {
            // 邮件地址不存在
            map.put(resultKey, 0);
            map.put(msgKey, props.getString("front.subscribe.cancel.failure"));
        }
        setJsonModel(map);
        return "cancelSubscribe";
    }

    /**
     * 设置语言版本的方法，将所需的locale放入session
     * 
     * @return
     */
    public String language() {

        String locale = MapUtil.getStringFromMap(getParametersAsMap(), "locale");
        getHttpServletRequest().getSession().setAttribute("locale_session", new Locale(locale));

        String contextPath = getHttpServletRequest().getContextPath();
        String header_referer = getHttpServletRequest().getHeader("referer");
        String temp_referer = header_referer.substring(header_referer.indexOf("//") + 2);

        temp_referer = temp_referer.substring(temp_referer.indexOf("/"));
        temp_referer = temp_referer.substring(temp_referer.indexOf(contextPath)
                + contextPath.length());
        if (!temp_referer.startsWith("/")) {
            temp_referer = "/" + temp_referer;
        }


        this.setAlertLanguages();
        
        referer = temp_referer;
        return SUCCESS;
    }

    /**
     * Set RSS alerts based on locale
     */
    private void setAlertLanguages() {
        
        Locale curLoc = ActionContext.getContext().getLocale();
        ResourceBundle props = ResourceBundle.getBundle("globalMessages", curLoc);

        HttpSession sess = getHttpServletRequest().getSession();
        sess.setAttribute("invalidAdress", props.getString("front.subscribe.email.invalid"));
        sess.setAttribute("noAction", props.getString("front.subscribe.noaction"));
        sess.setAttribute("error", props.getString("front.subscribe.networkerror"));

    }

}
