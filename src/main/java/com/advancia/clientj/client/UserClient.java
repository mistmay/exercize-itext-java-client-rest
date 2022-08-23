package com.advancia.clientj.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.advancia.clientj.model.User;
import com.advancia.clientj.payload.response.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
public class UserClient {
	public static List<User> getList() {
		List<User> users = new ArrayList<>();
		try {
			try (DefaultHttpClient httpClient = new DefaultHttpClient()) {
				HttpGet getRequest = new HttpGet("http://localhost:8080/clientj/rest/users");
				HttpResponse response = httpClient.execute(getRequest);
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException(
							"Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
				}
				HttpEntity httpEntity = response.getEntity();
				String apiOutput = EntityUtils.toString(httpEntity);
				ObjectMapper mapper = new ObjectMapper();
				UserResponse userResponse = mapper.readValue(apiOutput, UserResponse.class);
				users = userResponse.getUsers();
				httpClient.getConnectionManager().shutdown();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}
}
