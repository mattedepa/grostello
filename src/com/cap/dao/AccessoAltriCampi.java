package com.cap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.cap.hibernateUtil.HibernateUtil;
import com.cap.model.AltriDati;
import com.cap.model.Contatto;

public class AccessoAltriCampi {
	
	
	public void DeleteAltriCampiDiContatto(int valore_id_contatto)
	{

		Session session = null;
		List<Contatto> list = null;
		try
		{
		System.out.println("faccio DeleteAltriCampiDiContatto hibernate");
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		NativeQuery<Contatto> query = session.createNativeQuery("DELETE FROM ALTRI_CAMPI WHERE ID_CONTATTO = :IDC");
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
	
	
	public void ModifyCampo(String nuovo_val , int id_camp)
	{
		
		Session session = null;
		
		try
		{
		System.out.println("faccio ModifyCampo hibernate");
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		NativeQuery<Contatto> query = session.createNativeQuery("UPDATE ALTRI_CAMPI SET VALORE_CAMPO = :NVAL WHERE ID_ALTRO_CAMPO = :IDC");
		query.setParameter("NVAL", nuovo_val);
		query.setParameter("IDC", id_camp);
		
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
	
	
	public void DeleteUnCampo(int valore_id_campo)
	{

			Session session = null;
			try
			{
			System.out.println("faccio DeleteContatto hibernate");
			
			session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			
			NativeQuery<Contatto> query = session.createNativeQuery("DELETE FROM ALTRI_CAMPI WHERE ID_ALTRO_CAMPO = :ID");
			query.setParameter("ID", valore_id_campo);
		    
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
	
	public void AddUnCampo(String nome_campo , String valore_campo , int id_contatto )
	{
		 
		Session session = null;
		List<Contatto> list = null;
		try
		{
		System.out.println("faccio ModifyContatto hibernate");
		
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		NativeQuery<Contatto> query = session.createNativeQuery("INSERT INTO ALTRI_CAMPI ( NOME_CAMPO , VALORE_CAMPO , ID_CONTATTO) VALUES ( :NOM , :VAL , :ID)");
		query.setParameter("NOM", nome_campo);
		query.setParameter("VAL", valore_campo);
		query.setParameter("ID", id_contatto);
			    
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
