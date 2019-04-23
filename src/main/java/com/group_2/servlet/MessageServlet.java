package com.group_2.servlet;


import com.group_2.milestonePlanner.dao.H2Message;
import com.group_2.milestonePlanner.model.Message;
import com.group_2.util.mustache.MustacheRender;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;


public class MessageServlet extends HttpServlet{
	@SuppressWarnings("unused")
	static final Logger LOG = LoggerFactory.getLogger(MessageServlet.class);

	private final H2Message h2Message;
	private final MustacheRender mustache;
	public MessageServlet(H2Message h2Message) {
		mustache = new MustacheRender();
		this.h2Message = h2Message;
	}
	public MessageServlet(){
		mustache = new MustacheRender();
		this.h2Message = new H2Message();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Message> messages = h2Message.findMessages();
		String html = mustache.render("index.mustache", new Result(messages.size()));
		response.setContentType("text/html");
		response.setStatus(200);
		response.getOutputStream().write(html.getBytes(Charset.forName("utf-8")));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("text");
		Message message = new Message(text);
		h2Message.addMessage(message);
		response.sendRedirect("/index");
	}

	@Data
	class Result {
		private int count;
		Result(int count) { this.count = count; }
	}
}

