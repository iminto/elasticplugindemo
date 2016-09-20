package me.baicai.elasticplusdemo;

import org.elasticsearch.common.inject.AbstractModule;

public class HelloModule extends AbstractModule {
	
    @Override
    protected void configure() {
    	bind(AwesomePluginService.class).asEagerSingleton();
    }

}
