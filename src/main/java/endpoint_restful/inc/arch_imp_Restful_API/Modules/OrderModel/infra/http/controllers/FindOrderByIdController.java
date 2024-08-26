package endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.http.controllers;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.database.entites.OrderModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.services.FindOrderById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ordering")
@RequiredArgsConstructor
public class FindOrderByIdController {

    private final FindOrderById findOrder;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderModel> findOrder(@PathVariable Long id) {
        OrderModel order = findOrder.findById(id);
        return ResponseEntity.ok().body(order);
    }

}
