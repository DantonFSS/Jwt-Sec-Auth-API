package endpoint_restful.inc.arch_imp_Restful_API.Modules.RoleModel.services;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.RoleModel.infra.database.entites.RoleModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.RoleModel.infra.database.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllRoles {

    private final RoleRepository rRepo;

    public List<RoleModel> findAll() {
        return rRepo.findAll();
    }
}
