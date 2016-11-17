package wiki;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		try{
			WikiPage wp = new WikiPage();
			wp.setName(name);
			wp.setContent(content);
			WikiPageDAO.getInstance().insert(wp);
			RequestUtils.setMessage(req, name+"ÇçÏê¨ÇµÇ‹ÇµÇΩÅB");
			req.getRequestDispatcher("/refer").forward(req, res);
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}