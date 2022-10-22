package com.evan.wj.dao;

import com.evan.wj.pojo.InsUserFans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsUserFansDao extends JpaRepository<InsUserFans,Integer> {
//    List<InsUserFans> findInsUserFansByOperator_id(int operator_id);
//    List<InsUserFans> findInsUserFansByOperator_idAndCollect_group_type(int operator_id, int collect_group_type);

}
