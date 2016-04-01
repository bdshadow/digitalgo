package org.bdshadow.digitalgo.algos.feature.detection.edge;

import javax.inject.Inject;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextArea;

@Templated
public class CannyEdgeDetectorAlgoTemplate extends Composite {
	
	@Inject
	@DataField
	private Image inputImage;

	@Inject
	@DataField
	private TextArea lowThresh;
	
	@Inject
	@DataField
	private TextArea highThresh;
	
	@Inject
	@DataField
	private TextArea sigma;
	
	@EventHandler("lowThresh")
	public void runAlgo(ChangeEvent changeEvent) {
		//CannyEdgeDetectorAlgo algo = new CannyEdgeDetectorAlgo()
	}
}
