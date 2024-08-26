package endpoint_restful.inc.arch_imp_Restful_API.Config;


import endpoint_restful.inc.arch_imp_Restful_API.Config.jwt.JwtRequest;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.services.AuthenticateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticateUser uService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody JwtRequest request) {
        return uService.signin(request);
    }

}
