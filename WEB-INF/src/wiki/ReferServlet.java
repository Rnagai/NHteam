package wiki;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RederServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		String name = req.getParameter("name");
		try{
			if(name != null){
				WikiPage wikiPage = WikiPageDAO.getInstance().findByName(name);
				HttpSession hs = req.getSession();
				hs.setAttribute("wikiPage", wikiPage);
			}
			req.getRequestDispatcher("/refer.jsp");
		}catch(SQLException e){
			throw new ServletException(e);
		}
	}
}