package subbu.blogspot.caconfig.core.slingcaconfig.collections;

import org.apache.sling.caconfig.annotation.Configuration;

/**
 * @author vraoadavi
 *
 */
@Configuration(collection = true, label = "CollectionExample",description = "CollectionExample")
public @interface CollectionExample {

	  /**
	   * @return Link name
	   */
	  String name();

	  /**
	   * @return Page path for internal link
	   */
	  String pagePath();

}
