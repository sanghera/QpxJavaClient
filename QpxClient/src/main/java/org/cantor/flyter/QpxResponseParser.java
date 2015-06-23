package org.cantor.flyter;



import org.cantor.flyter.model.response.QpxResponse;

import javax.ws.rs.core.Response;
import java.util.Collection;

public interface QpxResponseParser {

	Collection<QpxResponse> parseResponse(Response response);

}
