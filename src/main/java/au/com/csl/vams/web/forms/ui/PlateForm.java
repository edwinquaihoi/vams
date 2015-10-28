package au.com.csl.vams.web.forms.ui;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.json.JSONArray;
import org.json.JSONObject;
import au.com.csl.vams.model.relational.Plate;
import au.com.csl.vams.model.relational.PlateElement;
import au.com.csl.vams.model.relational.PlateVersion;
import au.com.csl.vams.model.relational.Run;
import au.com.csl.vams.model.relational.Study;
import au.com.csl.vams.scaffold.AbstractMaintenanceForm;
import au.com.csl.vams.scaffold.IService;
import au.com.csl.vams.service.IPlateSvc;
import au.com.csl.vams.service.IPlateVersionSvc;
import au.com.csl.vams.service.IRunSvc;
import au.com.csl.vams.service.IStudySvc;



@ManagedBean(name = "plateForm")
@ViewScoped
public class PlateForm extends AbstractMaintenanceForm<String, Plate> {
	
	@EJB 
	private IPlateSvc plateSvc;
	
	@EJB
	private IPlateVersionSvc plateVersionSvc;
	
	@EJB 
	private IRunSvc runSvc;
	
	@EJB
	private IStudySvc studySvc;
	
	private Map<String,String> rows;
	
	private Map<String,String> cols;
	
	private Map<String,Map<String,Boolean>> vals;
	
	private List< Map<String,Map<String,Boolean>>> valLst;
	
	private Run run;

	private List<PlateVersion> plateVersns;
									
	public Run getRun() {
		return run;
	}

	public void setRun(Run run) {
		this.run = run;
	}

	public List<PlateVersion> getPlateVersns() {
		return plateVersns;
	}

	public void setPlateVersns(List<PlateVersion> plateVersns) {
		this.plateVersns = plateVersns;
	}

	public Map<String, String> getRows() {
		return rows;
	}

	public void setRows(Map<String, String> rows) {
		this.rows = rows;
	}

	public Map<String, String> getCols() {
		return cols;
	}

	public void setCols(Map<String, String> cols) {
		this.cols = cols;
	}
	
	public Map<String, Map<String, Boolean>> getVals() {
		return vals;
	}

	public void setVals(Map<String, Map<String, Boolean>> vals) {
		this.vals = vals;
	}

	public IStudySvc getStudySvc() {
		System.out.println("in plateform");
		return studySvc;
	}

	public void setStudySvc(IStudySvc studySvc) {
		this.studySvc = studySvc;
	}
			
	public IRunSvc getRunSvc() {
		return runSvc;
	}

	public void setRunSvc(IRunSvc runSvc) {
		this.runSvc = runSvc;
	}

	public IPlateSvc getPlateSvc() {
		return plateSvc;
	}

	public void setPlateSvc(IPlateSvc plateSvc) {
		this.plateSvc = plateSvc;
	}
				
	public IPlateVersionSvc getPlateVersionSvc() {
		return plateVersionSvc;
	}

	public void setPlateVersionSvc(IPlateVersionSvc plateVersionSvc) {
		this.plateVersionSvc = plateVersionSvc;
	}
	
	public List<Map<String, Map<String, Boolean>>> getValLst() {
		return valLst;
	}

	public void setValLst(List<Map<String, Map<String, Boolean>>> valLst) {
		this.valLst = valLst;
	}

	@Override
	public List<Plate> getDefaultSearchResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityBusinessName() {
		return "plate";
	}

	@Override
	public IService getService() {
		return plateSvc;
	}

	@Override
	public Plate getNewOne() {
		Study study = new Study();
		Run run = new Run();
		run.setStudy(study);
		Plate plate = new Plate();
		plate.setRun(run);
		return plate;
	}
	
	@Override
	public void viewNewOne()
	{
		super.viewNewOne();
		getSessionModel().getModel().setRun(run);
		loadPlateElms();
	}
	
	@PostConstruct
	public void init() {
		
		loadPlateElms();
	}
	
