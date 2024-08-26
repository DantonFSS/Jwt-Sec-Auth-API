package endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.infra.database.repository;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.infra.database.entites.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUsername(String username);

}
