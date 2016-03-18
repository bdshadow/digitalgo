package org.bdshadow.digitalgo.client;

import javax.annotation.PostConstruct;

import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;

import gwtupload.client.IFileInput;
import gwtupload.client.IFileInput.FileInputType;
import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.UploadedInfo;
import gwtupload.client.MultiUploader;
import gwtupload.client.PreloadedImage;
import gwtupload.client.PreloadedImage.OnLoadPreloadedImageHandler;

@Page(path = "algorithm", role = DefaultPage.class)
@Templated("templates/algorithm.html#algodiv")
public class AlgorithmPage extends Composite {
	
	@DataField
	private FlowPanel panelImages = new FlowPanel();
	
	@DataField
	private MultiUploader uploader;
	{
		Button uploadButton = new Button();
		uploadButton.setStyleName("btn btn-default");
		uploadButton.setHTML("<i class=\"fa fa-plus fa-5x\"></i>");
		uploader = new MultiUploader(FileInputType.CUSTOM.with(uploadButton, false));
		uploader.getFileInput().asWidget().setTitle("");
	}

	@PostConstruct	
	public final void init() {
		
		uploader.setEnabled(true);
		uploader.addOnFinishUploadHandler(onFinishUploaderHandler);
	}

	private IUploader.OnFinishUploaderHandler onFinishUploaderHandler = new IUploader.OnFinishUploaderHandler() {
		public void onFinish(IUploader uploader) {
			if (uploader.getStatus() == Status.SUCCESS) {

				new PreloadedImage(uploader.fileUrl(), showImage);

				// The server sends useful information to the client by default
				UploadedInfo info = uploader.getServerInfo();
				System.out.println("File name " + info.name);
				System.out.println("File content-type " + info.ctype);
				System.out.println("File size " + info.size);

				// Also, you can send any customized message and parse it
				System.out.println("Server message " + info.message);
			}
		}
	};

	// Attach an image to the pictures viewer
	private OnLoadPreloadedImageHandler showImage = new OnLoadPreloadedImageHandler() {
		public void onLoad(PreloadedImage image) {
			image.setWidth("75px");
			panelImages.add(image);
		}
	};

}
