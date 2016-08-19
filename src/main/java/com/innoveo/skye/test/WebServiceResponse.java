package com.innoveo.skye.test;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "testMappingObjectMultiResource"
})
@XmlRootElement(name = "webServiceResponse")
public class WebServiceResponse {

    @XmlElement(required = true)
    protected TestMappingObjectMultiResource testMappingObjectMultiResource;

    public TestMappingObjectMultiResource getTestMappingObjectMultiResource() {
        return testMappingObjectMultiResource;
    }

    public void setTestMappingObjectMultiResource(TestMappingObjectMultiResource testMappingObjectMultiResource) {
        this.testMappingObjectMultiResource = testMappingObjectMultiResource;
    }

}

