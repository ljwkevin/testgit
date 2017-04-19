package com.test.test;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class test {
	/*
	 * Hello world,git!
	 */
	
	 public static void main( String args[] ){
	      /*try{   
	       // 连接到 mongodb 服务
	         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	       
	         // 连接到数据库
	         MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
	       System.out.println("Connect to database successfully");
	        
	      }catch(Exception e){
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	     }*/
		 try {
			 MongoClient mongoClient=new MongoClient("localhost", 27017);
			 
			 MongoDatabase mongoDatabase=mongoClient.getDatabase("local");
			 System.out.println("Successful");
			
			 MongoCollection<Document> collection=mongoDatabase.getCollection("hello");
			/* Document document = new Document("title", "MongoDB").  
			         append("description", "database").  
			         append("likes", 100).  
			         append("by", "Fly");  
		     List<Document> documents = new ArrayList<Document>();  
			         documents.add(document);  
			         collection.insertMany(documents);  
			        
			         System.out.println("文档插入成功");  */
			 collection.updateMany(Filters.eq("likes",100), new Document("$set",new Document("likes",200)));	
			 
			 collection.deleteOne(Filters.eq("name","a"));
			 FindIterable<Document> iterable=collection.find();
			 MongoCursor<Document> cursor=iterable.iterator();
			 while(cursor.hasNext())
			 {
				 System.out.println(cursor.next());
			 }
			         
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	   }

}
