package org.pvytykac.behavioral.template_method;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class TemplateMethodTest {

    @Test
    public void templateMethodTest(){
        try {
            NewsFeed newsFeed = new SMEFeed();
            NewsResult result = newsFeed.getResult();

            System.out.println("SME");
            for(String header: result.getLiHeaders()){
                System.out.println(header);
            }
            assertFalse("test failed: the NewsResult list is empty", result.getLiHeaders().isEmpty());

            newsFeed = new PravdaFeed();
            result = newsFeed.getResult();

            System.out.println("PRAVDA");
            for(String header: result.getLiHeaders()){
                System.out.println(header);
            }
            assertFalse("test failed: the NewsResult list is empty", result.getLiHeaders().isEmpty());

        }catch(IOException ex){
            fail("test failed due to exception: " + ex.getMessage());
        }
    }

}
