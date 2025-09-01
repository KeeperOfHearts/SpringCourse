package com.luv2code.aopdemo.dao;


import com.luv2code.aopdemo.Account;

public interface AccountDAO {
    public void addAccount(Account account, boolean vipFlag);

    public boolean doWork();

    public String getName() ;

    public void setName(String name) ;

    public String getServiceCode() ;

    public void setServiceCode(String serviceCode) ;
}
