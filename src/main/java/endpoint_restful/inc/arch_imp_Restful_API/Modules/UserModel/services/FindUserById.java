package endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.services;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.infra.database.entites.UserModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.infra.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserById {

    private final UserRepository uRepo;

    public UserModel findById(Long id) {
        return uRepo.findById(id).orElse(null);
    }
}
