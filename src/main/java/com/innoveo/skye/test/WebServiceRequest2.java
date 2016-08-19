package com.innoveo.skye.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "testMappingObjectMultiResource",
        "testMappingObjectMultiResourceOutput",
})
@XmlRootElement(name = "webServiceRequest2")
public class WebServiceRequest2 {

    @XmlElement(required = true)
    protected TestMappingObjectMultiResourceWithoutResourceItemWrapper testMappingObjectMultiResource;

    @XmlElement(required = true)
    protected TestMappingObjectMultiResourceWithoutResourceItemWrapper testMappingObjectMultiResourceOutput;

    public TestMappingObjectMultiResourceWithoutResourceItemWrapper getTestMappingObjectMultiResource() {
        return testMappingObjectMultiResource;
    }

    public void setTestMappingObjectMultiResource(TestMappingObjectMultiResourceWithoutResourceItemWrapper testMappingObjectMultiResource) {
        this.testMappingObjectMultiResource = testMappingObjectMultiResource;
    }

    public TestMappingObjectMultiResourceWithoutResourceItemWrapper getTestMappingObjectMultiResourceOutput() {
        return testMappingObjectMultiResourceOutput;
    }

    public void setTestMappingObjectMultiResourceOutput(TestMappingObjectMultiResourceWithoutResourceItemWrapper testMappingObjectMultiResourceOutput) {
        this.testMappingObjectMultiResourceOutput = testMappingObjectMultiResourceOutput;
    }


}

