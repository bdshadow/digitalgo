package org.bdshadow.digitalgo;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.jpa.sync.client.local.ClientSyncManager;
import org.slf4j.Logger;

@EntryPoint
public class DigitAlgoGWTEntryPoint {
	
//	  @Inject
//	  private ClientSyncManager syncManager;
	  
	  @Inject
	  private Logger logger;

	  @PostConstruct
	  private void init() {
	    // This is specifying the relative path to the REST endpoint used to store
	    // complaints on the server. When compiling the native mobile app of this
	    // demo, this needs to be changed to an absolute URL.
	    RestClient.setApplicationRoot("rest");
	    // RestClient.setApplicationRoot("http://10.15.16.207:8080/errai-tutorial/rest");
	  }

}
