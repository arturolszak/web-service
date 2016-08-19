package com.innoveo.skye.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "testMappingObjectMultiResource",
        "testMappingObjectMultiResourceOutput",
})
@XmlRootElement(name = "webServiceRequest")
public class WebServiceRequest {

    @XmlElement(required = true)
    protected TestMappingObjectMultiResource testMappingObjectMultiResource;

    @XmlElement(required = true)
    protected TestMappingObjectMultiResource testMappingObjectMultiResourceOutput;

    public TestMappingObjectMultiResource getTestMappingObjectMultiResource() {
        return testMappingObjectMultiResource;
    }

    public void setTestMappingObjectMultiResource(TestMappingObjectMultiResource testMappingObjectMultiResource) {
        this.testMappingObjectMultiResource = testMappingObjectMultiResource;
    }

    public TestMappingObjectMultiResource getTestMappingObjectMultiResourceOutput() {
        return testMappingObjectMultiResourceOutput;
    }

    public void setTestMappingObjectMultiResourceOutput(TestMappingObjectMultiResource testMappingObjectMultiResourceOutput) {
        this.testMappingObjectMultiResourceOutput = testMappingObjectMultiResourceOutput;
    }


}

