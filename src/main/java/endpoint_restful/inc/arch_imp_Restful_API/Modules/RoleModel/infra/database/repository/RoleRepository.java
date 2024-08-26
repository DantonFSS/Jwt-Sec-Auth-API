package endpoint_restful.inc.arch_imp_Restful_API.Modules.RoleModel.infra.database.repository;


import endpoint_restful.inc.arch_imp_Restful_API.Modules.RoleModel.infra.database.entites.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {

}
