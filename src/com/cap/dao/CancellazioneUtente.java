package com.cap.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.cap.hibernateUtil.HibernateUtil;
import com.cap.model.Contatto;


public class CancellazioneUtente {
	
	
	public void eliminaUtente(int valore_id_contatto)
	{
		
		Session session = null;
		List<Contatto> list = null;
		try
		{
		System.out.println("faccio eliminaUtente hibernate");
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		NativeQuery<Contatto> query = session.createNativeQuery("CALL elimina_tutto_di_utente(:IDC)");
		query.setParameter("IDC", valore_id_contatto);
	    
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
