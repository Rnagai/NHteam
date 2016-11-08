package wiki;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils{
	public static void setMessage(HttpServletRequest req,String mes){
		req.setAttribute("message",mes);
	}
}