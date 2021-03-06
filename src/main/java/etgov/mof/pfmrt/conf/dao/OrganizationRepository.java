package etgov.mof.pfmrt.conf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import etgov.mof.pfmrt.conf.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String> {

}
