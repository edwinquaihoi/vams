package au.com.csl.vams.scaffold;

import com.google.gson.Gson;

public abstract class AbstractMasterEntity<K> implements IMasterPersistentEntity<K> {

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
