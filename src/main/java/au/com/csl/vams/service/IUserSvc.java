package au.com.csl.vams.service;

import javax.ejb.Local;

import au.com.csl.vams.dao.IUserDao;
import au.com.csl.vams.dao.relational.repository.UserRepository;
import au.com.csl.vams.model.relational.AppUser;
import au.com.csl.vams.scaffold.IService;

@Local
public interface IUserSvc extends IService<AppUser, String, UserRepository, IUserDao> {

}
