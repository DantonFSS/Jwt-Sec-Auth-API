package endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.http.controllers;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.entites.ProductModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.services.FindProductById;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductByIdController {

    private final FindProductById prodById;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductModel> findById(@PathVariable Long id) {
        ProductModel prod = prodById.findById(id);
        return ResponseEntity.ok().body(prod);
    }

}
