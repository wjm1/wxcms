package fjsy.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class wx
 */
@WebServlet("/wx")
public class wx extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public wx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		
		String url="jdbc:mysql://127.0.0.1:3306/test";
		String driver="com.mysql.jdbc.Driver";
		String user="wjm";
		String pass="wjm";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pass);
			st=conn.createStatement();
			
			String sql="select * from xscj";
			rs=st.executeQuery(sql);
			
			out.println("<table border=1>");
			while (rs.next()) {
				out.println("<tr>");
			out.println("<td>"+"\"xh\":\""+rs.getString("xh")+"\","+"</td>");
			out.println("<td>"+"\"zf\":\""+rs.getInt("zf")+"\","+"</td>");
			out.println("<td>"+"\"zy1\":\""+rs.getInt("zy1")+"\","+"</td>");
			out.println("<td>"+"\"zy2\":\""+rs.getInt("zy2")+"\","+"</td>");			
			out.println("<td>"+"\"zy3\":\""+rs.getInt("zy3")+"\""+"</td>");
			out.println("</tr>");
			}
			out.println("</table>");
			rs.close();
			st.close();
			conn.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	    }

}
  