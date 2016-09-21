package me.baicai.elasticplusdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.elasticsearch.common.component.LifecycleComponent;
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
	
	/**
	 * 插件的简单描述
	 */
	@Override
	public String description() {
		return "this is a demo by baicai";
	}
	
	/**
	 * 插件的名字，区分大小写，放到plugins文件夹要注意了
	 */
	@Override
	public String name() {
		return "myDemo";
	}
	
	/**
	 * 节点级别的模块，也可以是index级别
	 */
	@Override
	public Collection<Module> nodeModules() {
		// 创建自己的模块集合
		// 如果没有自定义模块，则可以返回空
		// if (settings.getAsBoolean("bc.enabled", true)) {
		return Collections.<Module> singletonList(new HelloModule());
		// }
	}

	@Override
	public Collection<Class<? extends LifecycleComponent>> nodeServices() {
		Collection<Class<? extends LifecycleComponent>> services = new ArrayList();
		services.add(AwesomePluginService.class);
		return services;
	}
	
	/**
	 * 所有模块初始化的时候会调用这里
	 * @param module
	 */
	public void onModule(Module module) {
		String isPluginEnabled = settings.get("bc.enabled");
		// logger.info("bc.enable="+isPluginEnabled);
		if (module instanceof RestModule) {
			((RestModule) module).addRestAction(HelloWorldHandler.class);
		}
		if (module instanceof HelloModule) {
			logger.info("############## process hello module #####################");
		}
	}

}
