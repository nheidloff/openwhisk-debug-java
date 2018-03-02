package docker;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Function {

	@RequestMapping(value="/init", method=RequestMethod.POST)	
	public ResponseEntity<String> get() {
	    return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/run", method=RequestMethod.POST)	
	public ResponseEntity<OutputObject> get(@RequestBody InputBody inputBody) {
		InputObject inputObject = inputBody.getValue();
		
		OutputObject outputObject = new OutputObject();
		outputObject.setParam1("value param 1");
		outputObject.setParam2("value param 2");	   
		
		if ((inputObject != null) && (inputObject.getParameter1() != null) && (inputObject.getParameter2() != null)) {
			outputObject.setParam1("output param 1 " + inputObject.getParameter1());
			outputObject.setParam2("output param 2");
		}
		
		HttpHeaders responseHeaders = setHeaders(outputObject);
		return new ResponseEntity<OutputObject>(outputObject, responseHeaders, HttpStatus.OK);
	}
	
	private HttpHeaders setHeaders(OutputObject outputObject) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "application/json");
		
		// don't use this in production
		// this is a workaround since I didn't manage to convince Spring not to return "Transfer-Encoding: chunked"
		// see https://github.com/jthomas/ow/issues/2
		int outputObjectStringLength = 25 + outputObject.getParam1().length() + outputObject.getParam2().length();
		responseHeaders.set(HttpHeaders.CONTENT_LENGTH, new Integer(outputObjectStringLength).toString());
		
		return responseHeaders;
	}
}