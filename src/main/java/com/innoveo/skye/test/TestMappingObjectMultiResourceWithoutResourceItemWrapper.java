package com.innoveo.skye.test;

import javax.xml.bind.annotation.XmlSchemaType;
import java.util.ArrayList;
import java.util.List;

public class TestMappingObjectMultiResourceWithoutResourceItemWrapper {

    private MultiResourcesOnlyData multiResources;

    public MultiResourcesOnlyData getMultiResources() {
        return multiResources;
    }

    public void setMultiResources(MultiResourcesOnlyData multiResources) {
        this.multiResources = multiResources;
    }


    public static class MultiResourcesOnlyData {

        private List<byte[]> multiResource = new ArrayList<>();

        public List<byte[]> getMultiResource() {
            return multiResource;
        }

        public void setMultiResource(List<byte[]> multiResource) {
            this.multiResource = multiResource;
        }
    }

}
