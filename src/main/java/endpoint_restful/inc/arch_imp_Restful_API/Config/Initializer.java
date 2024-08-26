package endpoint_restful.inc.arch_imp_Restful_API.Config;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.RoleModel.infra.database.entites.RoleModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.RoleModel.services.SaveRole;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.infra.database.entites.UserModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.services.SaveUser;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
public class Initializer {

    private final SaveUser uServ;
    private final SaveRole rServ;

    @PostConstruct
    public void createUserPermissions() {
        RoleModel roleAdmin = new RoleModel();
        roleAdmin.setName("ADMIN");
        rServ.save(roleAdmin);

        UserModel user = new UserModel();
        user.setActive(true);
        user.setEmail("test@test.com");
        user.setName("Danton Filipe");
        user.setPassword(new BCryptPasswordEncoder().encode("1234"));
        user.setUsername("mac");
        user.setRoles(List.of(roleAdmin));

        uServ.save(user);

    }
}
