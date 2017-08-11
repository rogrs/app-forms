package br.com.rogrs.mock;

import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;

public class StubResponseTransformerWithParams extends ResponseTransformer {

	@Override
	public String getName() {
		 return "stub-transformer-with-params";
	}

	@Override
	public Response transform(Request request, Response response, FileSource files, Parameters parameters) {
		return Response.Builder.like(response)
                .but().body(parameters.getString("name") + ", "
                        + parameters.getInt("number") + ", "
                        + parameters.getBoolean("flag"))
                .build();
	}
}
