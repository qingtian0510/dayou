package com.evan.wj;

import com.evan.wj.dao.InsUserFansDao;
import com.evan.wj.pojo.InsUserFans;
import com.evan.wj.service.InsAccountService;
import com.evan.wj.service.InsUserFansService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

//    @Autowired
//    private InsUserFansDao insUserFansDao;
    @Autowired
    InsUserFansService insUserFansService;
    @Autowired
    InsAccountService insAccountService;

    @Override
    public void run(String... args) throws Exception {

//        insUserFansDao.save(new InsUserFans("name1", "full_name1", "www", 10, 100, 100, "beijing", "20221015", 0));
//        insUserFansDao.save(new InsUserFans("name2", "full_name2", "www2", 10, 100, 100, "hubei", "20221015", 0));
//        insUserFansDao.save(new InsUserFans("name3", "full_name3", "www3", 10, 100, 100, "henan", "20221015", 0));

//        logger.info("# of cities: {}", insUserFansDao.count());
//
//        logger.info("All cities fans:");
//        List<InsUserFans> fans = insUserFansDao.findAll();
//        logger.info("{}", fans);
//
//        logger.info("------------------------");
//
//        logger.info("All cities sorted by name in descending order");
//        List<InsUserFans> sortedCities;
//        sortedCities = insUserFansDao.findAll(Sort.by(Sort.Direction.DESC, "name"));
//        logger.info("{}", sortedCities);
//
//        logger.info("------------------------");
//
//        logger.info("Deleting all cities");
//        insUserFansDao.deleteAllInBatch();
//
//        logger.info("# of cities: {}", insUserFansDao.count());
//        insUserFansService.getFansByNameAndCountAndStore("qingtian42", 12);
        insAccountService.addAccountFromFile("/Users/tianbo/IdeaProjects/wj/src/main/java/com/evan/wj/data/account_20.txt");
    }
}
