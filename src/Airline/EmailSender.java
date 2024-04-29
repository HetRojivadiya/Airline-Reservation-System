// package Airline;

// import java.io.IOException;
// import java.util.*;
// import javax.mail.*;
// import javax.mail.internet.*;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;
// import java.util.logging.Level;
// import java.util.logging.Logger;

// public class EmailSender {

//     public static void main(String[] args) throws IOException {

//     }

//     static void main() throws IOException {

//         // Recipient's email ID needs to be mentioned.
//         String to = "hetrojivadia999@gmail.com";

//         // Sender's email ID needs to be mentioned
//         String from = "hetrojivadiya999@gmail.com";

//         // Assuming you are sending email from localhost
//         String host = "smtp.gmail.com";

//         // Get system properties
//         Properties properties = System.getProperties();

//         // Setup mail server
//         properties.setProperty("mail.smtp.host", host);
//         properties.setProperty("mail.smtp.port", "587");
//         properties.setProperty("mail.smtp.starttls.enable", "true");
//         properties.setProperty("mail.smtp.auth", "true");
//         properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

//         // Get the default Session object.
//         Session session = Session.getInstance(properties, new Authenticator() {
//             protected PasswordAuthentication getPasswordAuthentication() {
//                 return new PasswordAuthentication("hetrojivadiya999@gmail.com", "sstrfafrivcbtcww");
//             }
//         });

//         // Create an ExecutorService with a fixed thread pool
//         ExecutorService executor = Executors.newSingleThreadExecutor();

//         // Execute sending email in a separate thread
//         executor.execute(() -> {
//             try {
//                 sendEmail(session, from, to);
//             } catch (IOException ex) {
//                 Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
//             }
//         });

//         executor.shutdown();
//     }

//     private static void sendEmail(Session session, String from, String to) throws IOException {

//         // Shut down the ExecutorService
//         try {
//             // Create a default MimeMessage object.
//             MimeMessage message = new MimeMessage(session);

//             // Set From: header field of the header.
//             message.setFrom(new InternetAddress(from));

//             // Set To: header field of the header.
//             message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

//             // Set Subject: header field
//             message.setSubject("Ticket Successfully Booked!");

//             MimeMultipart multipart = new MimeMultipart();

//             // Create a body part for the text content
//             MimeBodyPart messageBodyPart = new MimeBodyPart();

//             // Now set the actual message
//             messageBodyPart.setText(
//                     "Dear " + temp.tempFname + ",\n\n"
//                     + "We hope this email finds you filled with excitement and anticipation for your upcoming adventure! We are delighted to inform you that your flight ticket has been successfully booked and confirmed. Get ready to embark on an incredible journey that promises unforgettable memories and awe-inspiring experiences.\n\n"
//                     + "Here are the details of your flight reservation:\n\n"
//                     + "Passenger Name: " + temp.tempFname + " " + temp.tempLname + "\n"
//                     + "Flight Number: " + temp.tempFlight + "\n"
//                     + "Departure Airport: " + temp.tempLocation + " Airport\n"
//                     + "Arrival Airport: " + temp.tempDestination + " Airport\n"
//                     + "Departure Date: " + temp.tempDate + "\n"
//                     + "Departure Time: " + temp.tempTime + "\n\n"
//                     + "Please make sure to arrive at the airport well in advance, at least two hours before the scheduled departure time, to ensure a smooth check-in process. Remember to carry a valid government-issued photo identification document along with your ticket.\n\n"
//                     + "We understand that the journey is just as important as the destination itself, and we are committed to providing you with a seamless and comfortable experience. Our dedicated team of professionals is ready to assist you throughout your travel, from check-in to boarding and all the way to your final destination.\n\n"
//                     + "We advise you to stay informed about any updates regarding your flight. In case of any changes or delays, we will notify you promptly via the contact details provided during the booking process. Alternatively, you can visit our website or contact our customer service representatives for any assistance you may need.\n\n"
//                     + "As you prepare for your upcoming journey, we recommend checking the baggage restrictions and guidelines to ensure compliance with the airline's policies. Additionally, familiarize yourself with any necessary travel documents or visas required for your destination.\n\n"
//                     + "We take this opportunity to wish you a fantastic trip filled with joy, discovery, and incredible experiences. May your journey be filled with breathtaking sights, wonderful encounters, and cherished moments that will stay with you forever.\n\n"
//                     + "Thank you for choosing [Airline Name] for your travel needs. We are honored to be a part of your journey, and we look forward to providing you with an exceptional travel experience.\n\n"
//                     + "If you have any further questions or require any assistance, please feel free to contact our customer service team. They will be delighted to assist you in any way possible.\n\n"
//                     + "Bon voyage!\n\n"
//                     + "Warm regards,\n\n"
//                     + "Skyline\n"
//                     + "Customer Service Representative\n"
//                     + temp.tempFlight);

//             multipart.addBodyPart(messageBodyPart);

//             // Create a body part for the PDF attachment
//             MimeBodyPart attachmentBodyPart = new MimeBodyPart();

//             String filePath = "C:\\Users\\hetro\\OneDrive\\Documents\\NetBeansProjects\\Skyline\\src\\Airline\\document.pdf";

//             attachmentBodyPart.attachFile(filePath);

//             // Set the filename of the attachment
//             attachmentBodyPart.setFileName("Ticket.pdf");

//             // Add the PDF attachment body part to the multipart
//             multipart.addBodyPart(attachmentBodyPart);

//             // Set the content of the message to the multipart
//             message.setContent(multipart);

//             // Send message
//             Transport.send(message);
//             System.out.println("Sent message successfully....");
//             Ticket.delete();
//         } catch (MessagingException mex) {
//             mex.printStackTrace();
//         }
//     }
// }
