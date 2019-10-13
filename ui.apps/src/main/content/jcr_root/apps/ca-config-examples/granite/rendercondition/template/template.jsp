<%@include file="/libs/foundation/global.jsp"%>
<%@page session="false"
        import="com.adobe.granite.ui.components.Config,
          com.adobe.granite.ui.components.rendercondition.RenderCondition,
          com.adobe.granite.ui.components.rendercondition.SimpleRenderCondition,
          org.apache.sling.api.resource.Resource,
          subbu.blogspot.caconfig.core.util.RenderUtil,
          org.apache.sling.api.resource.ValueMap,
          com.adobe.granite.ui.components.ComponentHelper"%>
<sling:defineObjects/>
<%
final ComponentHelper cmp = new ComponentHelper(pageContext);
Config cfg = cmp.getConfig();
String path = cfg.get("templatePath", String.class);
boolean vote = RenderUtil.isTemplate(slingRequest, request, path);
request.setAttribute(RenderCondition.class.getName(), new SimpleRenderCondition(vote));
%>