package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/dashboard")
public class DashboardFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String homepageURI = request.getContextPath() + "/";
        boolean rightUserDashboard = session != null && session.getAttribute("userId") == servletRequest.getAttribute("UserId");

        if (rightUserDashboard) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(homepageURI);
        }
    }

    @Override
    public void destroy() {

    }
}
