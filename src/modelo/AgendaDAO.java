package modelo;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AgendaDAO {

	public void insertarAgenda(String idtipoevento, String descripcion, Date fecha, Date hora ) {
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Agenda.class).buildSessionFactory();
		Session miSession=miFactory.openSession();
		try {
					Agenda expediente=new Agenda(Integer.parseInt(idtipoevento),descripcion, fecha,hora);
					miSession.beginTransaction();
					miSession.save(expediente);
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
	
	public void consultarAgenda() {
		Session miSession=null;
		try
		{
			SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Agenda.class).buildSessionFactory();
			miSession=miFactory.openSession();
			Query consulta=miSession.createQuery("from Agenda agenda");
			List<Agenda> lista=consulta.list();
			for(Agenda e:lista)
			{
				System.out.println(e);
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
	public void eliminarAgenda(String id) {
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Agenda.class).buildSessionFactory();
		Session miSession=miFactory.openSession();
					try
					{
						miSession.beginTransaction();
						miSession.createQuery("delete Agenda agenda where id_evento='"+id+"'" ).executeUpdate();
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
