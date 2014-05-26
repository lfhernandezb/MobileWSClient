package com.androidexample.restfulwebservice;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import cl.dsoft.carws.mobile.model.CarData;
import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RestFulWebservice extends Activity {

	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
     
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.rest_ful_webservice);  
        
        final Button GetServerData = (Button) findViewById(R.id.GetServerData);
        
        final Button PutServerData = (Button) findViewById(R.id.PutServerData);
        
        final TextView uiUpdate = (TextView) findViewById(R.id.output);
        final TextView jsonParsed = (TextView) findViewById(R.id.jsonParsed);
        
        final EditText serverText = (EditText) findViewById(R.id.serverText);
        
        try {
        	String path = getApplicationContext().getFilesDir().getAbsolutePath() + "/";
    		String fileName = "car.db3";
    		File dataFile = new File(path + fileName);
    		
    		if (!dataFile.exists()) {
			    copyDataBaseFile();
    		}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (CarException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
                 
        GetServerData.setOnClickListener(new OnClickListener() {
            
			@Override
			public void onClick(View arg0) {
				/*
				// utilizando AsyncTask
				// WebServer Request URL
				String serverURL = "http://192.168.1.110:8080/cl.dsoft.carws/rest/todo/byIdUsuario/1/1900-01-01";
				
				// Use AsyncTask execute Method To Prevent ANR Problem
		        new RequestTask().execute(serverURL);
		        */
		        HttpClient httpClient;
		        HttpResponse response;
		        String responseString = null;
		        Connection conn = null;
		        
		        String serverURL = "http://ptt-studio.bounceme.net:8080/cl.dsoft.carws/rest/todo/byIdUsuario/";
		        
		        try {
		        	int timeoutConnection;
		        	int timeoutSocket;
		        	HttpGet getRequest;
		        	StatusLine statusLine;
		        	
		        	
		            HttpParams httpParameters = new BasicHttpParams();
		            
		            timeoutConnection = 3000;
		            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
		            timeoutSocket = 5000;
		            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
		            httpClient = new DefaultHttpClient(httpParameters);
		            getRequest = new HttpGet(serverURL + serverText.getText());
		            getRequest.addHeader("accept", "application/xml");      	
		        	
		        	response = httpClient.execute(getRequest);
		            statusLine = response.getStatusLine();
		            
		            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
		            	
		            	Serializer serializer;
		            	CarData carData;
		            	String url;
		            	
		                ByteArrayOutputStream out = new ByteArrayOutputStream();
		                response.getEntity().writeTo(out);
		                out.close();
		                responseString = out.toString();
		                
		                uiUpdate.setText(responseString);
		                
		                serializer = new Persister();
		                
		                
	        			carData = serializer.read(CarData.class, responseString);
	        			
	        			jsonParsed.setText(carData.getUsuarios().toString());
	        			
	        			//System.out.println(carData.getUsuarios());
	        			
	        			copyDataBaseFile();
	        			
	        			url = "jdbc:sqldroid:" + getApplicationContext().getFilesDir().getAbsolutePath() + "/car.db3";
	        			
	        			conn = new org.sqldroid.SQLDroidDriver().connect(url , new Properties());
	        			
	        	    	conn.setAutoCommit(false);
		        	    	
		        	    carData.save(conn);
		        	    
		        	    conn.commit();
		        	    	
		        		conn.close();
		        		
		        		conn = null;
		                
		            } else{
		                //Closes the connection.
		                response.getEntity().getContent().close();
		                throw new IOException(statusLine.getReasonPhrase());
		            }
		        } catch (ClientProtocolException e) {
		            //TODO Handle problems..
		        	e.printStackTrace();
		        } catch (IOException e) {
		            //TODO Handle problems..
		        	e.printStackTrace();
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CarException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        finally {
		        	if (conn != null) {
		        		try {
		        			conn.rollback();
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        }
			}
        });    
         
        PutServerData.setOnClickListener(new OnClickListener() {
            
			@Override
			public void onClick(View arg0) {
				/*
				// utilizando AsyncTask
				// WebServer Request URL
				String serverURL = "http://192.168.1.110:8080/cl.dsoft.carws/rest/todo/byIdUsuario/1/1900-01-01";
				
				// Use AsyncTask execute Method To Prevent ANR Problem
		        new RequestTask().execute(serverURL);
		        */
		        HttpClient httpClient;
		        HttpResponse response;
		        String responseString = null;
		        Connection conn = null;
		        
		        String serverURL = "http://ptt-studio.bounceme.net:8080/cl.dsoft.carws/rest/todo/receive";
		        
		        try {
		        	int timeoutConnection;
		        	int timeoutSocket;
		        	HttpPut putRequest;
		        	StatusLine statusLine;
		        	CarData carData;
		        	Serializer serializer;
		        	StringWriter stringWriter;
		        	StringEntity entity;
		        	
		        	long idUsuario;
		        	String fechaModificacion, url;
		        	
		        	idUsuario = 1L;
		        	fechaModificacion = "1900-01-01";

		        	HttpParams httpParameters = new BasicHttpParams();
		            timeoutConnection = 3000;
		            HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
		            timeoutSocket = 5000;
		            HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
		            httpClient = new DefaultHttpClient(httpParameters);
		            putRequest = new HttpPut(serverURL);
		            putRequest.addHeader("content-type", "application/xml");
		            
        			url = "jdbc:sqldroid:" + getApplicationContext().getFilesDir().getAbsolutePath() + "/car.db3";
        			
        			conn = new org.sqldroid.SQLDroidDriver().connect(url , new Properties());
        			
        	    	// conn.setAutoCommit(false);
        			
        			carData = new CarData(conn, idUsuario, fechaModificacion);
	        	    
	        	    // conn.commit();
	        	    	
	        		conn.close();
	        		
	        		conn = null;
		            
		            serializer = new Persister();
		            
		            stringWriter = new StringWriter();
		            
		            serializer.write(carData, stringWriter);
		            
		            entity = new StringEntity("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\" ?>" + stringWriter.toString(), HTTP.UTF_8);
		            putRequest.setEntity(entity);
		        	
		        	response = httpClient.execute(putRequest);
		            statusLine = response.getStatusLine();
		            
		            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
		            	
		            	System.out.println("post ok");
		                
		            } else{
		                //Closes the connection.
		                
		                throw new IOException(statusLine.getReasonPhrase());
		            }
		        } catch (ClientProtocolException e) {
		            //TODO Handle problems..
		        	e.printStackTrace();
		        } catch (IOException e) {
		            //TODO Handle problems..
		        	e.printStackTrace();
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CarException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        finally {
		        	if (conn != null) {
		        		try {
		        			//conn.rollback();
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}
		        }
			}
        });    
    }
    
	private void copyDataBaseFile() throws CarException, FileNotFoundException, IOException {
		String path = getApplicationContext().getFilesDir().getAbsolutePath() + "/";
		String fileName = "car.db3";
		File outputFile = new File(path + fileName);
			    
        InputStream IS = getApplicationContext().getAssets().open(fileName);
        OutputStream OS = new FileOutputStream(outputFile);
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = IS.read(buffer))>0){
            OS.write(buffer, 0, length);
        }
        OS.flush();
        OS.close();
        IS.close();
	}

     
}
