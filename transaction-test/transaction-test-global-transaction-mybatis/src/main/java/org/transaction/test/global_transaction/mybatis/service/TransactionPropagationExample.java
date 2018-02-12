package org.transaction.test.global_transaction.mybatis.service;

public interface TransactionPropagationExample {
	
	
	void truncated();
	
	void notransaction_required_required();

	
	void notransaction_exception_required_required();

	void notransaction_required_required_exception();


	void transaction_exception_required_required();

	void transaction_required_required_exception();

	void notransaction_supports_supports_exception();

	void transaction_supports_supports_exception();

	void notransaction_exception_supports_supports();

	void transaction_exception_supports_supports();

	void transaction_exception_required_requiresNew_requiresNew();

	void notransaction_exception_requiresNew_requiresNew();

	void notransaction_requiresNew_requiresNew_exception();

	void transaction_required_requiresNew_requiresNew_exception();

	void notransaction_exception_required_notSuppored();

	void notransaction_required_notSuppored_exception();

	void transaction_exception_required_notSuppored();

	void transaction_required_notSuppored_exception();

	void notransaction_exception_notransaction_notransaction();

	void notransaction_notransaction_notransaction_exception();

	void transaction_exception_notransaction_notransaction_user1();

	void transaction_notransaction_notransaction_exception();

	void notransaction_mandatory();

	void transaction_exception_mandatory_mandatory();

	void transaction_mandatory_mandatory_exception();

	void notransaction_exception_never_never();

	void notransaction_never_never_exception();

	void transaction_never();

	void transaction_exception_nested_nested();

	void transaction_nested_nested_exception();

	void transaction_nested_nested_exception_try();

	void transaction_required_required_exception_try();

	void transaction_noTransaction_noTransaction_exception_try();

	void transaction_required_requiresNew_requiresNew_exception_try();

	void transaction_exception_notransaction_notransaction_user2();

	void transaction_exception_notransaction_notransaction();

	
	

}