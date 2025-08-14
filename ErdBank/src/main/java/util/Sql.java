package util;

public class Sql {

	// customer
	public final static String SELECT_CUSTOMER_BY_NO_AND_NAME = "select * from bank_customer where c_no=? and c_name=?";
	
	// account
	public final static String SELECT_ALL_ACCOUNT_WITH_NAME = "select a.*, c.c_name from bank_account a join bank_customer c on a.a_c_no = c.c_no ";
}
