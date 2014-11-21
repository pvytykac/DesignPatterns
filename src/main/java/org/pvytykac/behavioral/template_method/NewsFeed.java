package org.pvytykac.behavioral.template_method;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public abstract class NewsFeed {

    private URL url;
    private String method;

    public NewsFeed(String url, String method) throws IOException {
        this.url = new URL(url);
        this.method = method;
    }

    public NewsResult getResult() throws IOException {
        HttpURLConnection c = openConnection();
        c.connect();

        String request = getRequestBody();
        if(request != null && !request.trim().isEmpty())
            new BufferedWriter(new OutputStreamWriter(c.getOutputStream()))
                    .write(request);

        BufferedReader reader = new BufferedReader(new InputStreamReader(c.getInputStream()));

        String line;
        StringBuilder response = new StringBuilder();
        while((line = reader.readLine()) != null){
            response.append(line)
                    .append("\n");
        }

        return proccessResponse(response.toString());
    }

    protected final HttpURLConnection openConnection() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(method.equals("POST"));
        connection.setRequestMethod(method);

        return connection;
    }

    private final String getRequestBody(){
        Map<String, String> params = getRequestParams();
        if(params == null) return "";

        boolean first = true;
        StringBuilder request = new StringBuilder();

        for(String key: params.keySet()){
            if(first){
                request.append("&");
                first = false;
            }
                request.append(key)
                        .append("=")
                        .append(params.get(key));
        }

        return request.toString();
    }

    protected Map<String, String> getRequestParams(){
        return null;
    }

    protected abstract NewsResult proccessResponse(String response);

}
