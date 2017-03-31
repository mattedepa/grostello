package com.cap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.cap.hibernateUtil.HibernateUtil;
import com.cap.model.*;

public class AccessoUtenti {
	
	public Utenti selectUtendeByUsername(String username)  //  MODIFICATO |||||||||||||||||||||||||||||||||||||||||||
	{
		Session session = null;
		Utenti utente = null;
		try
		{
		System.out.println("faccio selectUtendeByUsername hibernate");
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		NativeQuery<Utenti> query = session.createNativeQuery("SELECT * FROM UTENTI WHERE USERNAME=:USR");
		query.addEntity(Utenti.class);
	    query.setParameter("USR", username);
	    
	    utente = query.uniqueResult();	
		
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
			if(session != null && session.getTransaction()!= null)
				{
					session.getTransaction().rollback();
				}
		}
		finally{
		if(session != null)
		session.close();
		}
		
		System.out.println("Done");
		return utente;
		
		
	}
		  
		  
	public void AddUtente(Utenti utente)
	{
		
		Session session = null;
		List<Contatto> list = null;
		try
		{
		System.out.println("faccio AddContatto hibernate");
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		NativeQuery<Contatto> query = session.createNativeQuery("INSERT INTO UTENTI ( USERNAME , PSW ) VALUES ( :USR , :PSW )");
		query.setParameter("USR", utente.getUsername());
		query.setParameter("PSW", utente.getPassword());

	    
	    query.executeUpdate();
	    session.getTransaction().commit();
	    
		
		}
		catch (Exception e)
		{
			session.getTransaction().rollback();
			e.printStackTrace();
			if(session != null && session.getTransaction()!= null)
				{
					session.getTransaction().rollback();
				}
		}
		finally{
		if(session != null)
		session.close();
		}
		
		System.out.println("Done");  
		   
	}
	
	
}
