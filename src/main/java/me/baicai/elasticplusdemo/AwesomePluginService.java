package me.baicai.elasticplusdemo;

import org.elasticsearch.common.component.AbstractLifecycleComponent;
import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.elasticsearch.common.settings.Settings;

public class AwesomePluginService extends AbstractLifecycleComponent<AwesomePluginService>{
	
	private  ESLogger logger = Loggers.getLogger(getClass()); 
	protected AwesomePluginService(Settings settings) {
		super(settings);
	}

	@Override
	protected void doClose() {
		
	}

	@Override
	protected void doStart() {
		 logger.info("##############AwesomePluginService  doStart()#####################");  
	}

	@Override
	protected void doStop() {
	}

	public ESLogger getLogger() {
		return logger;
	}

	public void setLogger(ESLogger logger) {
		this.logger = logger;
	}

}
