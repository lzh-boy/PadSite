package com.pad.blog.dao;

import com.pad.blog.entity.Blog;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Repository;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by pad on 17-9-29.
 */
@Repository
public class BlogDao {

    public List<Blog> list(Blog model) throws UnknownHostException {
        Settings settings= Settings.builder().put("cluster.name","elasticsearch").build();
        TransportClient client=new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"),9300));


//        IndexResponse response=client.prepareIndex("twitter","tweet","1")
//                .setSource(
//                        jsonBuilder().startObject()
//                                .field("user","  kimchy")
//                                .field("postDate",new Date())
//                                .field("message","trying out elastic search")
//                                .endObject()
//                ).get();

        GetResponse response=client.prepareGet("twitter","tweet","1").get();
        System.out.println(response);
        System.out.println(response.getSourceAsMap().get("user"));
        System.out.println(response.getField("user"));
        System.out.println(response.getField("postDate"));
        client.close();

        return null;
    }
}
