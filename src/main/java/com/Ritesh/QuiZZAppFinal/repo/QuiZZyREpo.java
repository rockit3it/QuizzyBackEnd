package com.Ritesh.QuiZZAppFinal.repo;

import com.Ritesh.QuiZZAppFinal.entity.QuiZZyQuestion;
import com.Ritesh.QuiZZAppFinal.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuiZZyREpo extends JpaRepository<QuiZZyQuestion, Long>{

}