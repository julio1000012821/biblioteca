/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.standard.biblioteca.config;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.primefaces.shaded.json.JSONObject;

/**
 *
 * @author juliosilva
 */
public class Api {
    
    public static Reader reader;
    
    public static Gson getGson(String url) throws MalformedURLException, ProtocolException, IOException{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        
        //Map<String, String> parameters = new HashMap<>();
        con.setDoOutput(true);
        
        int code = con.getResponseCode();
        if (code == 200) {
          Gson gson = new Gson();
          Api.reader = new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8);
          return gson;
        }
        else
        {
            System.out.println("Não foi possivel ter acesso a informação " + code);
            //MessageUtil.Erro("Erro de Login", "Os dados estão incorretos, ou não tem acesso a aplicação !!!" + code);  
        }
        
        return null;
    
    }
    
    public static int Delete(String url) throws MalformedURLException, ProtocolException, IOException{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("DELETE");
        con.setRequestProperty("Content-Type", "application/json");
        //con.setRequestProperty("Accept", "application/json");
        
        //Map<String, String> parameters = new HashMap<>();
        con.setDoOutput(true);
        
        return con.getResponseCode();
    }
    
    public static int export(String url) throws MalformedURLException, ProtocolException, IOException{
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/octet-stream");
        con.setRequestProperty("Accept", "application/octet-stream");
        
        //Map<String, String> parameters = new HashMap<>();
        con.setDoOutput(true);
        
        return con.getResponseCode();
    }
    
    
    public static void post(JSONObject json, String url) throws UnsupportedEncodingException{
        
        StringEntity entity = new StringEntity(json.toString());
        
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpPost request = new HttpPost(url);
            request.setEntity(entity);
            request.setHeader("Content-Type","application/json");
            
            HttpResponse response = (HttpResponse) httpClient.execute(request);
            System.out.println(response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
