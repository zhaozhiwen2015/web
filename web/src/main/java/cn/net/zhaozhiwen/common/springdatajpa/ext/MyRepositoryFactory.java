package cn.net.zhaozhiwen.common.springdatajpa.ext;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;


public class MyRepositoryFactory extends JpaRepositoryFactory {

	public MyRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
	@Override
	@SuppressWarnings("unchecked")
	protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryMetadata metadata, EntityManager em) {

		Class<?> repositoryInterface = metadata.getRepositoryInterface();
		JpaEntityInformation<Object, Serializable> entityInformation = (JpaEntityInformation<Object, Serializable>)getEntityInformation(metadata.getDomainType());

		return new MyCustomRepository<Object, Serializable>(entityInformation, em);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.support.RepositoryFactorySupport#
	 * getRepositoryBaseClass()
	 */
	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {

		return MyCustomRepository.class;
	}
}
