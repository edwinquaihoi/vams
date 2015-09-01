package au.com.csl.vams.dao;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import au.com.csl.vams.dao.relational.repository.UserRepository;
import au.com.csl.vams.model.relational.AppUser;
import au.com.csl.vams.scaffold.IDao;

@NoRepositoryBean
public interface IUserDao extends IDao<AppUser, String, UserRepository> , UserRepository {

	/**
	 * Search user by entered substring
	 * @param genericSearchString
	 * @return users where username match to the search string
	 */
	List<AppUser> findByLoginLike(String genericSearchString);
	

}
