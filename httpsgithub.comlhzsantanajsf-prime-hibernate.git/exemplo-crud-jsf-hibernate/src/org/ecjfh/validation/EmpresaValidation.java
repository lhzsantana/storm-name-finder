package org.ecjfh.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.ecjfh.bo.EmpresaManagedBean;
import org.ecjfh.dao.EmpresaDAO;
import org.ecjfh.model.Empresa;
import org.ecjfh.model.Filial;
import org.ecjfh.model.Matriz;

public class EmpresaValidation {

	public static Empresa transformBOModel(EmpresaManagedBean bo) {

		Empresa empresa = new Matriz();
		
		if(!bo.isMatrizFilial()){
			empresa = new Filial();
			EmpresaDAO dao = new EmpresaDAO();
			
			((Filial)empresa).setMatriz((Matriz)dao.getEmpresa(bo.getMatriz()));
		}
		
		empresa.setCNPJ(bo.getCNPJ());

		empresa.setRazaoSocial(bo.getRazaoSocial());
		empresa.setEmail(bo.getEmail());
		empresa.setMunicipio(bo.getMunicipio());
		empresa.setUf(bo.getUf());
		empresa.setLogradouro(bo.getLogradouro());
		empresa.setTelefone1(bo.getTelefone1());
		empresa.setTelefone2(bo.getTelefone2());
		empresa.setFax(bo.getFax());
		empresa.setComplemento(bo.getComplemento());
		empresa.setNumero(bo.getNumero());
		empresa.setLogotipo(bo.getStrLogotipo());
		//empresa.setContrato(bo.getStrContrato());
		
		return empresa;
	}
	
	public static EmpresaManagedBean transformModelBO(Empresa empresa, boolean matrizFilial) {

		EmpresaManagedBean bo = new EmpresaManagedBean();
		
		bo.setCNPJ(empresa.getCNPJ());
		bo.setRazaoSocial(empresa.getRazaoSocial());
		bo.setEmail(empresa.getEmail());
		bo.setMunicipio(empresa.getMunicipio());
		bo.setUf(empresa.getUf());
		bo.setLogradouro(empresa.getLogradouro());
		bo.setTelefone1(empresa.getTelefone1());
		bo.setTelefone2(empresa.getTelefone2());
		bo.setFax(empresa.getFax());
		bo.setComplemento(empresa.getComplemento());
		bo.setNumero(empresa.getNumero());

		//String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
		
		bo.setStrLogotipo(empresa.getLogotipo());
		
		if(matrizFilial){
			bo.setTipo("Matriz");
		}else{
			bo.setTipo("Filial");
		}
		
		return bo;
	}
	
	public static List<EmpresaManagedBean> transformModelBOListFiliais(Set<Filial> filiais) throws Exception {
		// TODO Auto-generated method stub
		List<EmpresaManagedBean> empresasBO = new ArrayList<EmpresaManagedBean>();
		
		for(Filial filial:filiais){
			EmpresaManagedBean bo = new EmpresaManagedBean();

			bo=transformModelBO(filial, false);
			bo.setMatrizFilial(false);
			
			empresasBO.add(bo);		
		}
		
		return empresasBO;
	}
}
