package subbu.blogspot.caconfig.core.models;

import com.day.cq.wcm.api.Page;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextBuilder;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import subbu.blogspot.caconfig.core.slingcaconfig.SiteConfiguration;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.testing.mock.caconfig.MockContextAwareConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Collection;
import java.util.Collections;

import static io.wcm.testing.mock.wcmio.caconfig.ContextPlugins.WCMIO_CACONFIG;
import static org.apache.sling.testing.mock.caconfig.ContextPlugins.CACONFIG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(AemContextExtension.class)
class CaConfigReaderTest {

	private final AemContext context = new AemContextBuilder().plugin(CACONFIG).plugin(WCMIO_CACONFIG)
			.<AemContext>afterSetUp(context -> {
				context.addModelsForPackage("subbu.blogspot.caconfig.core.models");
			}).build();

	private Resource curResource;

	private Page curPage;

	private CaConfigReader caConfigReader;

	@BeforeEach
	void setUp() {

		context.create().resource("/content/ca-config-examples/en", "sling:configRef", "/conf/ca-config-examples/en");
		curPage = context.create().page("/content/ca-config-examples/en/ca-config-test-page");

		context.currentPage("/content/ca-config-examples/en/ca-config-test-page");
		context.currentResource(curResource);

		SlingBindings slingBindings = (SlingBindings) context.request().getAttribute(SlingBindings.class.getName());
		slingBindings.put("currentPage", curPage);

		MockContextAwareConfig.writeConfiguration(context, curPage.getPath(), SiteConfiguration.class, "logoImage",
				"logo image path", "logoImageAltText", "logo alt text","dropDown","option1");
		
	}

	@Test
	public void testConfigProperties() {
		caConfigReader = context.request().adaptTo(CaConfigReader.class);
		System.out.println(""+caConfigReader.getDropDown());
	}

}

