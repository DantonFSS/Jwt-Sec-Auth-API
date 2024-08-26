package endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.services;


import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.database.entites.OrderModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.database.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindOrderById {

    private final OrderRepo oRepo;

    public OrderModel findById(Long id) {
        return oRepo.findById(id).orElse(null);
    }

}
