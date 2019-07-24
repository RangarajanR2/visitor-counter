package org.springframework.visitor_counter.db;

import java.net.UnknownHostException;

import org.bson.Document;
import org.springframework.visitor_counter.repository.Visitor;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DB {

	private MongoClient client;
	private MongoDatabase db;
	
	private static DB instance;
	
	public static DB getInstance() throws UnknownHostException {
		if(DB.instance == null) {
			DB.instance = new DB();
		}
		return DB.instance;
	}
	
	private DB() throws UnknownHostException{
		this.client = new MongoClient(new MongoClientURI("mongodb://newadmin:newadmin321@ds153947.mlab.com:53947/visitor-counter"));
		this.db = this.client.getDatabase("visitor-counter");
	}
	
	public long count(String collection) {
		return this.db.getCollection(collection).count();
	}
	
	public void insert(String collection, Visitor instance) {
		Document doc = new Document();
		doc.append("ip", instance.getIp()).append("useragent", instance.getUseragent());
		this.db.getCollection(collection).insertOne(doc);
	}
}
