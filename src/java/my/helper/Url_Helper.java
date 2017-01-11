package my.helper;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class Url_Helper {
	
	static public StringBuffer getContextRootUrl() {
            HttpServletRequest request = ServletActionContext.getRequest();
            return getContextRootUrl(request);
	}
	
	static public StringBuffer getContextRootUrl(HttpServletRequest request) {
            String protocol = request.getProtocol().toLowerCase();
            StringBuffer buffer = new StringBuffer();
            if (protocol.contains("https")) {
                buffer.append("https://");			
            } else {
                buffer.append("http://");
            }
            buffer.append(request.getLocalAddr());
            //buffer.append(request.getLocalName());
            buffer.append(":");
            buffer.append(request.getServerPort());

            String contextPath = request.getContextPath();
            if (contextPath != null) {
                buffer.append(request.getContextPath());
            }
            return buffer;
	}
	
	static public StringBuffer getAbsoluteUrl(String relativeUrl, HttpServletRequest request) {
            StringBuffer buffer= getContextRootUrl(request);
            buffer.append(relativeUrl);
            return buffer;
	}
	
	static public StringBuffer getAbsoluteUrl(String relativeUrl) {
            HttpServletRequest request = ServletActionContext.getRequest();
            return getAbsoluteUrl(relativeUrl, request);
	}
	
	static public String getPhysicalPath() {
            return ServletActionContext.getServletContext().getRealPath("/");
	}
	
	static public String getPhysicalPath(String relativePath) {
            return ServletActionContext.getServletContext().getRealPath("/")+relativePath;
	}
}
