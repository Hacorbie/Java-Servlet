package Lab3;

import java.io.IOException;
import java.net.Authenticator;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;


/**
 * Servlet implementation class GuiMail
 */
@WebServlet("/GuiMail")
public class GuiMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuiMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/views/FormMail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String username = "jxprojx114@gmail.com";
        final String password = "oxykwtoyrnoyyalf";

        String to =request.getParameter("mailto");

        // Địa chỉ email người gửi
        String from = "jxprojx114@gmail.com";

        // Cài đặt các thuộc tính cho phiên gửi email
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");



        // Tạo một phiên gửi email với thông tin xác thực tài khoản
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        try {
            // Tạo đối tượng Message để thiết lập thông tin email
            Message message = new MimeMessage(session);

            // Thiết lập địa chỉ email người gửi
            message.setFrom(new InternetAddress(from));

            // Thiết lập địa chỉ email người nhận
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));

            // Thiết lập tiêu đề email
            message.setSubject(request.getParameter("mmail"));

            // Thiết lập nội dung email
            message.setText(request.getParameter("mmail"));

            // Gửi email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
		doGet(request, response);
	}

}
