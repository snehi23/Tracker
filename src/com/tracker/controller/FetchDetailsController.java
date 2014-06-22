package com.tracker.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import java.sql.SQLException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.ProtocolException;

import com.tracker.model.Details;
import com.tracker.model.FetchLatLong;
import com.tracker.model.Xml;
import com.tracker.util.DBConnectionManager;

public class FetchDetailsController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
		
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		Details d = new Details();
		
		String PNR = request.getParameter("PNR");
		
		System.out.println(PNR);
		
        ServletContext ctx=getServletContext();
        
        String connectionURL= ctx.getInitParameter("dbURL");
        String uname= ctx.getInitParameter("dbUser");
        String pwd= ctx.getInitParameter("dbPassword");
        
        try {
			DBConnectionManager dbconnmng = new DBConnectionManager(connectionURL, uname, pwd);
			
			ctx.setAttribute("DBConnection", dbconnmng.getConnection());
			
		} catch (ClassNotFoundException e1) {
			
		} catch (SQLException e1) {
			
		}
        
        try {
        	
        	if(session.getAttribute("userid")!=null) {
        	
        		String mykey = "297b39d2ad0b248dd6b475cc5161e43e";
        		String test = "xml"+"c7b4f14bb868093159dee41578945b7e"+PNR;
        		final StringBuilder builder = new StringBuilder();
        			
        		Mac mac = Mac.getInstance("HmacSHA1");
    			SecretKeySpec secret = new SecretKeySpec(mykey.getBytes(),
    					"HmacSHA1");
    			mac.init(secret);
    			byte[] digest = mac.doFinal(test.getBytes());
    			for (byte b : digest) {
    				builder.append(String.format("%02x", b));
    				System.out.format("%02x", b);
    			}
    			System.out.println();
    			System.out.println(getPnrResponse(PNR, "xml",builder.toString()));
    			
    			if(getPnrResponse(PNR, "xml",builder.toString()).contains("booking_status")) {

      			String Hmac = builder.toString();
    			
      			JAXBContext jc = JAXBContext.newInstance(Xml.class);	
      			String endpoint = "http://railpnrapi.com/api/check_pnr/pnr/"+PNR+"/format/"+"xml"+"/pbapikey/c7b4f14bb868093159dee41578945b7e/pbapisign/"+Hmac;	
      			Unmarshaller unmarshaller = jc.createUnmarshaller();
      			String temp =endpoint;
      			temp = temp.replaceAll(" ","%20").trim();
      			URL url = new URL(temp);
      			System.out.println(temp);
   	 
   	         
      			InputStream xmlStream = url.openStream();
      			Xml details = (Xml) unmarshaller.unmarshal(xmlStream);
   	      
   	      	
      			d.setTrain(details.getTrainName().trim());
      			d.setTrain_Number(String.valueOf(details.getTrainNum()).trim());
      			d.setDOJ(details.getDoj());
      			d.setFrom_Station(details.getFromStation().getName().trim());
      			d.setTo_Station(details.getToStation().getName().trim());
      			d.setClasses(details.getClazz().trim());
   	      	
      			int seat_number=1;
      			if(getPnrResponse(PNR, "xml",builder.toString()).contains("<current_status>CNF</current_status>")) {
      				System.out.println(details.getPassengers().getPassenger().get(0).getBookingStatus().split(",")[1]);
      				
      				if(details.getPassengers().getPassenger().get(0).getBookingStatus().split(",")[1].matches("[0-9]"))
      				{
      					seat_number = Integer.parseInt(details.getPassengers().getPassenger().get(0).getBookingStatus().split(",")[1]);
      				}
      			}
      			else if(getPnrResponse(PNR, "xml",builder.toString()).contains("<current_status>W/L")) {
      				
      			}
      			else {
      				if(details.getPassengers().getPassenger().get(0).getCurrentStatus().split(",")[1].matches("[0-9]"))
      				{
      					seat_number = Integer.parseInt(details.getPassengers().getPassenger().get(0).getCurrentStatus().split(",")[1]);
      				}
      			}
      			
      			
      			if(((seat_number%8))==1 || ((seat_number%8))==4)
      			d.setBerth("LB");
   	      	
      			if(((seat_number%8))==2 || ((seat_number%8))==5)
      			d.setBerth("MB");	
   	      	
      			if(((seat_number%8))==3 || ((seat_number%8))==6)
      			d.setBerth("UB");
   	      	
      			if(((seat_number%8))==7)
      			d.setBerth("SL");
   	      	
      			if(((seat_number%8))==8 || (seat_number%8)==0)
      			d.setBerth("SU");
   	      	
   	      	
      			System.out.println(details.getTrainName()+" "+details.getTrainNum()+" "+details.getDoj()+" "+details.getFromStation().getName()+" "+details.getToStation().getName()+" "+details.getClazz()+" "+details.getPassengers().getPassenger().get(0).getCurrentStatus());
   	      	
      			System.out.println(d.getTrain()+" "+d.getTrain_Number()+" "+d.getDOJ()+" "+d.getFrom_Station()+" "+d.getTo_Station()+" "+d.getClasses()+" "+d.getBerth());
   	      	
      			request.setAttribute("details", d);
      			request.setAttribute("Invalid PNR","");
   	      	
    			}
    			else if (getPnrResponse(PNR, "xml",builder.toString()).contains("<response_code>503</response_code>")) {
      				
      				request.setAttribute("Invalid PNR", "Server is down.");
      			}
        	else {
        		request.setAttribute("Invalid PNR", "Invalid PNR");
        	}
        	
        	rd = request.getRequestDispatcher("/success.jsp");
        	
        	} else {
        		
        		rd = request.getRequestDispatcher("/invalid-session.html");
        		
        	}
        } 
        catch(Exception E1)
        {
        	System.out.println(E1.getMessage());
        } 
      
        rd.forward(request, response);

	}
	
	public static String getPnrResponse(String pnr, String format, String Hmac) {
        if(pnr == null || pnr.trim().length() != 10){
            //Some more validations like only numeric are used etc can be added.
            return "Invalid PNR.";
        }

        format = format == null || format.trim().equals("") ? "xml" : format;
        //More validations can be added like format is one of xml or json.
        String endpoint = "http://railpnrapi.com/api/check_pnr/pnr/"+pnr+"/format/"+format+"/pbapikey/c7b4f14bb868093159dee41578945b7e/pbapisign/"+Hmac;

        HttpURLConnection request = null;
        BufferedReader rd = null;
        StringBuilder response = null;

        try{
            URL endpointUrl = new URL(endpoint);
            request = (HttpURLConnection)endpointUrl.openConnection();
            request.setRequestMethod("GET");
            request.connect();

            rd  = new BufferedReader(new InputStreamReader(request.getInputStream()));
            response = new StringBuilder();
            String line = null;
            while ((line = rd.readLine()) != null){
                response.append(line + "\n");
            }
        } catch (MalformedURLException e) {
            System.out.println("Exception: " + e.getMessage());
            //e.printStackTrace();
        } catch (ProtocolException e) {
            System.out.println("Exception: " + e.getMessage());
            //e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
            //e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            //e.printStackTrace();
        } finally {
            try{
                request.disconnect();
            } catch(Exception e){
}

            if(rd != null){
                try{
                    rd.close();
                } catch(IOException ex){
}
                rd = null;
            }
        }

        return response != null ? response.toString() : "No Response";
    }

	
}
