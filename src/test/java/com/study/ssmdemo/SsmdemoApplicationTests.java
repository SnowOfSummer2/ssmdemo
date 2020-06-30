package com.study.ssmdemo;

import com.study.ssmdemo.dao.BookDao;
import com.study.ssmdemo.dao.impl.JdbcAccountDaoImpl;
import com.study.ssmdemo.domain.Account;
import com.study.ssmdemo.domain.Book;
import com.study.ssmdemo.service.TestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@SpringBootTest

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:app-context.xml"})
class SsmdemoApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:app-context.xml");
        JdbcAccountDaoImpl service = (JdbcAccountDaoImpl) applicationContext.getBean("jdbcAccountDaoImpl");
        Account account = service.findByName("admin");
        System.out.println(account.getName());
    }

    @Test
    void testJpa(){
        Iterable<Book> books=bookDao.findAll();
        for (Book a:
             books) {
            System.out.println(a);
        }
    }
}
