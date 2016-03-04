package org.bdshadow.digitalgo.algos.feature.detection.edge;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.FImage;
import org.openimaj.image.Image;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.processing.edges.CannyEdgeDetector;

public class CannyEdgeDetectorAlgo {
	
	private Image sourceImage;
	
	private List<Image> result;
	
	public CannyEdgeDetectorAlgo(Image sourceImage) {
		this.sourceImage = sourceImage;
	}
	
	public void run() {
		
	}

	public static void main(String[] args) throws IOException {
		MBFImage image = ImageUtilities.readMBF(new File("C:/Users/DBocharov/Desktop/AFPGetty-538296838.jpg"));
		FImage fimage = image.flatten();
		
		CannyEdgeDetector canny = new CannyEdgeDetector();
		canny.processImage(fimage);
		DisplayUtilities.display(fimage);

	}

}
