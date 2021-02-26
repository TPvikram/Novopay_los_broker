package in.novopay.broker.repository;

import in.novopay.broker.dao.ActionFormDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionFormRepository extends MongoRepository<ActionFormDoc, Long> {

}