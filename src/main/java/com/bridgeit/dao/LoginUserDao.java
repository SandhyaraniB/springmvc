package com.bridgeit.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.bridgeit.model.LoginInfo;
import com.bridgeit.model.User;


public class LoginUserDao implements UserDao 
{
	/**
	 * adds a new user to the users list
	 * @param user new user to add
	 * @return number of rows affected if user got added, otherwise 0
	 */
	public int addUser(User user) 
	{
		//An instance of Configuration allows the application to specify properties and mapping documents to be used when creating a SessionFactory
		Configuration config = new Configuration().configure().addAnnotatedClass(User.class);
		//The SessionFactory is a factory of session and client of ConnectionProvider. It holds second level cache (optional) of data
		
		SessionFactory sessionFactory = config.buildSessionFactory();
		//session is interface between application and database
	    Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		System.out.println(user);
		return 0;
		
	}

	/**
	 * verifies whether the user with the specified login credentials exists
	 * @param login user login credentials
	 * @return returns user instance if exists otherwise null
	 */
	public boolean checkUserIsPresent(LoginInfo login) 
	{
		boolean isValidUser = false;
		User user = null;
		Configuration config = new Configuration().configure().addAnnotatedClass(User.class);
		  @SuppressWarnings("deprecation")
		  SessionFactory sessionFactory=config.buildSessionFactory();
		  Session session=sessionFactory.openSession();
	        String hql="from User where email=? and password=?";
	        try
	        {
	            Query query=session.createQuery(hql);
	            query.setParameter(0,login.getEmail());
	            query.setParameter(1,login.getPassword());
	            user = (User)query.uniqueResult();
	            if(user != null)
	            	isValidUser = true;
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally{
	            session.close();
	        }
	        return isValidUser;
        
	}
	
	
}