package Service;

import java.util.List;

import Dao.NotificationDao;
import Model.Notification;

public class NotificationService {
	NotificationDao notificationDao = new NotificationDao();
	
	public List<Notification> getByUserName(String username)
	{
		return notificationDao.getByUserName(username);
	}
	
	public Notification get(int id)
	{
		return notificationDao.get(id);
	}
}
