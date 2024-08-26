package endpoint_restful.inc.arch_imp_Restful_API.Modules.OrderModel.infra.database.entites;


import endpoint_restful.inc.arch_imp_Restful_API.Modules.ProductModel.infra.database.entites.ProductModel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private LocalDateTime dateOrder;
    private String status;

    @ManyToMany
    @Fetch(FetchMode.SELECT)
    private Set<ProductModel> products;


}
