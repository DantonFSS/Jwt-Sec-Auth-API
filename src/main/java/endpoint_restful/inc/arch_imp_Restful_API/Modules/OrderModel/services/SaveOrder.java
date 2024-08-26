package endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.services;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.database.entites.OrderModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.database.repository.OrderRepo;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.entites.ProductModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SaveOrder {

    private final ProductRepo pRepo;
    private final OrderRepo oRepo;

    public OrderModel save(OrderModel order){
        Set<ProductModel> products = new HashSet<>();

        order.setDateOrder(LocalDateTime.now());
        order.getProducts().forEach(product -> {
            products.add(pRepo.getById(product.getId()));
        });
        order.setProducts(products);

        return oRepo.save(order);
    }

}
