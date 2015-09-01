package au.com.csl.vams.scaffold;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import org.springframework.data.jpa.repository.JpaRepository;

@Local
public interface IService<A extends IMasterPersistentEntity<B>,B extends Serializable, C extends JpaRepository<A, B>, D extends IDao<A,B,C>> {
	
	A getById(B pId);
	A create(A pEntity);
	A update(A pEntity);
	void delete(A pEntity);	
	List<A> getAll();
	
	D getDao();
}
