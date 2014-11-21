package org.pvytykac.behavioral.template_method;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PravdaFeed extends NewsFeed {

    private Pattern mostReadRegex = Pattern.compile("<span\\sclass=\"order\">\\d+</span><a\\shref=\".+?\">(.+?)</a>");

    public PravdaFeed() throws IOException {
        super("http://www.pravda.sk/", "GET");
    }

    @Override
    protected NewsResult proccessResponse(String response) {
        NewsResult result = new NewsResult();
        Matcher matcher = mostReadRegex.matcher(response);
        while(matcher.find()){
            result.getLiHeaders().add(matcher.group(1));
        }

        return result;
    }
}
