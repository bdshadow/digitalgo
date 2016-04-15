package org.bdshadow.digitalgo.client;

import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import org.bdshadow.digitalgo.client.shared.AlgorithmRunnerService;

@Stateless
public class AlgorithmRunnerServiceImpl implements AlgorithmRunnerService {

	@Override
	public Response run(String param) {
		System.out.println("Running algo");
		return Response.ok(new Double(1 + Double.parseDouble(param))).build();
	}

}
