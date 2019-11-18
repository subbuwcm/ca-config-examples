package subbu.blogspot.caconfig.core.slingcaconfig.nestedconfig;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(
    label = "Footer Configuration",
    description = "Footer Configuration")
public @interface FooterConfig {

  @Property(
      label = "Footer Menu",
      description = "Define multiple menu's which usually will be rendered in order of definition. Please note that configuration and rendering are not necessarily a 1-on-1 match",
      order = 200)
  MenuConfig[] menu();

}