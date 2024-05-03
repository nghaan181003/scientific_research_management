package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Topic;

public class TopicDao {
	
	private static final String SELECT_ALL_DE_TAI =
	        "SELECT detai.*, trangthai.trangthai, nhomnghiencuu.matv " +
	        "FROM detai " +
	        "JOIN trangthai ON detai.MaTT = trangthai.MaTT " +
	        "JOIN nhomnghiencuu ON detai.MaNhom = nhomnghiencuu.MaNhom " +
	        "WHERE nhomnghiencuu.matv = ?";

	List<Topic> getAll(){
		List<Topic> allTopics = new ArrayList<>();
		return allTopics;
	}
	
	Topic get(int id)
	{
		return null;
	}
	
	List<Topic> myTopic (String username)
	{
		List<Topic> myTopics = new ArrayList<>();
		
		return null;
	}
}
