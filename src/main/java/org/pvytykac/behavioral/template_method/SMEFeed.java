package org.pvytykac.behavioral.template_method;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SMEFeed extends NewsFeed {

    private static final Pattern regexp = Pattern.compile("<a\\shref=\".+?\"\\s*class=\"mainHeadline\"\\s*onclick=\".+?\">(.+?)</a>");

    public SMEFeed() throws IOException {
        super("http://www.sme.sk/", "GET");
    }

    @Override
    protected NewsResult proccessResponse(String response) {
        NewsResult result = new NewsResult();
        Matcher matcher = regexp.matcher(response);
        while(matcher.find()){
            result.getLiHeaders().add(matcher.group(1));
        }

        return result;
    }
}

