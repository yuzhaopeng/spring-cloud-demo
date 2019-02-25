package com.example.gateway.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class LoginFilter extends ZuulFilter {

    /**
     * 过滤器执行时机
     * pre：可以在请求被路由之前调用。
     * routing：在路由请求时候被调用。
     * post：在routing和error过滤器之后被调用。
     * error：处理请求时发生错误时被调用。
     * @return
     */
    @Override
    public String filterType() {
        //请求路由之前进行拦截
        return "pre";
    }

    /**
     * 拦截顺序 数值越小 优先级越高
     * 自己实现的过滤器，建议执行顺序从0开始，
     * 因为zuul有默认的一些过滤器执行顺序为负，保证默认的过滤器会在业务过滤器之前执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器的拦截范围
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //TODO 实现拦截范围的业务逻辑
        //此处默认拦截所有请求
        return true;
    }

    /**
     * 过滤器的核心方法，当请求被拦截之后会执行此方法
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //TODO 处理过滤器的业务逻辑
        //Zuul的上下文对象，其实就是一个map
        RequestContext context = RequestContext.getCurrentContext();
        //request对象
        HttpServletRequest request = context.getRequest();

        //TODO 实现登陆逻辑
        if(true){//假如登陆成功
            context.setSendZuulResponse(true);//开启路由
            context.set("isOk",true);//为后续的过滤器传值
            context.setResponseStatusCode(200);
        }else{
            context.setSendZuulResponse(false);//不进行路由，返回客户端response
            context.setResponseStatusCode(401); //未认证
        }

        return null;
    }
}
