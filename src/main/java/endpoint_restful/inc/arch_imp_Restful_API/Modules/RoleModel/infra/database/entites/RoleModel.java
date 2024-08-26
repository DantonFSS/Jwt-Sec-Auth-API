package endpoint_restful.inc.arch_imp_Restful_API.Modules.RoleModel.infra.database.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
public class RoleModel implements GrantedAuthority {

    private static final long serialVersionUID = -6469391897738445679L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Override
    public String getAuthority() {
        return "";
    }
}
