package org.gonnys.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
		
		//text/plain
		response.setContentType("application/json");
		
		List<Menu> menuList = new ArrayList<>();
		menuList.add(new Menu("A",3000));
		menuList.add(new Menu("B",4000));
		menuList.add(new Menu("C",5000));
		menuList.add(new Menu("D",6000));
		menuList.add(new Menu("E",7000));
		
		Collections.shuffle(menuList);

		Gson gson = new Gson();
		String json = gson.toJson(menuList.get(0));
		
		response.getWriter().print(json);
	}

}
