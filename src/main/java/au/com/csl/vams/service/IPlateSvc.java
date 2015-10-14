package au.com.csl.vams.service;

import java.util.List;

import javax.ejb.Local;

import au.com.csl.vams.dao.IPlateDao;
import au.com.csl.vams.dao.relational.repository.PlateRepository;
import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.model.relational.Sample;
import au.com.csl.vams.scaffold.IService;

@Local
public interface IPlateSvc extends IService<Plate, String, PlateRepository, IPlateDao> {

	public void calcLargeVol(Sample sample, Plate plate);

	public List<Plate> getPlates(Run run);

}
