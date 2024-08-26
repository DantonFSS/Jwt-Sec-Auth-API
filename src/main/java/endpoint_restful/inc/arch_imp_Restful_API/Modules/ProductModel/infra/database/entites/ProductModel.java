package endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.entites;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 145, nullable = false)
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "desc", length = 300, nullable = false)
    private String description;

}
