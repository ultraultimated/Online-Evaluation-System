package com.cybage.onlineexamsystem.repository;

import com.cybage.onlineexamsystem.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

    @Query(value = "select test_id from tbl_parent_question where parent_question_id = (select parent_question_id from tbl_question where question_id=?1)", nativeQuery = true)
    int getTestIdFromQuesId(int qid);
}
