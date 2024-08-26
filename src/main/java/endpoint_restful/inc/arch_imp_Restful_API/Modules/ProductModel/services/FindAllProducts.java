package endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.services;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.entites.ProductModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllProducts {

    private final ProductRepo uRepo;

    public List<ProductModel> findAll() {
        return uRepo.findAll();
    }

}
