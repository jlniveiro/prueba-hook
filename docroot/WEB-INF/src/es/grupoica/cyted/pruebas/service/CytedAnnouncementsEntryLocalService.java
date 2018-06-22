package es.grupoica.cyted.pruebas.service;

import com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceWrapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.announcements.model.AnnouncementsEntry;
import com.liferay.portlet.announcements.service.AnnouncementsEntryLocalService;

public class CytedAnnouncementsEntryLocalService extends AnnouncementsEntryLocalServiceWrapper {
	/* (non-Java-doc)
	 * @see com.liferay.portlet.announcements.service.AnnouncementsEntryLocalServiceWrapper#AnnouncementsEntryLocalServiceWrapper(AnnouncementsEntryLocalService announcementsEntryLocalService)
	 */
	public CytedAnnouncementsEntryLocalService(AnnouncementsEntryLocalService announcementsEntryLocalService) {
		super(announcementsEntryLocalService);
	}

	@Override
	public AnnouncementsEntry addAnnouncementsEntry(AnnouncementsEntry announcementsEntry) throws SystemException {
		// TODO Auto-generated method stub
		return super.addAnnouncementsEntry(announcementsEntry);
	}

	@Override
	public AnnouncementsEntry addEntry(long userId, long classNameId, long classPK, String title, String content,
			String url, String type, int displayDateMonth, int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, boolean displayImmediately, int expirationDateMonth, int expirationDateDay,
			int expirationDateYear, int expirationDateHour, int expirationDateMinute, int priority, boolean alert)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return super.addEntry(userId, classNameId, classPK, title, content, url, type, displayDateMonth, displayDateDay,
				displayDateYear, displayDateHour, displayDateMinute, displayImmediately, expirationDateMonth, expirationDateDay,
				expirationDateYear, expirationDateHour, expirationDateMinute, priority, alert);
	}

	
	
	
}