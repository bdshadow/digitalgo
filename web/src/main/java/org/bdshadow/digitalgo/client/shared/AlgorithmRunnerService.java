package org.bdshadow.digitalgo.client.shared;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/runalgo")
public interface AlgorithmRunnerService {

	@POST
	@Consumes("application/json")
	Response run(String param);
}
