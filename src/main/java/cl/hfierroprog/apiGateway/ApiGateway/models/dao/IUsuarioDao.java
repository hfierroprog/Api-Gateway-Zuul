package cl.hfierroprog.apiGateway.ApiGateway.models.dao;

import cl.hfierroprog.apiGateway.ApiGateway.models.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsuarioDao extends MongoRepository<Usuario, String> {
}
