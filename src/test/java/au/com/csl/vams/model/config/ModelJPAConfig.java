package au.com.csl.vams.model.config;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.SynchronizationType;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import au.com.csl.vams.dao.Dao;
import au.com.csl.vams.dao.IAlgorithmDao;
import au.com.csl.vams.dao.IPlateDao;
import au.com.csl.vams.dao.IPlateTypeDao;
import au.com.csl.vams.dao.IRunDao;
import au.com.csl.vams.dao.ISampleDao;
import au.com.csl.vams.dao.IStudyDao;
import au.com.csl.vams.dao.IStudyTypeDao;
import au.com.csl.vams.dao.IUserDao;
import au.com.csl.vams.dao.relational.AlgorithmDao;
import au.com.csl.vams.dao.relational.PlateDao;
import au.com.csl.vams.dao.relational.PlateVersionDao;
import au.com.csl.vams.dao.relational.PlateTypeDao;
import au.com.csl.vams.dao.relational.RunDao;
import au.com.csl.vams.dao.relational.SampleDao;
import au.com.csl.vams.dao.relational.StudyDao;
import au.com.csl.vams.dao.relational.StudyTypeDao;
import au.com.csl.vams.dao.relational.UserDao;
import au.com.csl.vams.dao.relational.repository.AlgorithmRepository;
import au.com.csl.vams.dao.relational.repository.PlateVersionRepository;
import au.com.csl.vams.dao.relational.repository.PlateRepository;
import au.com.csl.vams.dao.relational.repository.PlateTypeRepository;
import au.com.csl.vams.dao.relational.repository.Repo;
import au.com.csl.vams.dao.relational.repository.RunRepository;
import au.com.csl.vams.dao.relational.repository.SampleRepository;
import au.com.csl.vams.dao.relational.repository.StudyRepository;
import au.com.csl.vams.dao.relational.repository.StudyTypeRepository;
import au.com.csl.vams.dao.relational.repository.UserRepository;

@Configuration
@EnableJpaRepositories(basePackages = "au.com.csl.vams.dao.relational.repository")
@EnableTransactionManagement
public class ModelJPAConfig {

	//private static final Logger logger = LoggerFactory.getLogger(ModelJPAConfig.class);
	
	@Bean public DataSource dataSource() throws SQLException {

		DataSource dataSource = null;
		
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		dataSource = builder.setName("test-vams-db").setType(EmbeddedDatabaseType.H2).build();
        
        return dataSource;
	}
	

	@Bean @Scope(value="singleton") public EntityManagerFactory entityManagerFactory() throws SQLException {

		
		EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		
		// Note because the prod pesistence.xml references a JTA transaction type and uses a JNDI reference to a datasource
		// it won't work in the case where we are simulating through Spring so we have to have a test specific version of 
		// persistence.xml file
		factory.setPersistenceXmlLocation("classpath*:/META-INF/persistence-test.xml");		
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean @Scope(value="singleton") public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.createEntityManager(SynchronizationType.SYNCHRONIZED);
	}

	@Bean @Scope(value="singleton") public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) throws SQLException {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		
		return txManager;
	}
	
	@Bean @Scope(value="singleton") public JpaRepositoryFactory jpaRepositoryFactory(EntityManager entityManager) throws SQLException {
		
		return new JpaRepositoryFactory(entityManager);
	}
	
	
	@Bean @Dao public IUserDao userDao() {
		return new UserDao();
	}
		
	@Bean @Repo public UserRepository userRepository(JpaRepositoryFactory jpaRepositoryFactory) {
		return jpaRepositoryFactory.getRepository(UserRepository.class);
	}
	
	@Bean @Dao public ISampleDao sampleDao() {
		return new SampleDao();
	}
		
	@Bean @Repo public SampleRepository sampleRepository(JpaRepositoryFactory jpaRepositoryFactory) {
		return jpaRepositoryFactory.getRepository(SampleRepository.class);
	}
	
	@Bean @Dao public IStudyTypeDao studyTypeDao() {
		return new StudyTypeDao();
	}
		
	@Bean @Repo public StudyTypeRepository studyTypeRepository(JpaRepositoryFactory jpaRepositoryFactory) {
		return jpaRepositoryFactory.getRepository(StudyTypeRepository.class);
	}

	@Bean @Dao public IStudyDao studyDao(){
		return new StudyDao();	
	}
	
	@Bean @Repo public StudyRepository studyRepository(JpaRepositoryFactory jpaRepositoryFactory){
		return jpaRepositoryFactory.getRepository(StudyRepository.class);
	}
	
	@Bean @Dao public IPlateDao plateDao(){
		return new PlateDao();
	}
	
	@Bean @Repo public PlateRepository plateRepository(JpaRepositoryFactory jpaRepositoryFactory){
		return jpaRepositoryFactory.getRepository(PlateRepository.class);
	}
	
	@Bean @Dao public IRunDao runDao(){
		return new RunDao();
	}
	
	@Bean @Repo public RunRepository runRepository(JpaRepositoryFactory jpaRepositoryFactory){
		return jpaRepositoryFactory.getRepository(RunRepository.class);
	}
	
	@Bean @Dao
	public IAlgorithmDao algorithmDao() {
		return new AlgorithmDao();
	}
	
	@Bean @Repo public AlgorithmRepository algorithmRepository(JpaRepositoryFactory jpaRepositoryFactory){
		return jpaRepositoryFactory.getRepository(AlgorithmRepository.class);
	}
	
	@Bean @Dao
	public IPlateTypeDao plateTypeDao() {
		return new PlateTypeDao();
	}
	
	@Bean @Repo public PlateTypeRepository plateTypeRepository(JpaRepositoryFactory jpaRepositoryFactory){
		return jpaRepositoryFactory.getRepository(PlateTypeRepository.class);
	}
	
}
