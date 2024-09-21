package thu2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUserService service = new UserService(); // Assuming this service handles user data

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        String alertMsg = "";

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            alertMsg = "Tất cả các trường đều là bắt buộc.";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        if (!password.equals(confirmPassword)) {
            alertMsg = "Mật khẩu không khớp.";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        UserModel newUser = new UserModel(); // Ensure UserModel has appropriate constructor
        boolean isRegistered = service.register(newUser);

        if (isRegistered) {
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            alertMsg = "Tên người dùng đã tồn tại.";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}