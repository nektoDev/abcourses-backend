package ru.nektodev.abcourses;

import org.apache.log4j.Logger;
import org.springframework.util.SimpleIdGenerator;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nektodev
 * @date 20.09.16
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = Logger.getLogger(RequestInterceptor.class);
    private static final String START_TIME_ATTRIBUTE = "startTime";
    private static final String UUID_ATTRIBUTE = "UUID";
    private final SimpleIdGenerator idGenerator = new SimpleIdGenerator();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uuid = String.valueOf(idGenerator.generateId());

        LOG.info(String.format("[%s] Incoming request path=%s, method=%s", uuid, request.getRequestURI(), request.getMethod()));

        long startTime = System.currentTimeMillis();
        request.setAttribute(START_TIME_ATTRIBUTE, startTime);
        request.setAttribute(UUID_ATTRIBUTE, uuid.intern());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long finishTime = System.currentTimeMillis();
        long duration = finishTime - Long.valueOf(String.valueOf(request.getAttribute(START_TIME_ATTRIBUTE)));
        String uuid = String.valueOf(request.getAttribute(UUID_ATTRIBUTE));

        LOG.info(String.format("[%s] Outgoing response: %dms", uuid, duration));

        super.postHandle(request, response, handler, modelAndView);
    }


}
