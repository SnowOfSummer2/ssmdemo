package com.study.ssmdemo.dao.impl;

import com.study.ssmdemo.dao.AccountRepository;
import com.study.ssmdemo.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcAccountDaoImpl implements AccountRepository {

    private static final String SELECT_ACCOUNT_SQL = "select id,name,password from account";

    @Autowired
    private JdbcOperations operations;

    @Override
    public Account findByName(String name) {
        List<Object> params = new ArrayList<>();
        params.add(name);
        return operations.queryForObject(SELECT_ACCOUNT_SQL + " where name=?"
                , ((resultSet, i) -> {
                    Account account = new Account();
                    account.setId(resultSet.getInt("id"));
                    account.setName(resultSet.getString("name"));
                    account.setPassword(resultSet.getString("password"));
                    return account;
                }), params.toArray());
    }
}
