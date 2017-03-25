package servlet;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import entity.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action="";     
	private User user=new User(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		//�ж�action����������ֵ
		if(request.getParameter("action")!=null){
			this.action=request.getParameter("action");
			//��¼����
			if(action.equals("login")){
				try {
					//��ȡ�û���,����,��ɫ
					user.setName(request.getParameter("name"));
					user.setPwd(request.getParameter("pwd")); 
					if(request.getParameter("use")=="admin"){
						user.setAdmin(true);
					}
					else {
						user.setAdmin(false);
					}		
					//�ж��û��ĺϷ���
					if(user.TestLogin(user)){
						String script = "<script>alert('��Ա��½�ɹ�');location.href='index.jsp'</script>";
						request.getSession().setAttribute("user", user);
						request.getSession().setAttribute("name", request.getParameter("name"));
						response.getWriter().println(script);
						} 
					else{ 
						String script = "<script>alert('�û�����������������µ�½');location.href='login1.jsp'</script>";
						response.getWriter().println(script); 
					}
				} catch (Exception e) { 
					// TODO Auto-generated catch block
					e.printStackTrace();					
				}  
			}
			
			if(action.equals("adminlogin")){
				try {
					//��ȡ�û���,����,��ɫ
					user.setName(request.getParameter("name"));
					user.setPwd(request.getParameter("pwd")); 
					if(request.getParameter("use")=="admin"){
						user.setAdmin(true);
					}
					else {
						user.setAdmin(false);
					}		
					//�ж��û��ĺϷ���
					if(user.TestLogin(user)){
						String script = "<script>alert('����Ա��½�ɹ�');location.href='dengluhou.jsp'</script>";
						request.getSession().setAttribute("user", user);
						request.getSession().setAttribute("name", request.getParameter("name"));
						response.getWriter().println(script);
						} 
					else{ 
						String script = "<script>alert('�û�����������������µ�½');location.href='login.jsp'</script>";
						response.getWriter().println(script); 
					}
				} catch (Exception e) { 
					// TODO Auto-generated catch block
					e.printStackTrace();					
				}  
			}
			//ע�ᴦ��
			if(action.equals("reg")){
				try {
					//��ȡ�û���,����,��ɫ
					String name = request.getParameter("name");
					String pwd = request.getParameter("pwd");
					String realname = request.getParameter("realname");
					if(name.trim().equals("") || pwd.trim().equals("") || realname.trim().equals("")){
						String script = "<script>alert('���ݲ���Ϊ��');location.href='register.jsp'</script>";
						response.getWriter().println(script); 
						return ;
					}
					user.setName(request.getParameter("name"));
					user.setPwd(request.getParameter("pwd"));
					user.setRealName(request.getParameter("realName"));
					//�ж��û��ĺϷ���
					if(user.TestReg(user)){
						request.getSession().setAttribute("user", user);
						request.getSession().setAttribute("name", request.getParameter("name"));
						String script = "<script>alert('ע��ɹ�');location.href='login1.jsp'</script>";
						response.getWriter().println(script);						 
					}else{ 
						String script = "<script>alert('ע��ʧ�ܣ�������ע��');location.href='login1.jsp'</script>";
						response.getWriter().println(script); 
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();					
				}  
			}
			 
		}
	}

}
