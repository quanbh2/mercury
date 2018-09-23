package solar.planet.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilterCustom implements Filter {

    private String allowDomains = "*";

    private String allowMethods = "POST, PUT, GET, OPTIONS, DELETE";

    private String allowHeaders = "x-requested-with";

    private String maxAge = "3600";

    private String allowCredentials = "true";

    private String optionAllowHeaders =
            "authorization, content-type, access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with, lang,jwt";

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Origin", allowDomains);
        response.setHeader("Access-Control-Allow-Methods", allowMethods);
        response.setHeader("Access-Control-Allow-Headers", allowHeaders);
        response.setHeader("Access-Control-Max-Age", maxAge);
        response.setHeader("Access-Control-Allow-Credentials", allowCredentials);
        if (!(request.getMethod().equalsIgnoreCase("OPTIONS"))) {
            try {
                chain.doFilter(req, res);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            log.info("Pre-flight");
            response.setHeader("Access-Control-Max-Age", maxAge);
            response.setHeader("Access-Control-Allow-Headers", optionAllowHeaders);
            response.setStatus(HttpServletResponse.SC_OK);
        }

    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }
}
