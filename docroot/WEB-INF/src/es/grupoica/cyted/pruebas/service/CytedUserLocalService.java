package es.grupoica.cyted.pruebas.service;

import com.liferay.portal.service.UserLocalServiceWrapper;
import com.liferay.portal.service.UserLocalService;

public class CytedUserLocalService extends UserLocalServiceWrapper {
	/* (non-Java-doc)
	 * @see com.liferay.portal.service.UserLocalServiceWrapper#UserLocalServiceWrapper(UserLocalService userLocalService)
	 */
	public CytedUserLocalService(UserLocalService userLocalService) {
		super(userLocalService);
	}

}