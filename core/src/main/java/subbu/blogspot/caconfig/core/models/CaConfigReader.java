/**
 * 
 */
package subbu.blogspot.caconfig.core.models;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;

import subbu.blogspot.caconfig.core.slingcaconfig.SiteConfiguration;
import subbu.blogspot.caconfig.core.slingcaconfig.nestedconfig.FooterConfig;

/**
 * @author vraoadavi
 *
 */
@Model(adaptables= {SlingHttpServletRequest.class,Resource.class})
public class CaConfigReader {
    private final Logger logger = LoggerFactory.getLogger(getClass());

	private SiteConfiguration siteConfiguration = null;
	
	private FooterConfig footerConfig = null;
	
	 @ScriptVariable(name = "currentPage")
	 private Page page;
	 
	 private String releaseDateFormat;
	 private String logoImage;
	 private String logoImageLink;
	 private String logoImageAltText;
	 private String dropDown;
	 private String[] stringMultivalueDropdownParam;
	 private String[] stringArrayParam;
	 
	 
	@PostConstruct
	public void init() {
		siteConfiguration =  page.adaptTo(ConfigurationBuilder.class).as(SiteConfiguration.class);
		footerConfig = page.adaptTo(ConfigurationBuilder.class).as(FooterConfig.class);
		releaseDateFormat = siteConfiguration.releaseDateFormat();
		logoImage = siteConfiguration.logoImage();
		logoImageLink = siteConfiguration.logoImageLink();
		logoImageAltText = siteConfiguration.logoImageAltText();
		dropDown = siteConfiguration.dropDown();
		stringMultivalueDropdownParam = siteConfiguration.stringMultivalueDropdownParam();
		stringArrayParam = siteConfiguration.stringArrayParam();
	}

	public String getReleaseDateFormat() {
		return releaseDateFormat;
	}

	public String getLogoImage() {
		return logoImage;
	}

	public String getLogoImageLink() {
		return logoImageLink;
	}

	public String getLogoImageAltText() {
		return logoImageAltText;
	}

	public String getDropDown() {
		return dropDown;
	}

	public String[] getStringMultivalueDropdownParam() {
		return stringMultivalueDropdownParam;
	}

	public String[] getStringArrayParam() {
		return stringArrayParam;
	}
	
	

	public FooterConfig getFooterConfig() {
		return footerConfig;
	}

	@Override
	public String toString() {
		return "CaConfigReader [releaseDateFormat=" + releaseDateFormat + ", logoImage=" + logoImage
				+ ", logoImageLink=" + logoImageLink + ", logoImageAltText=" + logoImageAltText + ", dropDown="
				+ dropDown + ", stringMultivalueDropdownParam=" + Arrays.toString(stringMultivalueDropdownParam)
				+ ", stringArrayParam=" + Arrays.toString(stringArrayParam) + "]";
	}
	
	
}
