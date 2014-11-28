package org.pvytykac.structural.proxy;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author pvytykac
 * @since 28.11.2014 17:23
 *        <p/>
 *        Copyright (c) 2014 Blackboard Inc. and its subsidiary companies. All rights reserved.
 */
public class GitRepository implements Repository {

    private Long id;
    private String name;
    private Boolean isPrivate;
    private URL url;
    private String description;
    private Date updated;
    private List<String> branches = new ArrayList<>();

    private static final String host = "api.github.com";

    public GitRepository(String username, String repositoryName) throws IOException {
        String json = getJson(username, repositoryName);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readValue(json, JsonNode.class);

        this.id = node.get("id").getLongValue();
    }

    private static String getJson(String username, String repositoryName) throws IOException {
        URL url = new URL(host + "/" + username + "/" + repositoryName);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setDoOutput(false);
        connection.connect();

        StringBuilder json = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while((line = reader.readLine()) != null){
            json.append(line);
        }

        return json.toString();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public URL getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public Date getUpdated() {
        return updated;
    }

    @Override
    public Iterator<String> getBranches() {
        return branches.iterator();
    }
}
