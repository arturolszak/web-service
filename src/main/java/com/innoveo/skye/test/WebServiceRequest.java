package com.innoveo.skye.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebServiceRequest", propOrder = {
        "customerList",
})
public class WebServiceRequest {

    @XmlElement(required = true)
    protected List<Customer> customerList;

    /**
     * Gets the value of the customerList property.
     *
     * @return
     *     possible object is
     *     {@link Customer }
     *
     */
    public List<Customer> getCustomerList() {
        return customerList;
    }

    /**
     * Sets the value of the customerList property.
     *
     * @param value
     *     allowed object is
     *     {@link Customer }
     *
     */
    public void setCustomerList(List<Customer> value) {
        this.customerList = value;
    }

}

