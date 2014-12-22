package org.ecjfh.bo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;
import org.ecjfh.dao.EmpresaDAO;
import org.ecjfh.model.Empresa;
import org.ecjfh.model.Filial;
import org.ecjfh.model.Matriz;
import org.ecjfh.util.ImageUtil;
import org.ecjfh.validation.EmpresaValidation;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class EmpresaManagedBean implements java.io.Serializable{
	
	private StreamedContent listImage = null;

	private static Logger log = Logger.getLogger(EmpresaManagedBean.class);

	private static final long serialVersionUID = 1L;

	private String matriz;
	
	private String selectedCNPJ;
	
	private String razaoSocial;
	private String CNPJ;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String municipio;
	private String uf;
	private String telefone1;
	private String telefone2;
	private String email;
	private String fax;
	private String msg;
	private String tipo;
	private Integer total;

	private Part contrato;
	private Part logotipo;
	
	private String strContrato;
	private String strLogotipo;
	
	private EmpresaManagedBean empresaBack;
	
	private boolean matrizFilial;
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Integer getTotal() {
		return total;
	}
	public boolean isMatrizFilial() {
		return matrizFilial;
	}
	public void setMatrizFilial(boolean matrizFilial) {
		this.matrizFilial = matrizFilial;
	}
	public String getMatriz() {
		return matriz;
	}
	public void setMatriz(String matriz) {
		this.matriz = matriz;
	}
	public String getSelectedCNPJ() {
		return selectedCNPJ;
	}
	public void setSelectedCNPJ(String selectedCNPJ) {
		this.selectedCNPJ = selectedCNPJ;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    public String navigateCreate() {
    	return "insert";
    }

    public String navigateIndex() {
    	return "index";
    }
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public EmpresaManagedBean getEmpresaBack() {
		return empresaBack;
	}
	public void setEmpresaBack(EmpresaManagedBean empresaBack) {
		this.empresaBack = empresaBack;
	}
	
	public Part getContrato() {
		return contrato;
	}
	public void setContrato(Part contrato) {
		this.contrato = contrato;
	}

	public Part getLogotipo() {
		return logotipo;
	}
	public void setLogotipo(Part logotipo) {
		this.logotipo = logotipo;
	}

	public String getStrContrato() {
		return strContrato;
	}
	public void setStrContrato(String strContrato) {
		this.strContrato = strContrato;
	}
	public String getStrLogotipo() {
		return strLogotipo;
	}
	public void setStrLogotipo(String strLogotipo) {
		this.strLogotipo = strLogotipo;
	}
	
	public String selectToDelete(){
		
		this.getSelectedCNPJ();
		
		return "";
	}

    public void limparEmpresa() {
    	
    	log.info("Limpando empresa");
    	
    	this.setRazaoSocial("");
    	this.setCNPJ("");
    	this.setComplemento("");
    	this.setLogradouro("");
    	this.setFax("");
    	this.setTelefone1("");
    	this.setTelefone2("");
    	this.setMunicipio("");
    	this.setUf("");    	
    	this.setEmail("");  	
    	this.setNumero(null);
    	this.setMatriz("");
    }

    public String editEmpresa() {
    	log.info("Editando empresa "+this.getSelectedCNPJ());
    	
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = empresaDAO.getEmpresa(this.getSelectedCNPJ());
    	
    	if(empresa!=null){
    		this.setCNPJ(empresa.getCNPJ());
    		this.setRazaoSocial(empresa.getRazaoSocial());
    		this.setEmail(empresa.getEmail());
    		this.setMunicipio(empresa.getMunicipio());
    		this.setUf(empresa.getUf());
    		this.setLogradouro(empresa.getLogradouro());
    		this.setTelefone1(empresa.getTelefone1());
    		this.setTelefone2(empresa.getTelefone2());
    		this.setFax(empresa.getFax());
    		this.setComplemento(empresa.getComplemento());
    		this.setNumero(empresa.getNumero());
    		
    		if(empresa instanceof Matriz){
    			this.setMatrizFilial(true);
    		}else if(empresa instanceof Filial){
    			this.setMatrizFilial(false);
    			this.setMatriz(((Filial)empresa).getMatriz().getCNPJ());
    		}
    	}else{
    		this.setMsg("Empresa nao encontrada!");
    		log.error("Empresa nao encontrada!");
    	}
		
		
    	return "update";
    }
    public void preencherEmpresa() {
    	
    	log.info("Preenchendo empresa " + this.getEmpresaBack().getCNPJ());

		EmpresaDAO empresaDAO = new EmpresaDAO();
    	Empresa empresa = empresaDAO.getEmpresa(this.getEmpresaBack().getCNPJ());

    	if(empresa!=null){
    		this.setCNPJ(empresa.getCNPJ());
    		this.setRazaoSocial(empresa.getRazaoSocial());
    		this.setEmail(empresa.getEmail());
    		this.setMunicipio(empresa.getMunicipio());
    		this.setUf(empresa.getUf());
    		this.setLogradouro(empresa.getLogradouro());
    		this.setTelefone1(empresa.getTelefone1());
    		this.setTelefone2(empresa.getTelefone2());
    		this.setFax(empresa.getFax());
    		this.setComplemento(empresa.getComplemento());
    		this.setNumero(empresa.getNumero());
    		
    		if(empresa instanceof Matriz){
    			this.setMatrizFilial(true);
    		}else if(empresa instanceof Filial){
    			this.setMatrizFilial(false);
    			this.setMatriz(((Filial)empresa).getMatriz().getCNPJ());
    		}

    	}else{
    		this.setMsg("Empresa nao encontrada!");
    		log.error("Empresa nao encontrada!");
    	}
    }
		
    public String createEmpresa() {

    	String str = "index";
    	
    	try{
    		String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
    		
    		//this.setStrContrato(ImageUtil.saveToDiskImage(contrato.getInputStream(), base +"/"+ contrato.getSubmittedFileName()));

        	try{
        		this.setStrLogotipo(ImageUtil.saveToDiskImage(logotipo.getInputStream(), logotipo.getSubmittedFileName(), path));
        	}catch(Exception e){
        		log.error(e);
        	}
    		Empresa empresaModel  =  EmpresaValidation.transformBOModel(this);
    		
    		EmpresaDAO empresaDAO = new EmpresaDAO();
    		empresaDAO.createEmpresa(empresaModel); 
    		
    		limparEmpresa();
    		this.setMsg("Empresa cadastrada!");
    	}catch(Exception e){
    		this.setMsg(e.getMessage());
    		str = "insert";
    		log.error(e);
    	}
    	
    	return str;
    }

	public String deleteEmpresa(){
    	
    	log.info("Excluindo empresa "+this.getSelectedCNPJ());
    	
    	String str = "index";
    	
    	try{
    		EmpresaDAO empresaDAO = new EmpresaDAO();
    		empresaDAO.deleteEmpresa(this.getSelectedCNPJ());
    		
    		limparEmpresa();
    		this.setMsg("Excluído com sucesso!");
    		
    	}catch(Exception e){
    		this.setMsg(e.getMessage());
    		log.error(e);
    	}	

    	return str;
	}
	
	public List<EmpresaManagedBean> getListaMatrizes(){

    	log.info("Listando matrizes");
    	
		List<EmpresaManagedBean> empresas = new ArrayList<EmpresaManagedBean>();
		
    	try{
    		EmpresaDAO empresaDAO = new EmpresaDAO();
    		
    		for(Matriz matriz:empresaDAO.listMatrizes()){
    			empresas.add(EmpresaValidation.transformModelBO(matriz,true));
    		}

    	}catch(Exception e){
    		this.setMsg(e.getMessage());
    		log.error(e);
    	}
    	
		return empresas;
	}
	
	public List<EmpresaManagedBean> getListaEmpresas(){
		
		limparEmpresa();
    	
    	log.info("Listando empresa");
    	
		List<EmpresaManagedBean> empresas = new ArrayList<EmpresaManagedBean>();
		
    	try{
    		EmpresaDAO empresaDAO = new EmpresaDAO();
    		
    		for(Matriz matriz:empresaDAO.listMatrizes()){
    			empresas.add(EmpresaValidation.transformModelBO(matriz,true));
    			empresas.addAll(EmpresaValidation.transformModelBOListFiliais(matriz.getFiliais()));
    		}

    	}catch(Exception e){
    		this.setMsg(e.getMessage());
    		log.error(e);
    	}
    	
		return empresas;	
	}
	
	public String updateEmpresa(){
    	String str = "index";
    	try{
    		EmpresaDAO empresaDAO = new EmpresaDAO();
    			
    		Empresa empresaModel  =  EmpresaValidation.transformBOModel(this);
    		
    		empresaDAO.updateEmpresa(empresaModel);	

    		limparEmpresa();
        	
    		this.setMsg("Atualizado com sucesso!");
    	}catch(Exception e){
    		this.setMsg(e.getMessage());
    		str = "deleteUpdate";
    		log.error(e);
    	}
    	
    	return str;
	}
	
    public StreamedContent getListImage() {
    	
    	FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
            try {
            	return new DefaultStreamedContent(new FileInputStream(strLogotipo));
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    	
        return listImage;
    }
    
}
