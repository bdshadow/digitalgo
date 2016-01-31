package org.bdshadow.digitalgo.algos.face.detection;

import org.bdshadow.digitalgo.algos.IAlgorithm;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.RectVector;
import org.bytedeco.javacpp.opencv_core.Scalar;
import org.bytedeco.javacpp.opencv_core.Size;
import org.bytedeco.javacpp.opencv_imgcodecs;
import org.bytedeco.javacpp.opencv_imgproc;
import org.bytedeco.javacpp.opencv_objdetect;
import org.bytedeco.javacpp.opencv_objdetect.CascadeClassifier;

public class FaceDetectionAlgorithm implements IAlgorithm {

	private CascadeClassifier faceCascade = new CascadeClassifier();
	private int absoluteFaceSize;

	public String detectAndDisplay(String input) {
		Mat frame = opencv_imgcodecs.imread(input);
		
		faceCascade.load("C:/dev/jee/DigitAlgo/algos/src/main/resources/org/bdshadow/digitalgo/algos/face/detection/haarcascades/haarcascade_frontalface_alt.xml");
		RectVector faces = new RectVector();
		Mat grayFrame = new Mat();

		// convert the frame in gray scale
		opencv_imgproc.cvtColor(frame, grayFrame, opencv_imgproc.COLOR_BGR2GRAY);
		// equalize the frame histogram to improve the result
		opencv_imgproc.equalizeHist(grayFrame, grayFrame);

		// compute minimum face size (20% of the frame height, in our case)
		if (this.absoluteFaceSize == 0) {
			int height = grayFrame.rows();
			if (Math.round(height * 0.01f) > 0) {
				this.absoluteFaceSize = Math.round(height * 0.01f);
			}
		}

		// detect faces
		this.faceCascade.detectMultiScale(grayFrame, faces, 1.1, 2, 0 | opencv_objdetect.CASCADE_SCALE_IMAGE,
				new Size(this.absoluteFaceSize, this.absoluteFaceSize), new Size());

		// each rectangle in faces is a face: draw them!
		for (int i = 0; i < faces.size(); i++)
			opencv_imgproc.rectangle(frame, faces.get(i).tl(), faces.get(i).br(), new Scalar(0, 0, 255, 0));
		
		opencv_imgcodecs.imwrite("faces_output.jpg", frame);
		return "faces_output.jpg";
	}
	
	public static void main(String[] args) {
		new FaceDetectionAlgorithm().detectAndDisplay("C://dev//jee//DigitAlgo//algos//faces.jpg");
	}

	@Override
	public String run(String input) {
		return detectAndDisplay(input);
	}
}
