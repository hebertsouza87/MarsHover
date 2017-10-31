package com.mars.filter;

import com.mars.exception.RestHttpException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestExceptionHandlerFilter implements Filter {

    private static final Log LOG = LogFactory.getLog(RestExceptionHandlerFilter.class);

    private String acceptHeader;

    public RestExceptionHandlerFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.setContentType(acceptHeader);

        try {
            chain.doFilter(request, response);
        } catch (RestHttpException e) {
            handleRestException(e, request, response);
            LOG.debug("RestExceptionHandlerFilter: ", e);
        } catch (ServletException e) {
            RestHttpException cause = e.getCause() instanceof RestHttpException ? (RestHttpException) e.getCause() : new com.mars.exception.InternalServerException();
            handleRestException(cause, request, response);
            LOG.error("RestExceptionHandlerFilter: ", e);
        }
    }

    private void handleRestException(RestHttpException e, ServletRequest request, ServletResponse response) throws IOException {
        String uri = ((HttpServletRequest) request).getRequestURI();
        String message = e.to(uri);

        ((HttpServletResponse) response).setStatus(e.getStatus());
        ((HttpServletResponse) response).setContentType("application/json");

        PrintWriter writer = response.getWriter();
        writer.write(message);
    }
}
