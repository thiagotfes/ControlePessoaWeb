package br.com.cpweb.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.cpweb.domain.Estado;
import br.com.cpweb.util.HibernateUtil;

public class EstadoDAO extends GenericDAO<Estado> {
	
	@SuppressWarnings("unchecked")
	public List<Estado> buscarPorPais(Long paisCodigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Estado.class);
			consulta.add(Restrictions.eq("pais.codigo", paisCodigo));	
			consulta.addOrder(Order.asc("nome"));
			List<Estado> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
}
