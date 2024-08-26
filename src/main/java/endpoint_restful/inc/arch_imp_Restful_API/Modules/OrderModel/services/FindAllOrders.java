package endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.services;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.database.entites.OrderModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.database.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllOrders {

    private final OrderRepo oRepo;

    public List<OrderModel> findAll() {
        return oRepo.findAll();
    }

}
