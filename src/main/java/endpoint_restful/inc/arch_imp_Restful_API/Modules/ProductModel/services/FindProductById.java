package endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.services;


import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.entites.ProductModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindProductById {

    private final ProductRepo uRepo;

    public ProductModel findById(Long id) {
        return uRepo.findById(id).orElse(null);
    }

}
