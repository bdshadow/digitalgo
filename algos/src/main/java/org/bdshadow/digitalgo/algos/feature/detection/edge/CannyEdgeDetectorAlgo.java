package org.bdshadow.digitalgo.algos.feature.detection.edge;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bdshadow.digitalgo.algos.IAlgorithm;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.FImage;
import org.openimaj.image.Image;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.processing.edges.CannyEdgeDetector;

public class CannyEdgeDetectorAlgo implements IAlgorithm {
	
	private MBFImage sourceImage;
	
	private FImage result;
	
	public CannyEdgeDetectorAlgo(MBFImage sourceImage) {
		this.sourceImage = sourceImage;
	}
	
	@Override
	public void run() {
		CannyEdgeDetector canny = new CannyEdgeDetector();
		this.result = this.sourceImage.flatten();
		canny.processImage(this.result);
	}

	public static void main(String[] args) throws IOException {
		MBFImage image = ImageUtilities.readMBF(new File("C:/Users/DBocharov/Desktop/AFPGetty-538296838.jpg"));
		FImage fimage = image.flatten();
		
		CannyEdgeDetector canny = new CannyEdgeDetector();
		canny.processImage(fimage);
		DisplayUtilities.display(fimage);

	}
	
	public FImage getResult() {
		return this.result;
	}

}
