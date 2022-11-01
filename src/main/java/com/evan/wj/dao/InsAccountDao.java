package com.evan.wj.dao;

import com.evan.wj.pojo.InsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InsAccountDao extends JpaRepository<InsAccount,Long> {
    List<InsAccount> findInsAccountsByUploadUserIdAndStatus(int upload_user_id, int status);

}
