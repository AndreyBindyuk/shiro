import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import org.apache.shiro.SecurityUtils;
import org.omnifaces.util.Faces;

@Named
@RequestScoped
@Interceptors(ShiroSecuredInterceptor.class)
public class Logout {

    public static final String HOME_URL = "/shiro/login.xhtml";

    public void submit() throws IOException {
        SecurityUtils.getSubject().logout();
        Faces.invalidateSession();
        Faces.redirect(HOME_URL);
    }
}
