package org.bdshadow.digitalgo.algos.face.detection;

import org.bdshadow.digitalgo.algos.IAlgorithm;
import org.bdshadow.digitalgo.algos.AbstractAlgorithmBuilder;

public class FaceDetectionAlgorithmBuilder extends AbstractAlgorithmBuilder {

	@Override
	public IAlgorithm build() {
		return new FaceDetectionAlgorithm();
	}

}
