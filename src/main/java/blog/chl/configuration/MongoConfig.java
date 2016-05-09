package blog.chl.configuration;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.Mongo;
import com.mongodb.MongoClientOptions;

@Configuration
@EnableConfigurationProperties(MongoProperties.class)
public class MongoConfig {

	@Autowired
	  private MongoProperties properties;
	  @Autowired(required = false)
	  private MongoClientOptions options;
	  private Mongo mongo;
	  @PreDestroy
	  public void close() {
	    if (this.mongo != null) {
	      this.mongo.close();
	    }
	  }
	  
	  @Bean  
	  public MongoDbFactory mongoDbFactory() throws Exception {
		  
		this.mongo = this.properties.createMongoClient(this.options);
		 
	    return new SimpleMongoDbFactory(mongo, "test");  
	  } 
	  
	  @Bean
	  public MongoTemplate mongoTemplate() throws Exception {  
		   
		    //remove _class  
		    DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
			MappingMongoConverter converter =  new MappingMongoConverter(dbRefResolver, new MongoMappingContext()); 
		    converter.setTypeMapper(new DefaultMongoTypeMapper(null));  
		   
		    MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);  
		   
		    return mongoTemplate;  
		   
		  }  
}
