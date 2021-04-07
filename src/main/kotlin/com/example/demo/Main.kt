import EmailUtil.sendEmail
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

fun main() {
    /**
     * Outgoing Mail (SMTP) Server
     * requires TLS or SSL: smtp.gmail.com (use authentication)
     * Use Authentication: Yes
     * Port for TLS/STARTTLS: 587
     */
    val fromEmail = "copione7@gmail.com" //requires valid gmail id
    val password = "copione0" // correct password for gmail id
    val toEmail = "bourntivoli@gmail.com" // can be any email id
    println("TLSEmail Start")
    val props = Properties()
    props["mail.smtp.host"] = "smtp.gmail.com" //SMTP Host
    props["mail.smtp.port"] = "587" //TLS Port
    props["mail.smtp.auth"] = "true" //enable authentication
    props["mail.smtp.starttls.enable"] = "true" //enable STARTTLS

    //create Authenticator object to pass in Session.getInstance argument
    val auth: Authenticator = object : Authenticator() {
        //override the getPasswordAuthentication method
        override fun getPasswordAuthentication(): PasswordAuthentication {
            return PasswordAuthentication(fromEmail, password)
        }
    }
    val session = Session.getInstance(props, auth)
    sendEmail(session, toEmail, "yha", "this is!")
}


object EmailUtil {

    fun sendEmail(session: Session?, toEmail: String?, subject: String?, body: String?) {
        try {
            val msg = MimeMessage(session)
            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8")
            msg.addHeader("format", "flowed")
            msg.addHeader("Content-Transfer-Encoding", "8bit")
            msg.setFrom(InternetAddress("no_reply@example.com", "NoReply-JD"))
            msg.replyTo = InternetAddress.parse("no_reply@example.com", false)
            msg.setSubject(subject, "UTF-8")
            msg.setText(body, "UTF-8")
            msg.sentDate = Date()
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false))
            println("Message is ready")
            Transport.send(msg)
            println("EMail Sent Successfully!!")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
