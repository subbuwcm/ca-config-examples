# Sling Context Aware Config Examples

Clone the project and install in your local with maven build.

* Create the site structure under /conf to point these in your page properties.Create folder 'en' and 'fr' under '/conf/ca-config-examples'
* Open en page (/content/ca-config-examples/en") properties. Select the "CA config" tab and choose "/conf/ca-config-examples/en" do same for the "fr"

* Create a page (CA Config) under "/content/ca-config-examples/en"  by choosing "Context Aware Configuration Editor" template. In this page you configure all the meta data for the "en". If you want to change meta data for child pages of en. just create  CA config page under that page and add the meta data. 

* Open en page or its child page add "CA config Reader" component on the page. to see the configured values


## Modules

The main parts of the template are:

* core: Java bundle containing all core functionality like OSGi services, listeners or schedulers, as well as component-related Java code such as servlets or request filters.
* ui.apps: contains the /apps (and /etc) parts of the project, ie JS&CSS clientlibs, components, templates, runmode specific configs as well as Hobbes-tests
* ui.content: contains sample content using the components from the ui.apps
* ui.tests: Java bundle containing JUnit tests that are executed server-side. This bundle is not to be deployed onto production.
* ui.launcher: contains glue code that deploys the ui.tests bundle (and dependent bundles) to the server and triggers the remote JUnit execution

## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

If you have a running AEM instance you can build and package the whole project and deploy into AEM with

    mvn clean install -PautoInstallPackage

Or to deploy it to a publish instance, run

    mvn clean install -PautoInstallPackagePublish

Or alternatively

    mvn clean install -PautoInstallPackage -Daem.port=4503

Or to deploy only the bundle to the author, run

    mvn clean install -PautoInstallBundle
    

