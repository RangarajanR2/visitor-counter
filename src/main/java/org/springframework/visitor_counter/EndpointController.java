package org.springframework.visitor_counter;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.visitor_counter.db.DB;
import org.springframework.visitor_counter.repository.Visitor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EndpointController {

	@RequestMapping(method =RequestMethod.GET,path = "/count")
	public String count(HttpServletRequest request) throws UnknownHostException {
		String ip = request.getRemoteAddr();
		String useragent = request.getHeader("User-Agent");
		Visitor visitor = new Visitor(ip, useragent);
		DB.getInstance().insert("visitors", visitor);
		long count = DB.getInstance().count("visitors");
		return ""+count;
	}
}
