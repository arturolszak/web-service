package com.innoveo.skye.test;

import java.util.ArrayList;
import java.util.List;

public class TestMappingObjectMultiResource {

    private MultiResources multiResources;

    public MultiResources getMultiResources() {
        return multiResources;
    }

    public void setMultiResources(MultiResources multiResources) {
        this.multiResources = multiResources;
    }


    public static class MultiResources {
        private List<MultiResource> multiResource = new ArrayList<>();

        public List<MultiResource> getMultiResource() {
            return multiResource;
        }

        public void setMultiResource(List<MultiResource> multiResource) {
            this.multiResource = multiResource;
        }
    }

    public static class MultiResource {
        private byte[] data;
        private String filename;

        public MultiResource() {
        }

        public MultiResource(String filename, byte[] data) {
            this.filename = filename;
            this.data = data;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }
    }

}
