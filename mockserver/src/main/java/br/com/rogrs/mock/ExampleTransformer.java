package br.com.rogrs.mock;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

public class ExampleTransformer extends ResponseDefinitionTransformer {

	@Override
	public String getName() {
		return "example";
	}

	@Override
	public ResponseDefinition transform(Request arg0, ResponseDefinition arg1, FileSource arg2, Parameters arg3) {
		return new ResponseDefinitionBuilder().withHeader("MyHeader", "Transformed").withStatus(200)
				.withBody("Transformed body").build();
	}
}
