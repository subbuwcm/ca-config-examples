package subbu.blogspot.caconfig.core.slingcaconfig;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(
    label = "Locale Page Configurations",
    description = "Configuration can be made per website")
public @interface SiteConfiguration {

    @Property(label="Release date forrmate", description="Release date formate")
    String releaseDateFormat();
    
    @Property(
            label = "Logo Image",
            description = "Logo link",
            property = {
                    "widgetType=pathbrowser",
                    "pathbrowserRootPath=/content/dam"
            },
            order = 300
    )
    String logoImage();
    @Property(
            label = "Logo Image link",
            description = "Logo link",
            property = {
                    "widgetType=pathbrowser",
                    "pathbrowserRootPath=/content"
            },
            order = 300
    )
    String logoImageLink();
    
    @Property(label="Logo Image alt text", description="Logo alt text")
    String logoImageAltText();
    
   
    @Property(label = "Dropdown example", description = "This is a string parameter with dropdown list.",
        property = {
            "widgetType=dropdown",
            "dropdownOptions=["
                + "{'value':'option1','description':'First option'},"
                + "{'value':'option2','description':'Second option'},"
                + "{'value':'option3','description':'Third option'}"
                + "]"
        })
    String dropDown();
    
    @Property(label = "String Multivalue Dropdown Param", description = "This is a multi-valued string parameter with dropdown list.", order = 9,
        property = {
            "widgetType=dropdown",
            "dropdownOptions=["
                + "{'value':'option1','description':'Option #1'},"
                + "{'value':'option2','description':'Option #2'},"
                + "{'value':'option3','description':'Option #3'},"
                + "{'value':'option4','description':'Option #4'},"
                + "{'value':'option5','description':'Option #5'}"
                + "]"
        })
    String[] stringMultivalueDropdownParam();
   
    @Property(label = "String Array Param")
    String[] stringArrayParam() default {
        "Subbu", "RK","Kiran","Laxman"
    };
}