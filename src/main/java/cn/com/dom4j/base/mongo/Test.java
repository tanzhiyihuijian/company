package cn.com.dom4j.base.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年08月19日
 * @desc
 */
public class Test {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        MongoDatabase imooc = mongoClient.getDatabase("imooc");

//        imooc.createCollection("jdbc_mongo_test");

        MongoCollection<Document> jdbcMongoTest = imooc.getCollection("jdbc_mongo_test");



        jdbcMongoTest.insertOne(new Document("name", "zhangsan"));





    }




}
