package modelo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.Cliente;

public class ClienteDAO {
	
	public void insertarCliente( String nombre, String app, String apm, String cel, String email ) {
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session miSession=miFactory.openSession();
		try {
					Cliente cliente=new Cliente( nombre,app,apm,cel,email);
					miSession.beginTransaction();
					miSession.save(cliente);
					miSession.getTransaction().commit();
					System.out.println("Registrado correcto en la base de datos");
					miSession.beginTransaction();
					System.out.println("Lectura del registro con ID: "+cliente.getId_cliente());
					Cliente clienteInsertado=miSession.get(Cliente.class,cliente.getId_cliente());
					System.out.println("Registro:"+clienteInsertado);
					miSession.getTransaction().commit();
					System.out.println("Terminado");
		
					miSession.close();
		}finally
		{
				miFactory.close();
		}
	}

	public  ObservableList<Cliente>consultarCliente() {
			Session miSession=null;
			ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
			Cliente c1=new Cliente();
		try
		{
			SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
			miSession=miFactory.openSession();
			Query consulta=miSession.createQuery("from Cliente clientes");
			List<Cliente> lista=consulta.list();
			for(Cliente c:lista)
			{
				Cliente c2=new Cliente(c.getId_cliente(),c.nom_cliente,c.getApp_cliente(),c.getApm_cliente(),c.getCel_cliente(),c.getEmail_cliente());
				listaClientes.add(c);
			}
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
		}
		finally 
		{
			miSession.close();
		}
		return listaClientes;
		
	}
	
	public int consultarUltimoId() {
		int i=0;
		Session miSession=null;
	try
	{
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		miSession=miFactory.openSession();
		Query consulta=miSession.createQuery("from Cliente clientes");
		List<Cliente> lista=consulta.list();
		for(Cliente c:lista)
		{
				i++;
		}
	}
	catch(HibernateException ex)
	{
		ex.printStackTrace();
	}
	finally 
	{
		miSession.close();
	}
	return i;
		
	}
	
	public void consultarClientesPorId(String id) {
		Session miSession=null;
		try
		{
			SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
			miSession=miFactory.openSession();
			Query consulta=miSession.createQuery("from Cliente c WHERE c.id_cliente="+id);
			List<Cliente> lista=consulta.list();
			for(Cliente c:lista)
			{
				System.out.println(c);
			}
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
		}
		finally 
		{
			miSession.close();
		}
		
	}

	public void actualizarCliente(String nombre,String app, String apm, String cel, String email) {
		
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session miSession=miFactory.openSession();
		try
		{
			miSession.beginTransaction();
			miSession.createQuery("update Cliente as c set"+
			"nom_cliente=:"+nombre+","+
			"app_clinete=:"+app+","+
			"apm_clinete=:"+apm+","+
			"cel_clinete=:"+cel+","+
			"email_clinete=:"+email+",").executeUpdate();
			miSession.getTransaction().commit();
			
	
			
		}catch(HibernateException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			miSession.close();
		}
		
	}
	public void eliminarCliente(String id) {
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session miSession=miFactory.openSession();
					try
					{
						miSession.beginTransaction();
						miSession.createQuery("delete Cliente clientes where id_cliente='"+id+"'" ).executeUpdate();
						miSession.getTransaction().commit();
						
						System.out.println("Registro eliminado en la base de datos");
						
					}catch(HibernateException ex)
					{
						ex.printStackTrace();
					}
					finally
					{
						miSession.close();
					}
	}
		
	}

