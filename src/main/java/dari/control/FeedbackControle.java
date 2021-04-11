package dari.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dari.entity.Feedback;
import dari.service.IFeedbackService;
import dari.entity.AnnonceImmobilier;
@RestController
public class FeedbackControle {
@Autowired 
IFeedbackService fs ;

@PostMapping("add-feedback/{id_client}/{annonce_ref}")
@ResponseBody
public Feedback addFeedbackC(@PathVariable("id_client") long id_client,@PathVariable("annonce_ref") long annonce_ref,
		@RequestBody String commentaire ){
	return fs.addFeedback(id_client, annonce_ref, commentaire);
}
@DeleteMapping("delete-feedback/{id}")
@ResponseBody
public void deleteAnnonce(@PathVariable("id")long id){
	fs.deleteFeedback(id);	}


}
