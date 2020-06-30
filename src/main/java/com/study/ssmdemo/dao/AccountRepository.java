package com.study.ssmdemo.dao;

import com.study.ssmdemo.domain.Account;

public interface AccountRepository {
    Account findByName(String name);
}
