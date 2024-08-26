package endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.services;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.domain.exceptions.ProductNullException;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.domain.exceptions.ProductPriceException;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.entites.ProductModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProduct {

    private final ProductRepo uRepo;

    public ProductModel save(ProductModel prod) throws Exception {
        if(prod.getName() == null || prod.getPrice() == null || prod.getDescription() == null) {
            throw new ProductNullException();
        }
        if (prod.getPrice() < 0) {
            throw new ProductPriceException();
        }
        return uRepo.save(prod);
    }

}
