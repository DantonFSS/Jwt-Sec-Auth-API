package endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.http.controllers;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.entites.ProductModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.services.FindAllProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class FindAllProductsController {

    private final FindAllProducts allProd;

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<ProductModel>> findAll() {
        List<ProductModel> prod = allProd.findAll();
        return ResponseEntity.ok().body(prod);
    }

}
