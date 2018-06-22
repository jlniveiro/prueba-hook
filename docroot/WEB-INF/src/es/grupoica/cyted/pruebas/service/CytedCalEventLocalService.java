package es.grupoica.cyted.pruebas.service;

import com.liferay.portlet.calendar.service.CalEventLocalServiceWrapper;
import com.liferay.portal.kernel.cal.TZSRecurrence;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.service.CalEventLocalService;

public class CytedCalEventLocalService extends CalEventLocalServiceWrapper {
	/* (non-Java-doc)
	 * @see com.liferay.portlet.calendar.service.CalEventLocalServiceWrapper#CalEventLocalServiceWrapper(CalEventLocalService calEventLocalService)
	 */
	public CytedCalEventLocalService(CalEventLocalService calEventLocalService) {
		super(calEventLocalService);
	}

	@Override
	public CalEvent addCalEvent(CalEvent calEvent) throws SystemException {
		// TODO Auto-generated method stub
		return super.addCalEvent(calEvent);
	}

	@Override
	public CalEvent addEvent(long userId, String title, String description, String location, int startDateMonth,
			int startDateDay, int startDateYear, int startDateHour, int startDateMinute, int durationHour,
			int durationMinute, boolean allDay, boolean timeZoneSensitive, String type, boolean repeating,
			TZSRecurrence recurrence, int remindBy, int firstReminder, int secondReminder,
			ServiceContext serviceContext) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return super.addEvent(userId, title, description, location, startDateMonth, startDateDay, startDateYear, startDateHour,
				startDateMinute, durationHour, durationMinute, allDay, timeZoneSensitive, type, repeating, recurrence, remindBy,
				firstReminder, secondReminder, serviceContext);
	}

	@Override
	public CalEvent deleteEvent(long eventId) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return super.deleteEvent(eventId);
	}

	@Override
	public void deleteEvents(long groupId) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		super.deleteEvents(groupId);
	}

	@Override
	public CalEvent updateCalEvent(CalEvent calEvent) throws SystemException {
		// TODO Auto-generated method stub
		return super.updateCalEvent(calEvent);
	}

	@Override
	public CalEvent updateEvent(long userId, long eventId, String title, String description, String location,
			int startDateMonth, int startDateDay, int startDateYear, int startDateHour, int startDateMinute,
			int durationHour, int durationMinute, boolean allDay, boolean timeZoneSensitive, String type,
			boolean repeating, TZSRecurrence recurrence, int remindBy, int firstReminder, int secondReminder,
			ServiceContext serviceContext) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return super.updateEvent(userId, eventId, title, description, location, startDateMonth, startDateDay, startDateYear,
				startDateHour, startDateMinute, durationHour, durationMinute, allDay, timeZoneSensitive, type, repeating,
				recurrence, remindBy, firstReminder, secondReminder, serviceContext);
	}
	
	
	

}