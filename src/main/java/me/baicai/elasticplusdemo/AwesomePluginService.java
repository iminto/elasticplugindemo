package me.baicai.elasticplusdemo;

import org.elasticsearch.common.component.AbstractLifecycleComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;

public class AwesomePluginService extends AbstractLifecycleComponent<AwesomePluginService>{
	
	@Inject
	public AwesomePluginService(Settings settings) {
		super(settings);
	}

	@Override
	@Inject
	public void doClose() {
		logger.info("##############AwesomePluginService  doclose()#####################");
	}

	@Override
	@Inject
	public void doStart() {
		 logger.info("##############AwesomePluginService  doStart()#####################");  
	}

	@Override
	protected void doStop() {
		logger.info("##############AwesomePluginService  doStop()#####################");
	}

}
