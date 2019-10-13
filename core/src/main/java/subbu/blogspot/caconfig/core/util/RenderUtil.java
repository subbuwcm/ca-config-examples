/**
 * 
 */
package subbu.blogspot.caconfig.core.util;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.Template;

/**
 * @author vraoadavi
 *
 */
public class RenderUtil {
	
	private static final String PAGE_PROPERTIES = "wcm/core/content/sites/properties";
	public static boolean isTemplate(
	SlingHttpServletRequest slingHttpServletRequest,
			    HttpServletRequest httpServletRequest,
			    String templatePath) {
			    // error if any of the passed params is null.
			    if (slingHttpServletRequest == null
			        || httpServletRequest == null
			        || StringUtils.isBlank(templatePath)) {
			      throw new IllegalArgumentException("One of the passed parameters is null.");
			    }
			    // the dialog is a page properties dialog
			    if (StringUtils.contains(httpServletRequest.getPathInfo(), PAGE_PROPERTIES)) {
			      // get the actual page path
			      String pagePath = httpServletRequest.getParameter("item");
			      // get page template path and check it
			      return Optional.ofNullable(slingHttpServletRequest.getResourceResolver())
			          .map(resourceResolver -> resourceResolver.getResource(pagePath))
			          .map(pageResource -> pageResource.adaptTo(Page.class))
			          .map(Page::getTemplate)
			          .map(Template::getPath)
			          .map(path -> StringUtils.contains(path, templatePath))
			          .orElse(false);
			    }
			    return false;
			  }
}
