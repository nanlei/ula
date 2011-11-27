package ula.common;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * JSON返回结果类型，使用jackson插件处理
 * 
 * @author Nanlei
 * 
 */
public class JSONResult implements Result {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void execute(ActionInvocation invocation) throws Exception {
		// 获取HTTP响应对象
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置返回类型
		response.setContentType("text/plain");
		// 获取PrintWriter对象
		PrintWriter out = response.getWriter();
		// 获取值栈
		ValueStack valueStack = invocation.getStack();
		// 从值栈中获取jsonModel
		Object jsonModel = valueStack.findValue("jsonModel");
		// 创建ObjectMapper对象，用于映射JSON对象
		ObjectMapper mapper = new ObjectMapper();
		// 创建StringWriter对象，用于输出JSON文本
		StringWriter sw = new StringWriter();
		// 创建JSON生成器
		JsonGenerator generator = new JsonFactory().createJsonGenerator(sw);
		// 将JSON对象写入文本信息
		mapper.writeValue(generator, jsonModel);
		// 关闭JSON生成器
		generator.close();
		// 向客户端输出JSON文本
		out.println(sw.toString());
	}

}
