package au.com.csl.vams.cdi;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses={})
public class CdiConfig {
	
    @Produces  
    @Dependent  
    @PersistenceContext(unitName="vams-db")  
    private EntityManager entityManager;    
}
