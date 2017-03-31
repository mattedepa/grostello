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

public class AccessoContatti {
	
	public List<Contatto> SelectAllContattiDiUtente(int valore_id_utente)  // MODIFICATO ||||||||||||||||||||||||||||
	{
		Session session = null;
		List<Contatto> list = null;
		try
		{
		System.out.println("faccio SelectAllContattiDiUtente hibernate");
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		NativeQuery<Contatto> query = session.createNativeQuery("SELECT * FROM CONTATTI WHERE ID_UTENTE=:IDU");
		query.addEntity(Contatto.class);
	    query.setParameter("IDU", valore_id_utente);
	    
	    list = query.list();
	    
		
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
		return list;
		  
		   
	}

	

	public Contatto SelectContattoDiUtente(int valore_id_contatto)  // MODIFICATO ||||||||||||||||||||||||||||
	{
		Session session = null;
		Contatto contatto = null;
		try
		{
		System.out.println("faccio SelectContattoDiUtente hibernate");
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		NativeQuery<Contatto> query = session.createNativeQuery("SELECT * FROM CONTATTI WHERE ID_CONTATTO=:IDC");
		query.addEntity(Contatto.class);
	    query.setParameter("IDC", valore_id_contatto);
	    
	    contatto = query.uniqueResult();
	    
		
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
		return contatto;
		   
	}
	
	public void DeleteContatto(int valore_id_contatto)
	{
		
		Session session = null;
		List<Contatto> list = null;
		try
		{
		System.out.println("faccio DeleteContatto hibernate");
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		NativeQuery<Contatto> query = session.createNativeQuery("DELETE FROM CONTATTI WHERE ID_CONTATTO = :IDC");
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
	
	public void AddContatto(Contatto contatto)
	{
		Session session = null;
		List<Contatto> list = null;
		try
		{
		System.out.println("faccio AddContatto hibernate");
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		NativeQuery<Contatto> query = session.createNativeQuery("INSERT INTO CONTATTI ( NOME , COGNOME , CELLULARE , ID_UTENTE) VALUES ( :NOM , :COG , :CELL , :IDU)");
		query.setParameter("NOM", contatto.getNome());
		query.setParameter("COG", contatto.getCognome());
		query.setParameter("CELL", contatto.getCellulare());
		query.setParameter("IDU", contatto.getUtente().getIdUtente());
	    
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
		  
		   
	

	
	public void ModifyContatto(String nuovo_val , String nome_campo , int id_cont)  //   MODIFICATO |||||||||||||||||||||||||||
	{
		
		Session session = null;
		
		try
		{
		System.out.println("faccio ModifyContatto hibernate");
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		NativeQuery<Contatto> query = session.createNativeQuery("UPDATE CONTATTI SET " + nome_campo + " = :NUOVOVAL WHERE ID_CONTATTO = :IDC");
		query.setParameter("NUOVOVAL", nuovo_val);
		query.setParameter("IDC", id_cont);
	    
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
