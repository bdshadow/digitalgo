package org.bdshadow.digitalgo.algos.feature.detection.edge;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;

public class CannyEdgeDetectorAlgoTest {

	@Test
	public void testCannyEdgeDetectorAlgo() throws IOException {
		MBFImage image = ImageUtilities.readMBF(new File("images\\lenna.jpg"));
		CannyEdgeDetectorAlgo algo = new CannyEdgeDetectorAlgo(image);
		algo.getResult();
	}

}
