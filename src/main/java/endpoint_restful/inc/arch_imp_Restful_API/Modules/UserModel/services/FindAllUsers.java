package endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.services;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.infra.database.entites.UserModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.infra.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllUsers {

    private final UserRepository uRepo;

    public List<UserModel> findAll() {
        return uRepo.findAll();
    }
}
