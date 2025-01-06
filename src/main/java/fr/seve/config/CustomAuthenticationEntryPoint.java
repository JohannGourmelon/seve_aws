package fr.seve.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // Extraire le slug de l'URL
        String requestUri = request.getRequestURI();
        String[] pathParts = requestUri.split("/");

        String targetLoginPage = "/login"; // Page de login par défaut (SaaS)
        if (pathParts.length > 1) {
            String slug = pathParts[1]; // Supposons que le slug soit le premier segment de l'URL
            targetLoginPage = "/" + slug + "/login"; // Page de login spécifique à l'AMAP
        }

        // Rediriger vers la page de login appropriée
        response.sendRedirect(targetLoginPage);
    }
}
