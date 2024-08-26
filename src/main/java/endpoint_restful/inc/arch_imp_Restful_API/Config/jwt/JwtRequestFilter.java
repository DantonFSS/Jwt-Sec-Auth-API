package endpoint_restful.inc.arch_imp_Restful_API.Config.jwt;

import endpoint_restful.inc.arch_imp_Restful_API.Modules.UserModel.services.LoadUserByUsername;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final LoadUserByUsername uServ;
    private final JwtTokenUtil tokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");

        logger.info("Authorization Header: " + requestTokenHeader);
        logger.info("Rquest: " + request);
        
        String username = null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = tokenUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException | ExpiredJwtException arg) {
                System.out.println(arg);
            }
        }
        else {
            logger.warn("Jwt token does not begin with Bearer String!!!");
        }

        // now i`ll validate token since we have it already.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails uDetails = this.uServ.loadUserByUsername(username);

            // if token is valid, configure Spring Security to manually set authentication
            if (tokenUtil.validateToken(jwtToken, uDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        uDetails, null, uDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // after setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        // we then filter.
        filterChain.doFilter(request, response);
    }
}