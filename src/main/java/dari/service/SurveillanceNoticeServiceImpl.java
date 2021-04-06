package dari.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dari.entity.Surveillance;
import dari.entity.SurveillanceNotice;
import dari.repository.SurveillanceNoticeRepository;
import dari.repository.SurveillanceRepository;

@Service
public class SurveillanceNoticeServiceImpl implements ISurveillanceNoticeService{
	
	@Autowired
	SurveillanceNoticeRepository surveillanceNoticeRepository;
	
	@Autowired
	SurveillanceRepository surveillanceRepository;

	@Override
	public int addSurveillanceNoticeAndaffecterSurveillanceToSurveillanceNotice(SurveillanceNotice notice,
			long surveillanceId) {
		// TODO Auto-generated method stub
		Surveillance s = surveillanceRepository.findById(surveillanceId).get();
		notice.setSurveillance(s);
		surveillanceNoticeRepository.save(notice);
		return 1;
	}

	@Override
	public int deleteSurveillanceNotice(Long id) {
		// TODO Auto-generated method stub
		surveillanceNoticeRepository.deleteById(id);
		return 1;
	}

	@Override
	public List<SurveillanceNotice> retrieveSurveillanceNoticeBySurveillance(long SurveillanceId) {
		// TODO Auto-generated method stub
		return surveillanceNoticeRepository.retrieveAllSurveillanceNoticeBySurveillance(SurveillanceId);
	}

	
	
	

}
