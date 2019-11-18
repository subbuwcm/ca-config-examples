package subbu.blogspot.caconfig.core.slingcaconfig.nestedconfig;

import org.apache.sling.caconfig.annotation.Property;

public @interface MenuConfig {

  /**
   * @return Links
   */
  @Property(label = "Menu Links", description = "Configure a list of links")
  MenuLinkConfig[] links();
}