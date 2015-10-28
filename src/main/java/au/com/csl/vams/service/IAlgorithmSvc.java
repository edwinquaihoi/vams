package au.com.csl.vams.service;

import javax.ejb.Local;
import au.com.csl.vams.dao.IAlgorithmDao;
import au.com.csl.vams.dao.relational.repository.AlgorithmRepository;
import au.com.csl.vams.model.relational.Algorithm;
import au.com.csl.vams.scaffold.IService;

@Local
public interface IAlgorithmSvc  extends IService<Algorithm, String, AlgorithmRepository, IAlgorithmDao>{

}
