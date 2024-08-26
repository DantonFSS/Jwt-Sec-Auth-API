package endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.services;

import endpoint_restful.inc.arch_imp_Restful_API.Config.jwt.JwtRequest;
import endpoint_restful.inc.arch_imp_Restful_API.Config.jwt.JwtTokenUtil;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.infra.database.entites.UserModel;
import endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.infra.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateUser {

    private final AuthenticationManager authManage;
    private final JwtTokenUtil jwtToken;
    private final UserRepository uById;

    public ResponseEntity<?> signin (JwtRequest authRequest) {

        try {
            authenticate(authRequest.getUsername(), authRequest.getPassword());

            final UserModel userDetails = uById.findByUsername(authRequest.getUsername());
            final String token = jwtToken.generateToken(userDetails);

            return ResponseEntity.ok(token);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authManage.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USUARIO DESABILITADO", e);
        } catch (BadCredentialsException e) {
            throw new Exception("CREDENCIAIS INVALIDAS", e);
        }
    }

}
