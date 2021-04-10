package dari.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dari.entity.Client;
import dari.entity.Surveillance;
import dari.entity.SurveillanceNotice;
import dari.repository.ClientRepository;
import dari.repository.SurveillanceNoticeRepository;
import dari.repository.SurveillanceRepository;

@Service
public class SurveillanceNoticeServiceImpl implements ISurveillanceNoticeService{
	
	@Autowired
	SurveillanceNoticeRepository surveillanceNoticeRepository;
	
	@Autowired
	ISurveillanceService SurveillanceService;
	
	@Override
	public SurveillanceNotice addSurveillanceNoticeAndaffecterSurveillanceToSurveillanceNotice(String description, Long surveillanceId,Long idClient) {
		// TODO Auto-generated method stub
		SurveillanceNotice notice = new SurveillanceNotice(description);
		Surveillance s =SurveillanceService.retrieveSurveillance(surveillanceId);
		notice.setSurveillance(s);
		surveillanceNoticeRepository.save(notice);
		SurveillanceService.addValueInMap(surveillanceId, idClient, notice.getIdNotice());
		return notice;
	}

	@Override
	public String deleteSurveillanceNotice(Long idSurveillance, Long idClient, Long idNotice) {
		// TODO Auto-generated method stub
		if( SurveillanceService.searchValueInMap(idSurveillance, idClient, idNotice))
		{
			surveillanceNoticeRepository.deleteById(idNotice);
			SurveillanceService.deleteValueInMap(idSurveillance, idClient, idNotice);
			return "your review has been deleted";
		}
		return "you do not have the right to delete";
	}

	@Override
	public List<SurveillanceNotice> retrieveSurveillanceNoticeBySurveillance(Long SurveillanceId) {
		// TODO Auto-generated method stub
		return SurveillanceService.retrieveSurveillance(SurveillanceId).getSurveillanceNotices();
	}

	

	

}
