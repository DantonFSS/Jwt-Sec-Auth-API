package endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.http.controllers;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.database.entites.OrderModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.services.SaveOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ordering")
@RequiredArgsConstructor
public class SaveOrderController {

    private final SaveOrder saveOrder;

    @PostMapping(value = "/save")
    public ResponseEntity<OrderModel> saveOrder (@RequestBody OrderModel order) {
        order = saveOrder.save(order);
        return ResponseEntity.ok().body(order);
    }

}
