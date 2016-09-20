package me.baicai.elasticplusdemo;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestChannel;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestRequest.Method;
import org.elasticsearch.rest.RestResponse;
import org.elasticsearch.rest.RestStatus;

public class HelloWorldHandler extends BaseRestHandler{
	final ESLogger logger = Loggers.getLogger(getClass());  
	
	@Inject
	public HelloWorldHandler(Settings settings, RestController controller, Client client) {
		super(settings, controller, client);
		//将该Handler绑定到某访问路径  
        controller.registerHandler(Method.GET, "/hello/", this);
        controller.registerHandler(Method.GET, "/hello/{name}", this);  
	}
	
	//处理绑定路径的请求访问 
	@Override
	public void handleRequest(RestRequest request, RestChannel channel, Client client) throws Exception {  	logger.debug("HelloWorldAction.handleRequest called");  
        final String name = request.hasParam("name") ? request.param("name") : "world";   
        String content = "{\"success\":true, \"message\":\"hello " +name+ "\"}";  
        RestResponse response = new BytesRestResponse(RestStatus.OK, BytesRestResponse.TEXT_CONTENT_TYPE, content);  
        channel.sendResponse(response);  
		
	}

}
