package ula.service.admin;

import java.util.Map;

import ula.common.PagingList;
import ula.service.BaseService;

public class FeedbackService extends BaseService {
	
	private static final String SQL_ADD_FEEDBACK = "INSERT INTO " +
			"feedback(customer,email,fromwhere,feedback,feedbackdate) " +
			"VALUES(?,?,?,?,(select now() from dual))";
	
	private static final String SQL_REMOVE_FEEDBACK ="DELETE FROM feedback " +
			"where Id =?";
	
	private static final String SQL_ADD_REPLY ="UPDATE feedback " +
			"SET reply =?, replydate =(select now() from dual) " +
			"WHERE Id =?";
	
	private static final String SQL_DETAIL = "SELECT * FROM feedback" +
			" WHERE Id =?";
	
	private static final String SQL_GET_FEEDBACKLIST = "SELECT * FROM feedback";
	
	
	public int addFeedback(String customer, String email, String from,
			String feedback) throws Exception{
		return super.DB.update(SQL_ADD_FEEDBACK, new Object[]{customer,email, from, feedback});
	}

	public int removeFeedback(String id) throws Exception {	
		return super.DB.update(SQL_REMOVE_FEEDBACK, new Object[]{id});
	}

	public int addReply(String id, String reply) throws Exception {
		return super.DB.update(SQL_ADD_REPLY, new Object[]{reply,id});
	}

	public PagingList getFeedbacks()  throws Exception{
		return super.getPagingList(SQL_GET_FEEDBACKLIST);
	}

	public Map detail(String id) throws Exception {
		return super.DB.queryForMap(SQL_DETAIL, new Object[]{id});
	}
	
}