	public void loadPlateElms() {
		rows = new LinkedHashMap<>();
		rows.put("1", "A");
		rows.put("2", "B");
		rows.put("3", "C");
		rows.put("4", "D");
		rows.put("5", "E");
		rows.put("6", "F");
		rows.put("7", "G");
		rows.put("8", "H");

		cols = new LinkedHashMap<>();
		cols.put("1", "1");
		cols.put("2", "2");
		cols.put("3", "3");
		cols.put("4", "4");
		cols.put("5", "5");
		cols.put("6", "6");
		cols.put("7", "7");
		cols.put("8", "8");
		cols.put("9", "9");
		cols.put("10", "10");
		cols.put("11", "11");
		cols.put("12", "12");

		vals = new HashMap<>();
		for (String col : cols.keySet()) {
			vals.put(col, new HashMap<String, Boolean>());
		}

	}

	@Override
	public String save() {
		List<PlateElement> pElmntList = new ArrayList<PlateElement>();  
				
		Iterator<Map.Entry<String, Map<String, Boolean>>> eItr = getVals().entrySet().iterator();
		while (eItr.hasNext()) {
			Map.Entry<String, Map<String, Boolean>> entry = eItr.next();
			String col = entry.getKey();
			Map<String, Boolean> val = entry.getValue();
			Iterator<Map.Entry<String, Boolean>> itr = val.entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry<String, Boolean> entryI = (Map.Entry<String, Boolean>) itr.next();
				String row = entryI.getKey();
				Boolean value = entryI.getValue();
				//if (value) {
					PlateElement pElmnt = new PlateElement();
					pElmnt.setRow(row);
					pElmnt.setColumn(col);
					pElmnt.setValue((value) ? "1" : "0");
					pElmnt.setPlateId(getSessionModel().getModel().getId());
					pElmntList.add(pElmnt);
				//}

			}

		}
		getSessionModel().getModel().setPlateElmns(pElmntList);
		plateSvc.update(getSessionModel().getModel());
		PlateVersion plateVer = new PlateVersion();
		plateVer.setPlateId(getSessionModel().getModel().getId());
		plateVer.setPlateElmns(pElmntList.toString());
		plateVersionSvc.create(plateVer);
		viewOne(getSessionModel().getModel());
		return null;

	}
	
	@Override
	public void viewOne(Plate plate) {
		super.viewOne(plate);
		vals=new HashMap<>();
		Map<String,Boolean> historyData;
		Map<String,Map<String,Boolean>> historyMap = new HashMap<>();
		Map<String,Boolean> data;
		for (PlateElement pElm : plate.getPlateElmns()) {

			if (!vals.containsKey(pElm.getColumn())) {
				data = new HashMap<String, Boolean>();
				data.put(pElm.getRow(), (pElm.getValue().equals("1")) ? true : false);
				vals.put(pElm.getColumn(), data);
			} else {
				data = vals.get(pElm.getColumn());
				data.put(pElm.getRow(), (pElm.getValue().equals("1")) ? true : false);
				vals.put(pElm.getColumn(), data);

			}
		}
		plateVersns = plateVersionSvc.findByPlateId(plate.getId());
		valLst= new ArrayList<Map<String,Map<String,Boolean>>>();
		for(PlateVersion pVer:plateVersns)
		{
			try {
				JSONArray array = new JSONArray(pVer.getPlateElmns());
				for (int i = 0; i < array.length(); i++) {
					JSONObject jsonObj = array.getJSONObject(i);

					Iterator<?> it = jsonObj.keys();
					while (it.hasNext()) {
						String key = it.next().toString();
						String val = jsonObj.get(key).toString();
						if (!historyMap.containsKey(jsonObj.getString("column"))) {
							historyData = new HashMap<String, Boolean>();
							historyData.put(jsonObj.getString("row"), jsonObj.get("value").equals("1") ? true : false);
							historyMap.put(jsonObj.getString("column"), historyData);

						} else {
							historyData = historyMap.get(jsonObj.get("column"));
							historyData.put(jsonObj.getString("row"), jsonObj.get("value").equals("1") ? true : false);
							historyMap.put(jsonObj.getString("column"), historyData);
						}

					}
				}
				valLst.add(historyMap);
				historyMap = new HashMap<>();
			} catch (org.json.JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
