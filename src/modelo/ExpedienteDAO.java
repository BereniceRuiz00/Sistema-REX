package modelo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExpedienteDAO {
	
	public void insertarExpediente(String idcliente, String nombre, String clase, String estado, String existencia) {
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Expediente.class).buildSessionFactory();
		Session miSession=miFactory.openSession();
		try {
					Expediente exp=new Expediente(Integer.parseInt(idcliente),nombre,clase,estado,existencia);
					miSession.beginTransaction();
					miSession.save(exp);
					miSession.getTransaction().commit();
					System.out.println("Registrado correcto en la base de datos");
					miSession.beginTransaction();
					miSession.getTransaction().commit();
					System.out.println("Terminado");
		
					miSession.close();
		}finally
		{
				miFactory.close();
		}
	}
	
	public void consultarExpediente() {
		Session miSession=null;
		try
		{
			SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Expediente.class).buildSessionFactory();
			miSession=miFactory.openSession();
			Query consulta=miSession.createQuery("from Expediente expediente");
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
	
	
	public void eliminarExpediente(String id) {
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Expediente.class).buildSessionFactory();
		Session miSession=miFactory.openSession();
					try
					{
						miSession.beginTransaction();
						miSession.createQuery("delete Expediente expediente where id_expediente='"+id+"'" ).executeUpdate();
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
