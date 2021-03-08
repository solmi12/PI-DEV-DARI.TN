package dari.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dari.entity.SurveillanceNotice;
import dari.repository.SurveillanceNoticeRepository;

@Service
public class SurveillanceNoticeImpl implements ISurveillanceNotice{
	
	@Autowired
	SurveillanceNoticeRepository surveillanceNoticeRepository;

	@Override
	public Collection<SurveillanceNotice> retrieveAllSurveillanceNotice() {
		// TODO Auto-generated method stub
		return surveillanceNoticeRepository.findAll();
	}

	@Override
	public SurveillanceNotice addSurveillanceNotice(SurveillanceNotice s) {
		// TODO Auto-generated method stub
		surveillanceNoticeRepository.save(s);
		return null;
	}

	@Override
	public void deleteSurveillanceNotice(Long id) {
		// TODO Auto-generated method stub
		surveillanceNoticeRepository.deleteById(id);
		
	} 
	
	

}
