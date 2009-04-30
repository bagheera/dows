
package org.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for review complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="review">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reviewer" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reviewText" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "review", propOrder = {
    "reviewer",
    "reviewText",
    "rating"
})
public class Review {

    @XmlElement(required = true)
    protected String reviewer;
    @XmlElement(required = true)
    protected String reviewText;
    @XmlElement(required = true)
    protected String rating;

    /**
     * Gets the value of the reviewer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * Sets the value of the reviewer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewer(String value) {
        this.reviewer = value;
    }

    /**
     * Gets the value of the reviewText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewText() {
        return reviewText;
    }

    /**
     * Sets the value of the reviewText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewText(String value) {
        this.reviewText = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRating(String value) {
        this.rating = value;
    }

}
