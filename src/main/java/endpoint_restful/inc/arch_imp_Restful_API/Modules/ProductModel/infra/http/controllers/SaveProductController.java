package endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.http.controllers;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.entites.ProductModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.services.SaveProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class SaveProductController {

    private final SaveProduct serv;

    @PostMapping(value = "/save")
    public ResponseEntity<ProductModel> saveProd(@RequestBody ProductModel product) throws Exception {
        product = serv.save(product);
        return ResponseEntity.ok().body(product);
    }

}
