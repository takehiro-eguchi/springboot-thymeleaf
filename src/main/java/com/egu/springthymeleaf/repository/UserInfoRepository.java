package com.egu.springthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egu.springthymeleaf.entity.UserInfo;

/**
 * ユーザー情報のレポジトリです。
 * @author takehiro
 *
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> { }
