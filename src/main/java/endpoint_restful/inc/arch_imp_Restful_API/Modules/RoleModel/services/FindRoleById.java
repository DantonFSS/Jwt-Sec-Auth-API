package endpoint_restful.inc.arch_imp_Restful_API.Modules.RoleModel.services;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.RoleModel.infra.database.entites.RoleModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.RoleModel.infra.database.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindRoleById {

    private final RoleRepository rRepo;

    public RoleModel findById(Long id) {
        return rRepo.findById(id).orElse(null);
    }

}
