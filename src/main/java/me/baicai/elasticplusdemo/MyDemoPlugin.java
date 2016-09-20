package me.baicai.elasticplusdemo;

import java.util.Collection;
import java.util.Collections;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestModule;

public class MyDemoPlugin extends Plugin {
	final ESLogger logger = Loggers.getLogger(getClass());  
	private final Settings settings;

	public MyDemoPlugin(Settings settings) {
		this.settings = settings;
	}

	@Override
	public String description() {
		return "this is a demo by baicai";
	}

	@Override
	public String name() {
		return "myDemo";
	}
	
	public Collection<Module> createGuiceModules() {
		//创建自己的模块集合  
        //如果没有自定义模块，则可以返回空 
        return Collections.<Module>singletonList(new HelloModule());
    }

	public void onModule(Module module) {
		String isPluginEnabled = settings.get("bc.enabled");
//		logger.info("bc.enable="+isPluginEnabled);  
		if(module instanceof RestModule) {  
            ((RestModule)module).addRestAction(HelloWorldHandler.class);  
        } 
		if(module instanceof HelloModule) {
            logger.info("############## process hello module #####################");  
        }  
	}

}
