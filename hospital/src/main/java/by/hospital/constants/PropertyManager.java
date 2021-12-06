package by.hospital.constants;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertyManager {

	private static volatile PropertyManager instance;
	private ResourceBundle resourceBundle;
	private static final String BUNDLE = "resources.config";

	public static PropertyManager getInstance() {
		PropertyManager localInstance = instance;
		if (localInstance == null) {
			synchronized (PropertyManager.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new PropertyManager();
				}
			}
		}
		return localInstance;
	}

	public String getProperty(String property) {
		if (resourceBundle == null) {
			instance.setResourceBundle(ResourceBundle.getBundle(BUNDLE,Locale.ROOT));
		}
		return resourceBundle.getString(property);
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

}
