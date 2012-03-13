
package ula.quartz.service;

import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 向订阅用户发送资源Service
 * 
 * @author Nanlei
 */
public class SendResourceService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    private int interval;

    private JavaMailSender mailSender;

    private String fromAddress;

    private static final String HTML_PREFIX = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><body>";

    private static final String HTML_SUFFIX = "</body></html>";

    private static final String HTML_TIPS = "<p><h4>Sent By System Automatically, Do Not reply! If You Want To Un Subscribe, Please Go To <a href='http://www.dalianjoytour.com'>Joytour</a></h4></p>";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    private static final String SQL_GET_RESOURCE = "select * from resource where TAG=0 order by ID asc limit 1";

    private Map<String, Object> getResource() {
        Map<String, Object> map = null;
        try {
            map = jdbcTemplate.queryForMap(SQL_GET_RESOURCE);
            return map;
        } catch (EmptyResultDataAccessException erdae) {
            // logger.error(ExceptionUtils.getStackTrace(erdae));
            return null;
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    private static final String SQL_COUNT_SUBSCRIBERS = "select count(*) from resource_subscriber";

    private int getSubscriberCount() {
        return jdbcTemplate.queryForInt(SQL_COUNT_SUBSCRIBERS);
    }

    private static final String SQL_GET_SUBSCRIBERS = "select ID,EMAIL from resource_subscriber where ID>? order by ID asc limit ?";

    public List<Map<String, Object>> getSubscribers(int lastSubscriber, int interval) {
        return jdbcTemplate.queryForList(SQL_GET_SUBSCRIBERS, lastSubscriber, interval);
    }

    private static final String SQL_UPDATE_RESOURCE = "update resource set TAG=?, COUNTER=?, LASTSUBSCRIBER=? where ID=?";

    private void updateResource(int tag, int counter, int lastSubscriber, int id) {
        jdbcTemplate.update(SQL_UPDATE_RESOURCE, tag, counter, lastSubscriber, id);
    }

    public void sendResource() throws Exception {
        // 资源发送完毕标识位
        int tag = 0;
        // 获取一条还未处理完成的资源
        Map<String, Object> resource = getResource();
        if (resource != null) {
            // 获取订阅总人数
            int subscriberCount = getSubscriberCount();
            // 获取资源已发送人数
            int counter = (Integer)resource.get("COUNTER");
            // 本次发送次数
            int times = subscriberCount - counter > interval ? interval : subscriberCount - counter;
            int lastSubscriber = (Integer)resource.get("LASTSUBSCRIBER");
            // 获取本次发送的邮件列表
            List<Map<String, Object>> subscriberList = getSubscribers(lastSubscriber, interval);
            times = times > subscriberList.size() ? subscriberList.size() : times;
            // 设置密送发送邮件数组
            String[] bcc = new String[times];
            // 填充数组
            for (int i = 0; i < times; i++) {
                bcc[i] = (String)subscriberList.get(i).get("EMAIL");
            }

            // 发送邮件
            MimeMessage htmlMessage = mailSender.createMimeMessage();
            // 发送HTML邮件
            MimeMessageHelper helper = new MimeMessageHelper(htmlMessage, true, "UTF-8");
            // 设置邮件属性
            helper.setFrom(fromAddress);
            helper.setBcc(bcc);
            helper.setSubject((String)resource.get("TITLE"));
            helper.setText(HTML_PREFIX + (String)resource.get("CONTENT") + HTML_TIPS + HTML_SUFFIX,
                    true);
            // 发送邮件
            mailSender.send(htmlMessage);
            // 说明该订阅资源已经发送完毕，tag=1
            if (subscriberList.size() > 0 && subscriberList.size() < interval) {
                tag = 1;
            }
            // 更新最后订阅者
            if (subscriberList.size() > 0) {
                lastSubscriber = (Integer)subscriberList.get(times - 1).get("ID");
            }
            updateResource(tag, counter + times, lastSubscriber, (Integer)resource.get("ID"));
            logger.info("Send Resource To {} User(s)", times);
        }
    }

    /**
     * @param from
     * @param message
     * @param email
     * @param phone
     */
    public void sendToAdmin(String from, String message, String email, String phone) {

    }

    public class UserContactInfo {
        String name;

        String email;

        String phone;

        String msg;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        @Override
        public String toString() {
            return "UserContactInfo [name=" + name + ", email=" + email + ", phone=" + phone
                    + ", msg=" + msg + "]";
        }

    }

}
