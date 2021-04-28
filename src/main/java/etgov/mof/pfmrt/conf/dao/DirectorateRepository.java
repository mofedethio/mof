package etgov.mof.pfmrt.conf.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etgov.mof.pfmrt.conf.model.Directorate;

@Repository
public interface DirectorateRepository extends JpaRepository<Directorate, String> {

	
	   
}
