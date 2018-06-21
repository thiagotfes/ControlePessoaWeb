package br.com.cpweb.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.cpweb.domain.Produto;
import br.com.cpweb.util.HibernateUtil;

public class ProdutoDAO extends GenericDAO<Produto>{

	// COMANDO PARA BUSCAR
	public Produto buscarNome(String cdcodigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Produto.class);
			consulta.add(Restrictions.idEq(cdcodigo));
			Produto resultado = (Produto) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}
	
}
