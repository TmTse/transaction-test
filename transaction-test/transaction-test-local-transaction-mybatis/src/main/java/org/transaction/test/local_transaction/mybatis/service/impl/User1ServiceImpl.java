package org.transaction.test.local_transaction.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.transaction.test.local_transaction.mybatis.bean.User1;
import org.transaction.test.local_transaction.mybatis.mapper.User1Mapper;
import org.transaction.test.local_transaction.mybatis.service.User1Service;

@Service
public class User1ServiceImpl implements User1Service {
	@Autowired
	private User1Mapper user1Mapper;
	
	public void truncate(){
		user1Mapper.truncated();
	}
	
	@Override
	public void add(User1 user){
		user1Mapper.insert(user);
	}
	
	@Override
	public User1 get(Integer id){
		return user1Mapper.selectByPrimaryKey(id);
	}
	
	@Override
	public void addException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	/* (non-Javadoc)
	 * @see org.transaction.test.local_transaction.mybatis.service.impl.User1Service#add(org.transaction.test.local_transaction.mybatis.bean.User1)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequired(User1 user){
		user1Mapper.insert(user);
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,readOnly=true)
	public User1 getRequired(Integer id){
		return user1Mapper.selectByPrimaryKey(id);
	}
	
	
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addRequiredException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void addSupports(User1 user){
		user1Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void addSupportsException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,readOnly=true)
	public User1 getRequiresNew(Integer id){
		return user1Mapper.selectByPrimaryKey(id);
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNew(User1 user){
		user1Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRequiresNewException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addNotSupported(User1 user){
		user1Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void addNotSupportedException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	public User1 getNotSupported(Integer id){
		return user1Mapper.selectByPrimaryKey(id);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void addMandatory(User1 user){
		user1Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void addMandatoryException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void addNever(User1 user){
		user1Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void addNeverException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void addNested(User1 user){
		user1Mapper.insert(user);
	}
	
	@Override
	@Transactional(propagation = Propagation.NESTED)
	public void addNestedException(User1 user){
		user1Mapper.insert(user);
		throw new RuntimeException();
	}
	
	
	@Override
	@Transactional(propagation = Propagation.NESTED,readOnly=true)
	public User1 getNested(Integer id){
		return user1Mapper.selectByPrimaryKey(id);
	}
}
