package org.ecjfh.dao;

import org.ecjfh.model.Empresa;
import org.ecjfh.model.Filial;
import org.junit.Test;

public class EmpresaDAOTest {


	@Test
	public void createEmpresaSucesso() throws Exception{
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Filial filial = new Filial();
		filial.setCNPJ("333333333333");
		
		empresaDAO.createEmpresa(filial);
		
		for(Empresa empresa: empresaDAO.listEmpresas()){			
			System.out.print(empresa.getCNPJ());
		}
	}

	@Test
	public void deleteEmpresaSucesso() throws Exception{
		
		String cnpj="333333333333";

		EmpresaDAO empresaDAO = new EmpresaDAO();
		Filial filial = new Filial();
		filial.setCNPJ(cnpj);
		
		empresaDAO.createEmpresa(filial);
		
		for(Empresa empresa: empresaDAO.listEmpresas()){			
			System.out.print(empresa.getCNPJ());
		}
		
		empresaDAO.deleteEmpresa(cnpj);

		System.out.print(empresaDAO.listEmpresas().size());
	}

	@Test
	public void listEmpresasSucesso() throws Exception{

		String cnpj1="333333333333";

		EmpresaDAO empresaDAO = new EmpresaDAO();
		Filial filial1 = new Filial();
		filial1.setCNPJ(cnpj1);
		
		empresaDAO.createEmpresa(filial1);

		String cnpj2="444444444444444";
		
		Filial filial2 = new Filial();
		filial2.setCNPJ(cnpj2);
		
		empresaDAO.createEmpresa(filial2);
		
		for(Empresa empresa: empresaDAO.listEmpresas()){			
			System.out.print(empresa.getCNPJ());
		}
	}

	@Test
	public void updateEmpresaSucesso() throws Exception{

		String cnpj1="333333333333";

		EmpresaDAO empresaDAO = new EmpresaDAO();
		Filial filial1 = new Filial();
		filial1.setCNPJ(cnpj1);
		
		empresaDAO.createEmpresa(filial1);

		Filial filial2 = new Filial();
		filial2.setCNPJ(cnpj1);
		filial2.setRazaoSocial("razaoSocial");
		
		empresaDAO.updateEmpresa(filial2);

		for(Empresa empresa: empresaDAO.listEmpresas()){			
			System.out.print(empresa.getRazaoSocial());
		}
	}

}
