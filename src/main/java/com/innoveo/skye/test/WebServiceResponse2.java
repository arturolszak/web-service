package com.innoveo.skye.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "testMappingObjectMultiResource"
})
@XmlRootElement(name = "webServiceResponse2")
public class WebServiceResponse2 {

    @XmlElement(required = true)
    protected TestMappingObjectMultiResourceWithoutResourceItemWrapper testMappingObjectMultiResource;

    public TestMappingObjectMultiResourceWithoutResourceItemWrapper getTestMappingObjectMultiResource() {
        return testMappingObjectMultiResource;
    }

    public void setTestMappingObjectMultiResource(TestMappingObjectMultiResourceWithoutResourceItemWrapper testMappingObjectMultiResource) {
        this.testMappingObjectMultiResource = testMappingObjectMultiResource;
    }

}

