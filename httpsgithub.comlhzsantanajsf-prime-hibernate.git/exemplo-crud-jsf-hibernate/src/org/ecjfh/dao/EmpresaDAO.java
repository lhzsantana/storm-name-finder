package org.ecjfh.dao;

import java.util.ArrayList;
import java.util.List;

import org.ecjfh.model.Empresa;
import org.ecjfh.model.Filial;
import org.ecjfh.model.Matriz;
import org.ecjfh.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpresaDAO {
	
	public void createEmpresa(Empresa empresa) throws Exception{
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(empresa);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            throw new Exception("Error ao criar empresa");
        } finally {
            session.flush();
            session.close();
        }
	}

	public Empresa getEmpresa(String cnpj){
		
		Empresa empresa = null;
		
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
             empresa = (Empresa) session.get(Empresa.class, new String(cnpj));
        } finally {
            session.flush();
            session.close();
        }
        
        return empresa;
	}

	public void deleteEmpresa(String empresaId) throws Exception{
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Empresa empresa = (Empresa) session.load(Empresa.class, new String(empresaId));
            
            if(empresa instanceof Filial){
            	((Filial) empresa).setMatriz(null);
            }
            
            session.delete(empresa);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            throw new Exception("Error ao excluir empresa");
        } finally {
            session.flush();
            session.close();
        }
	}
	
	@SuppressWarnings("unchecked")
	public List<Empresa> listEmpresas(){
		List<Empresa> empresas = new ArrayList<Empresa>();
			
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            empresas = session.createQuery("from Empresa").list();
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return empresas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Matriz> listMatrizes(){
		List<Matriz> matrizes = new ArrayList<Matriz>();
		
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            matrizes = session.createQuery("from Matriz").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return matrizes;
	}
	
	public void updateEmpresa(Empresa empresa) throws Exception{
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(empresa);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            throw new Exception("Error ao atualizar empresa");
        } finally {
            session.flush();
            session.close();
        }
	}
}
