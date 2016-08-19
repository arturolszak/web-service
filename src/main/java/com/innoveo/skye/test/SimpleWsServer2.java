package com.innoveo.skye.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import static javax.jws.soap.SOAPBinding.Style.DOCUMENT;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

public class SimpleWsServer2 {

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
        public @WebResult(name = "webServiceResponse2")
        WebServiceResponse2 launch(@WebParam(name = "webServiceRequest2") WebServiceRequest2 webServiceRequest) {
            System.out.println("REQUEST: Received launch request.");
            invocationCount++;

            WebServiceResponse2 launchResponse = processRequestAndCreateResponse(webServiceRequest);

            return launchResponse;
        }

        private WebServiceResponse2 processRequestAndCreateResponse(WebServiceRequest2 request) {

            //process request
            List<byte[]> multiResource = request.getTestMappingObjectMultiResource().getMultiResources().getMultiResource();
            for (Object resource : multiResource) {
                if (resource instanceof byte[]) {
                    String data = Base64.getEncoder().encodeToString(((byte[]) resource));
                    data = (data.length() <= 50 ? data : data.substring(0, 50) + "...");
                    System.out.println("* Received a resource (only data): "  + data);
                } else {
                    throw new AssertionError("The resource is not a byte array");
                }
            }

            //generate response
            WebServiceResponse2 webServiceResponse = new WebServiceResponse2();

            TestMappingObjectMultiResourceWithoutResourceItemWrapper testMappingObjectMultiResource = new TestMappingObjectMultiResourceWithoutResourceItemWrapper();
            webServiceResponse.setTestMappingObjectMultiResource(testMappingObjectMultiResource);

            TestMappingObjectMultiResourceWithoutResourceItemWrapper.MultiResourcesOnlyData multiResources = new TestMappingObjectMultiResourceWithoutResourceItemWrapper.MultiResourcesOnlyData();
            testMappingObjectMultiResource.setMultiResources(multiResources);

            for (Object resource : request.getTestMappingObjectMultiResourceOutput().getMultiResources().getMultiResource()) {
                if (resource instanceof byte[]) {
                    byte[] resourceData = (byte[]) resource;
                    testMappingObjectMultiResource.getMultiResources().getMultiResource().add(Arrays.copyOf(resourceData, resourceData.length));
                    String data = Base64.getEncoder().encodeToString(resourceData);
                    data = (data.length() <= 50 ? data : data.substring(0, 50) + "...");
                    System.out.println("+ Adding a resource to the response (only data): " + data);
                } else {
                    throw new AssertionError("The resource is not a byte array");
                }
            }

            return webServiceResponse;
        }

    }
}
