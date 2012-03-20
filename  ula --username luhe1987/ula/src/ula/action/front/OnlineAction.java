
package ula.action.front;

import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import ula.action.AnonymousAction;
import ula.util.MapUtil;

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

        String from_usr = MapUtil.getStringFromMap(getParametersAsMap(), "from_user");

        if (from_usr != null) {

            String name = MapUtil.getStringFromMap(getParametersAsMap(), "contact");
            String phone = MapUtil.getStringFromMap(getParametersAsMap(), "phoneNumber");
            String email = MapUtil.getStringFromMap(getParametersAsMap(), "contactValue");
            String msg = MapUtil.getStringFromMap(getParametersAsMap(), "remarks");

            int send_ok = -1;

            if (isPhoneFormat(phone) && isEmailFormat(email)) {
                send_ok = getServiceManager().getSendResourceService().sendToAdmin(name, msg,
                        email, phone);
                getHttpServletRequest().setAttribute("send_ok", send_ok == 0 ? "YES" : "NO");
            }

        }

        baseInfo();
        return "email";
    }

    private boolean isPhoneFormat(String phone) {
        if (phone == null) {
            return false;
        }
        char[] chars = phone.toCharArray();

        for (char c : chars) {

            if (Character.isDigit(c) || c == '(' || c == ')' || c == '+') {
                continue;
            }
            return false;

        }

        return true;

    }

    private boolean isEmailFormat(String email) {

        if (email == null) {
            return false;
        }

        char[] chars = email.toCharArray();

        for (char c : chars) {
            if (Character.isLetterOrDigit(c) || c == '@' || c == '.') {
                continue;
            }

            return false;
        }

        return true;
    }

}
