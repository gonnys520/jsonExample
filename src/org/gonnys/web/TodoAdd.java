package org.gonnys.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gonnys.domain.Todo;
import org.gonnys.service.TodoService;

/**
 * Servlet implementation class TodoAdd
 */
@WebServlet("/todo/add")
public class TodoAdd extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   private TodoService service
      = new TodoService();
      
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("UTF-8");
      String title = request.getParameter("title");
      
      Todo obj = new Todo();
      obj.setTitle(title);
      
      //pk 구한 것을 json 데이터로 전송
      int pk = service.add(obj);
      
      response.setContentType("application/json");
      
      response.getWriter().print("{\"pk\":"+pk+"}");// {"pk":3} 과 같은 형태를 만들어주는 것. 
   }

}