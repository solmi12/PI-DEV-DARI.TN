package dari.service;

import dari.entity.Feedback;

public interface IFeedbackService {
	public Feedback addFeedback(long id_client,long annonce_ref,String commentaire);
	public void deleteFeedback(long id);

}
