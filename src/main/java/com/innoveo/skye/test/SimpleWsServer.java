package com.innoveo.skye.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Base64;
import java.util.List;

import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

public class SimpleWsServer {

    public static void main(String[] args) {
        System.out.println("Publishing service");
        String url = "http://localhost:12345/test/DynamicWebService";
        Endpoint.publish(url, new DynamicClientModelWebServiceEndpoint());
        System.out.println("Service published under '" + url + "'");
        System.out.println("Waiting for requests...");
    }

    @WebService(targetNamespace = "http://www.innoveo.com/recursosmultiples")
    @SOAPBinding(style = DOCUMENT, use = LITERAL, parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public static class DynamicClientModelWebServiceEndpoint {
        public static int invocationCount = 0;

        public DynamicClientModelWebServiceEndpoint() {
            invocationCount = 0;
        }

        @WebMethod(operationName = "launch", action = "launch")
        public @WebResult(name = "webServiceResponse")
        WebServiceResponse launch(@WebParam(name = "webServiceRequest") WebServiceRequest webServiceRequest) {
            System.out.println("REQUEST: Received launch request.");
            invocationCount++;

            WebServiceResponse launchResponse = processRequestAndCreateResponse(webServiceRequest);

            return launchResponse;
        }

        private WebServiceResponse processRequestAndCreateResponse(WebServiceRequest request) {

            //process request
            List<TestMappingObjectMultiResource.MultiResource> multiResource = request.getTestMappingObjectMultiResource().getMultiResources().getMultiResource();
            for (TestMappingObjectMultiResource.MultiResource resource : multiResource) {
                String data = Base64.getEncoder().encodeToString(resource.getData());
                data = (data.length() <= 50 ? data : data.substring(0, 50) + "...");
                System.out.println("* Received a resource: "  + resource.getFilename() + "; " + data);
            }

            //generate response
            WebServiceResponse webServiceResponse = new WebServiceResponse();

            TestMappingObjectMultiResource testMappingObjectMultiResource = new TestMappingObjectMultiResource();
            webServiceResponse.setTestMappingObjectMultiResource(testMappingObjectMultiResource);

            TestMappingObjectMultiResource.MultiResources multiResources = new TestMappingObjectMultiResource.MultiResources();
            testMappingObjectMultiResource.setMultiResources(multiResources);

            for (TestMappingObjectMultiResource.MultiResource resource : request.getTestMappingObjectMultiResourceOutput().getMultiResources().getMultiResource()) {
                multiResources.getMultiResource().add(new TestMappingObjectMultiResource.MultiResource(resource.getFilename(), resource.getData()));
                String data = Base64.getEncoder().encodeToString(resource.getData());
                data = (data.length() <= 50 ? data : data.substring(0, 50) + "...");
                System.out.println("+ Adding a resource to the response: "  + resource.getFilename() + "; " + data);
            }

            return webServiceResponse;
        }

    }
}
