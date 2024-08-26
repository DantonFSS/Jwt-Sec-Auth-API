package endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.repository;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.entites.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel, Long> {

}
