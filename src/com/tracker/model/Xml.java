//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.06.20 at 04:46:37 PM IST 
//


package com.tracker.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="response_code" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="pnr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="train_num" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="train_name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="doj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="from_station">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="to_station">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="reservation_upto">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="boarding_point">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="no_of_passengers" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="chart_prepared" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="passengers">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="passenger" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="sr" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="booking_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="current_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "responseCode",
    "pnr",
    "trainNum",
    "trainName",
    "doj",
    "fromStation",
    "toStation",
    "reservationUpto",
    "boardingPoint",
    "clazz",
    "noOfPassengers",
    "chartPrepared",
    "passengers",
    "error"
})
@XmlRootElement(name = "xml")
public class Xml {

    @XmlElement(name = "response_code")
    protected short responseCode;
    protected int pnr;
    @XmlElement(name = "train_num")
    protected short trainNum;
    @XmlElement(name = "train_name", required = true)
    protected String trainName;
    @XmlElement(required = true)
    protected String doj;
    @XmlElement(name = "from_station", required = true)
    protected Xml.FromStation fromStation;
    @XmlElement(name = "to_station", required = true)
    protected Xml.ToStation toStation;
    @XmlElement(name = "reservation_upto", required = true)
    protected Xml.ReservationUpto reservationUpto;
    @XmlElement(name = "boarding_point", required = true)
    protected Xml.BoardingPoint boardingPoint;
    @XmlElement(name = "class", required = true)
    protected String clazz;
    @XmlElement(name = "no_of_passengers")
    protected byte noOfPassengers;
    @XmlElement(name = "chart_prepared", required = true)
    protected String chartPrepared;
    @XmlElement(required = true)
    protected Xml.Passengers passengers;
    @XmlElement(required = true)
    protected String error;

    /**
     * Gets the value of the responseCode property.
     * 
     */
    public short getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     */
    public void setResponseCode(short value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the pnr property.
     * 
     */
    public int getPnr() {
        return pnr;
    }

    /**
     * Sets the value of the pnr property.
     * 
     */
    public void setPnr(int value) {
        this.pnr = value;
    }

    /**
     * Gets the value of the trainNum property.
     * 
     */
    public short getTrainNum() {
        return trainNum;
    }

    /**
     * Sets the value of the trainNum property.
     * 
     */
    public void setTrainNum(short value) {
        this.trainNum = value;
    }

    /**
     * Gets the value of the trainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrainName() {
        return trainName;
    }

    /**
     * Sets the value of the trainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrainName(String value) {
        this.trainName = value;
    }

    /**
     * Gets the value of the doj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoj() {
        return doj;
    }

    /**
     * Sets the value of the doj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoj(String value) {
        this.doj = value;
    }

    /**
     * Gets the value of the fromStation property.
     * 
     * @return
     *     possible object is
     *     {@link Xml.FromStation }
     *     
     */
    public Xml.FromStation getFromStation() {
        return fromStation;
    }

    /**
     * Sets the value of the fromStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Xml.FromStation }
     *     
     */
    public void setFromStation(Xml.FromStation value) {
        this.fromStation = value;
    }

    /**
     * Gets the value of the toStation property.
     * 
     * @return
     *     possible object is
     *     {@link Xml.ToStation }
     *     
     */
    public Xml.ToStation getToStation() {
        return toStation;
    }

    /**
     * Sets the value of the toStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Xml.ToStation }
     *     
     */
    public void setToStation(Xml.ToStation value) {
        this.toStation = value;
    }

    /**
     * Gets the value of the reservationUpto property.
     * 
     * @return
     *     possible object is
     *     {@link Xml.ReservationUpto }
     *     
     */
    public Xml.ReservationUpto getReservationUpto() {
        return reservationUpto;
    }

    /**
     * Sets the value of the reservationUpto property.
     * 
     * @param value
     *     allowed object is
     *     {@link Xml.ReservationUpto }
     *     
     */
    public void setReservationUpto(Xml.ReservationUpto value) {
        this.reservationUpto = value;
    }

    /**
     * Gets the value of the boardingPoint property.
     * 
     * @return
     *     possible object is
     *     {@link Xml.BoardingPoint }
     *     
     */
    public Xml.BoardingPoint getBoardingPoint() {
        return boardingPoint;
    }

    /**
     * Sets the value of the boardingPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Xml.BoardingPoint }
     *     
     */
    public void setBoardingPoint(Xml.BoardingPoint value) {
        this.boardingPoint = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the noOfPassengers property.
     * 
     */
    public byte getNoOfPassengers() {
        return noOfPassengers;
    }

    /**
     * Sets the value of the noOfPassengers property.
     * 
     */
    public void setNoOfPassengers(byte value) {
        this.noOfPassengers = value;
    }

    /**
     * Gets the value of the chartPrepared property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChartPrepared() {
        return chartPrepared;
    }

    /**
     * Sets the value of the chartPrepared property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChartPrepared(String value) {
        this.chartPrepared = value;
    }

    /**
     * Gets the value of the passengers property.
     * 
     * @return
     *     possible object is
     *     {@link Xml.Passengers }
     *     
     */
    public Xml.Passengers getPassengers() {
        return passengers;
    }

    /**
     * Sets the value of the passengers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Xml.Passengers }
     *     
     */
    public void setPassengers(Xml.Passengers value) {
        this.passengers = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setError(String value) {
        this.error = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "code",
        "name"
    })
    public static class BoardingPoint {

        @XmlElement(required = true)
        protected String code;
        @XmlElement(required = true)
        protected String name;

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "code",
        "name"
    })
    public static class FromStation {

        @XmlElement(required = true)
        protected String code;
        @XmlElement(required = true)
        protected String name;

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="passenger" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="sr" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="booking_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="current_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "passenger"
    })
    public static class Passengers {

        protected List<Xml.Passengers.Passenger> passenger;

        /**
         * Gets the value of the passenger property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the passenger property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPassenger().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Xml.Passengers.Passenger }
         * 
         * 
         */
        public List<Xml.Passengers.Passenger> getPassenger() {
            if (passenger == null) {
                passenger = new ArrayList<Xml.Passengers.Passenger>();
            }
            return this.passenger;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="sr" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="booking_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="current_status" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "sr",
            "bookingStatus",
            "currentStatus"
        })
        public static class Passenger {

            protected byte sr;
            @XmlElement(name = "booking_status", required = true)
            protected String bookingStatus;
            @XmlElement(name = "current_status", required = true)
            protected String currentStatus;

            /**
             * Gets the value of the sr property.
             * 
             */
            public byte getSr() {
                return sr;
            }

            /**
             * Sets the value of the sr property.
             * 
             */
            public void setSr(byte value) {
                this.sr = value;
            }

            /**
             * Gets the value of the bookingStatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBookingStatus() {
                return bookingStatus;
            }

            /**
             * Sets the value of the bookingStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBookingStatus(String value) {
                this.bookingStatus = value;
            }

            /**
             * Gets the value of the currentStatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCurrentStatus() {
                return currentStatus;
            }

            /**
             * Sets the value of the currentStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCurrentStatus(String value) {
                this.currentStatus = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "code",
        "name"
    })
    public static class ReservationUpto {

        @XmlElement(required = true)
        protected String code;
        @XmlElement(required = true)
        protected String name;

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "code",
        "name"
    })
    public static class ToStation {

        @XmlElement(required = true)
        protected String code;
        @XmlElement(required = true)
        protected String name;

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

    }

}