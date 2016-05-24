package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataBaseUtil.DbUtil;

/**
 * Servlet implementation class findServlet
 */
@WebServlet("/findServlet")
public class findServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
	try {
	   String serialnum=request.getParameter("serialnum");
	   String builder=request.getParameter("builder");
	   String model=request.getParameter("model");
	   String type=request.getParameter("type");
	   String backWood=request.getParameter("backWood");
	   String topWood=request.getParameter("topWood");
	   
	   StringBuffer sql=new StringBuffer();
	   //查询字符串
	   sql.append("select * from guitar where 1=1 ");
	   if(!serialnum.equals("")){
	    sql.append("and serialNumber like '%");
	    sql.append(serialnum);
	    sql.append("%' ");
	   
	   }
	   if(!builder.equals("")){
		   sql.append(" and builder like '%");
		    sql.append(builder);
		    sql.append("%' ");
	   }
	   if(!model.equals("")){
		   sql.append(" and model like '%");
		    sql.append(model);
		    sql.append("%' ");
	   }
	   if(!builder.equals("")){
		   sql.append(" and builder like '%");
		    sql.append(builder);
		    sql.append("%' ");
	   }
	   if(!type.equals("请选择")){
		   sql.append(" and type like '%");
		    sql.append(type);
		    sql.append("%' ");
	   }
	   if(!backWood.equals("")){
		   sql.append(" and backWood like '%");
		    sql.append(backWood);
		    sql.append("%' ");
	   }
	   if(!topWood.equals("")){
		   sql.append(" and topWood like '%");
		    sql.append(topWood);
		    sql.append("%'");
	   }
	   System.out.println(sql);
	
	
		DbUtil DbUtil=new DbUtil();
		Connection conn=DbUtil.getConnection();
		PreparedStatement stmt=conn.prepareStatement(sql.toString());
		ResultSet rs= stmt.executeQuery();
		response.setContentType("text/x-json");
		PrintWriter pw = response.getWriter();	
		
		String j = "{\"guitar\": [";
		while(rs.next()) {	
			j += "{";
			j += "\"serialnum\": \"" + rs.getString("serialNumber") + "\", ";
			j += "\"price\": \"" + rs.getString("price") + "\", ";
			j += "\"builder\": \"" + rs.getString("builder") + "\", ";
			j += "\"model\": \"" + rs.getString("model") + "\", ";
			j += "\"type\": \"" + rs.getString("type") + "\", ";
			j += "\"backWood\": \"" + rs.getString("backWood") + "\", ";
			j += "\"topWood\": \"" + rs.getString("topWood") + "\"";
			j += "}";
			j += ", ";
		}
		if (j != "{\"guitar\": [") {
			j = j.substring(0, j.length() - 2);
		}
		j += "]}";
		
		pw.print(j);
		System.out.print(j);
		}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
