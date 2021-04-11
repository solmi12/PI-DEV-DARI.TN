package dari.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import dari.entity.AnnonceImmobilier;
import dari.entity.Client;
import dari.entity.Feedback;
import dari.repository.AnnonceRepository;
import dari.repository.ClientRepository;
import dari.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService{
	@Autowired
	AnnonceRepository ar;
	@Autowired
	FeedbackRepository fr;
	@Autowired
	ClientRepository cr;
	@Autowired
    public JavaMailSender emailSender;
	
	private static final Logger L =LogManager.getLogger(FeedbackServiceImpl.class);
	
	@Override
	public Feedback addFeedback(long id_client, long annonce_ref, String commentaire) {
		// TODO Auto-generated method stub
		Client client =  cr.findById(id_client).get();
		AnnonceImmobilier annonce =  ar.findById(annonce_ref).get();
		Feedback f = new Feedback();
		f.setAnnonce(annonce);
		f.setClient(client);
		f.setCommentaire(commentaire);
		fr.save(f);
		annonce.setFeedbacks(f);
		//mail
		SimpleMailMessage message = new SimpleMailMessage();
		 
        message.setTo(annonce.getClient().getAdresseEmail());
        message.setSubject("You had A new Feedback on your Ad");
        message.setText(commentaire);

        emailSender.send(message);
		
	return f;
		
	}

	@Override
	public void deleteFeedback(long id) {
		fr.deleteById(id);
		
	}

	/*
	@Override
	public Feedback addFeedback(long id,long annonce_ref,String commentaire) {
		Client client =  cr.findById(id).get();
		AnnonceImmobilier annonce = new AnnonceImmobilier();
		 annonce =  ar.findById(annonce_ref).get();
		
		Feedback f = new Feedback();
		f.setAnnonce(annonce);
		f.setClient(client);
		f.setCommentaire(commentaire);
		fr.save(f);
		//annonce.setFeedbacks(f);
	return f;
	}*/
	
	
	/*@Autowired
    public JavaMailSender emailSender;

    @Override
    public Response sendEmail(Email mail) {

        Response response = new Response();
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(mail.getTo());
            message.setSubject(mail.getSubject());
            message.setText(mail.getText());

            emailSender.send(message);

            response.setCode(0);
            response.setMessage("Email send ok!");
        } catch (Exception ex) {
            response.setCode(1);
            response.setMessage("Error sending email: " + ex.getMessage());
        }

        return response;*/
	
	

}
