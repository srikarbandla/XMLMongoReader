package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.XMLReader;

public interface XMLReaderRepository extends MongoRepository<XMLReader, String>{

}
