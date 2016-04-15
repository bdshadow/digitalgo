package org.bdshadow.digitalgo.client.algos.feature.detection.edge;

import javax.inject.Inject;

import org.bdshadow.digitalgo.client.shared.AlgorithmRunnerService;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.enterprise.client.jaxrs.api.ResponseCallback;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;

@Templated("CannyEdgeDetectorAlgoTemplate.html#algodiv")
public class CannyEdgeDetectorAlgoTemplate extends Composite {
	
	private boolean loaded = false;
	
	@Inject
	private Caller<AlgorithmRunnerService> algoService; 
	
	@Inject
	@DataField
	private Image inputImage;

	@Inject
	@DataField
	private TextBox lowThresh;
	
	@Inject
	@DataField
	private TextBox highThresh;
	
	@Inject
	@DataField
	private TextBox sigma;
	
	@Inject
	@DataField
	private TextBox result;
	
	@EventHandler("lowThresh")
	public void runAlgo(ChangeEvent changeEvent) {
		algoService.call((ResponseCallback) response -> {
			result.setValue("blabla");
		}).run(lowThresh.getValue());
	}
	
	@Override
	protected void onLoad() {
		if (loaded) return;
		ScriptInjector.fromUrl("https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js").setCallback(new Callback<Void, Exception>() {
			
			@Override
			public void onSuccess(Void result) {
				ScriptInjector.fromUrl("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js").setCallback(new Callback<Void, Exception>() {

					@Override
					public void onFailure(Exception reason) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Void result) {
						ScriptInjector.fromUrl("https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/6.1.7/bootstrap-slider.js").setWindow(ScriptInjector.TOP_WINDOW).inject();
						
					}
				}).setWindow(ScriptInjector.TOP_WINDOW).inject();
			}
			
			@Override
			public void onFailure(Exception reason) {
				// TODO Auto-generated method stub
				
			}
		}).setWindow(ScriptInjector.TOP_WINDOW).inject();
		loaded = true;
	}
}
