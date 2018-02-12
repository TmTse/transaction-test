package org.transaction.test.local_transaction.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.transaction.test.local_transaction.mybatis.bean.User1;
import org.transaction.test.local_transaction.mybatis.bean.User2;
import org.transaction.test.local_transaction.mybatis.service.TransactionPropagationExample;
import org.transaction.test.local_transaction.mybatis.service.User1Service;
import org.transaction.test.local_transaction.mybatis.service.User2Service;

@Service
public class TransactionPropagationExampleImpl implements TransactionPropagationExample {
	@Autowired
	private User1Service user1Service;
	@Autowired
	private User2Service user2Service;
	
	
	@Override
	public void truncated() {
		user1Service.truncate();
		user2Service.truncate();
	}
	
	
	@Override
	public void notransaction_exception_notransaction_notransaction(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.add(user2);
		throw new RuntimeException();
	}
	
	
	@Override
	public void notransaction_notransaction_notransaction_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addException(user2);
	}
	
	
	@Override
	@Transactional
	public void transaction_exception_notransaction_notransaction(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.add(user2);
		throw new RuntimeException();
	}
	
	
	@Override
	@Transactional
	public void transaction_notransaction_notransaction_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addException(user2);
	}
	
	/**
	 * 没有事务注解。
	 */
	@Override
	public void notransaction_required_required(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequired(user2);
	}
	
	
	@Override
	public void notransaction_addRequired_getRequired_get(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		User1 temp1=user1Service.getRequired(1);
		if(temp1!=null){
			System.out.println("getRequired可见");
		}
		User1 temp2=user1Service.get(1);
		
		if(temp2!=null){
			System.out.println("get可见");
		}
	}
	
	/**
	 * 方法本身抛出异常
	 */
	@Override
	public void notransaction_exception_required_required(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequired(user2);
		
		throw new RuntimeException();
	}
	
	
	/**
	 * 调用方法抛出异常
	 */
	@Override
	public void notransaction_required_required_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiredException(user2);
	}
	
	/**
	 * 方法本身抛出异常
	 */
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_required_required(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequired(user2);
		
		throw new RuntimeException();
	}
	
	
	/**
	 * 调用方法抛出异常
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_required_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiredException(user2);
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_addRequired_getRequired_get(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User1 temp1=user1Service.getRequired(1);
		if(temp1!=null){
			System.out.println("getRequired可见");
		}
		User1 temp2=user1Service.get(1);
		
		if(temp2!=null){
			System.out.println("get可见");
		}
		
	
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_addRequired_getNested_get(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User1 temp1=user1Service.getNested(1);
		if(temp1!=null){
			System.out.println("getNested可见");
		}
		User1 temp2=user1Service.get(1);
		
		if(temp2!=null){
			System.out.println("get可见");
		}
	}
	
	
	@Override
	public void notransaction_supports_supports_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addSupports(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addSupportsException(user2);
	}
	
	@Override
	public void notransaction_exception_supports_supports(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addSupports(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addSupports(user2);
		throw new RuntimeException();
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_supports_supports_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addSupports(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addSupportsException(user2);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_supports_supports(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addSupports(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addSupports(user2);
		
		throw new RuntimeException();
	}
	
	
	
	@Override
	public void notransaction_requiresNew_requiresNew_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequiresNew(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiresNewException(user2);
	}
	
	@Override
	public void notransaction_exception_requiresNew_requiresNew(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequiresNew(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiresNew(user2);
		throw new RuntimeException();
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_requiresNew_requiresNew_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiresNew(user2);
		
		User2 user3=new User2();
		user3.setName("王五");
		user2Service.addRequiresNewException(user3);
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_required_requiresNew_requiresNew_exception_try(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiresNew(user2);
		User2 user3=new User2();
		user3.setName("王五");
		try {
			user2Service.addRequiresNewException(user3);
		} catch (Exception e) {
			System.out.println("回滚");
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void transaction_exception_required_requiresNew_requiresNew(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addRequiresNew(user2);
		
		User2 user3=new User2();
		user3.setName("王五");
		user2Service.addRequiresNew(user3);
		
		throw new RuntimeException();
	}
	
	
	@Transactional
	@Override
	public void transaction_addRequired_getRequiresNew_get(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User1 temp1=user1Service.getRequiresNew(1);
		if(temp1!=null){
			System.out.println("getRequiresNew可见");
		}
		User1 temp2=user1Service.get(1);
		
		if(temp2!=null){
			System.out.println("get可见");
		}
	}	
	
	
	@Override
	public void notransaction_exception_required_notSuppored(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNotSupported(user2);
		throw new RuntimeException();
	}
	
	@Override
	public void notransaction_required_notSuppored_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNotSupportedException(user2);
	}
	
	@Transactional
	@Override
	public void transaction_exception_required_notSuppored(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNotSupported(user2);
		throw new RuntimeException();
	}	
	
	@Transactional
	@Override
	public void transaction_required_notSuppored_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNotSupportedException(user2);
	}
	
	
	@Transactional
	@Override
	public void transaction_addRequired_getNotSuppored_get(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User1 temp1=user1Service.getNotSupported(1);
		if(temp1!=null){
			System.out.println("getRequired可见");
		}
		User1 temp2=user1Service.get(1);
		
		if(temp2!=null){
			System.out.println("get可见");
		}
	}	

	
	@Override
	public void notransaction_mandatory(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addMandatory(user1);
	}
	
	@Transactional
	@Override
	public void transaction_exception_mandatory_mandatory(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addMandatory(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addMandatory(user2);
		throw new RuntimeException();
	}
	
	
	@Transactional
	@Override
	public void transaction_mandatory_mandatory_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addMandatory(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addMandatoryException(user2);
	}
	

	
	@Override
	public void notransaction_exception_never_never(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNever(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNever(user2);
		throw new RuntimeException();
	}
	
	@Override
	public void notransaction_never_never_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNever(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNeverException(user2);
	}
	
	@Transactional
	@Override
	public void transaction_never(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNever(user1);
	}
	
	
	@Transactional
	@Override
	public void transaction_exception_nested_nested(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNested(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNested(user2);
		throw new RuntimeException();
	}
	
	@Transactional
	@Override
	public void transaction_nested_nested_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNested(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNestedException(user2);
	}
	
	
	@Override
	public void notransaction_exception_nested_nested(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNested(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNested(user2);
		throw new RuntimeException();
	}
	
	@Override
	public void notransaction_nested_nested_exception(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNested(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		user2Service.addNestedException(user2);
	}
	
	@Transactional
	@Override
	public void transaction_nested_nested_exception_try(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addNested(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		try {
			user2Service.addNestedException(user2);
		} catch (Exception e) {
			System.out.println("方法回滚");
		}
	}
	
	@Transactional
	@Override
	public void transaction_required_required_exception_try(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.addRequired(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		try {
			user2Service.addRequiredException(user2);
		} catch (Exception e) {
			System.out.println("方法回滚");
		}
	}
	
	@Transactional
	@Override
	public void transaction_noTransaction_noTransaction_exception_try(){
		User1 user1=new User1();
		user1.setName("张三");
		user1Service.add(user1);
		
		User2 user2=new User2();
		user2.setName("李四");
		try {
			user2Service.addException(user2);
		} catch (Exception e) {
			System.out.println("方法回滚");
		}
	}
}
