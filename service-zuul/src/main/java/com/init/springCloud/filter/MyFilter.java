package com.init.springCloud.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(MyFilter.class);
	
	/**
	 * shouldFilter：判断该过滤器是否需要被执行。这里直接返回了true，因此该过滤器对所有的而请求都会生效。
	 * 实际运用中可以利用该函数来指定过滤器的有效范围
	 * if(...){return true}else{return false}
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
	 */
	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if(accessToken == null) {
			log.warn("token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
		log.info("ok");
		return null;
	}

	/**
	 * filterType: 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行，在zuul中定义了四种不同生命周期的过滤器类型。这里定义为pre，代表会在请求被路由之前执行
	 * pre：路由之前
	 * routing：路由之时
	 * post：路由之后
	 * error：发送错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * filterOrder：过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时，需要根据该方法返回值来依次执行。
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	
}
