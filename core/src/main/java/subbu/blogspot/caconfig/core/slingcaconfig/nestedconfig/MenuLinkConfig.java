package subbu.blogspot.caconfig.core.slingcaconfig.nestedconfig;

import org.apache.sling.caconfig.annotation.Property;

public @interface MenuLinkConfig {

  /**
   * @return Link Text
   */
  @Property(
      label = "Menu Link Text",
      description = "Configure a link text, when this is available, this will receive preference over nav and page title [Optional]",
      order = 200)
  String linkText();

  /**
   * @return Link
   */
  @Property(
      label = "Menu Link",
      description = "Configure the link to an internal page via the path browser or enter an absolute URL [Optional]",
      property = {
          "widgetType=pathbrowser",
          "pathbrowserRootPath=/content"
      },
      order = 300)
  String link();

}
