package br.com.willianantunes.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer 
{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException 
	{
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebAppConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));
        
        // http://stackoverflow.com/questions/7903556/programming-spring-mvc-controller-and-jsp-for-httpdelete
        // https://cwiki.apache.org/confluence/display/GMOxDOC30/cviewer-javaee6+-+Programmatically+register+servlets+and+filters
        // https://gist.github.com/krams915/4238821        
        servletContext
        	.addFilter("hiddenHttpMethodFilter", "org.springframework.web.filter.HiddenHttpMethodFilter")
        	.addMappingForUrlPatterns(null, false, "/*");

        // This DispatcherServlet is a front controller that forwards the incoming HTTP requests to the specific controler classes
        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
	}

}
