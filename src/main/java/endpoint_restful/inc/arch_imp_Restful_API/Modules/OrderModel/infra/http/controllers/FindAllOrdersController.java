package endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.http.controllers;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.database.entites.OrderModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.services.FindAllOrders;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ordering")
@RequiredArgsConstructor
public class FindAllOrdersController {

    private final FindAllOrders allOrders;

    @GetMapping(value = "/getOrders")
    public ResponseEntity<List<OrderModel>> findAll() {
        List<OrderModel> orderSearch = allOrders.findAll();
        return ResponseEntity.ok().body(orderSearch);
    }
}
