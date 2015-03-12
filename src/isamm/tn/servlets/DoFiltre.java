package isamm.tn.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class DoFiltre
 */
@WebFilter("/views/*")
public class DoFiltre implements Filter {

    /**
     * Default constructor. 
     */
    public DoFiltre() {

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		HttpSession session = request2.getSession(); 
		
		
		String chemin = request2.getRequestURI().substring(request2.getContextPath().length());
		
		if ( chemin.startsWith("/css") || chemin.startsWith("/js") || chemin.startsWith("/img") ){
			
			chain.doFilter(request, response); 
			return ; 
		}
		if (session.getAttribute("debut")==  null){
			System.out.print("Session debut :"+session.getAttribute("debut")); 
			System.out.print("context  :"+request2.getContextPath()); 
			response2.sendRedirect("/login.jsp"); 
		}
		else {
			chain.doFilter(request2, response2); 
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
