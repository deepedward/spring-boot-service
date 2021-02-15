package com.plan.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plan.code.bean.Event;

/**
 * @author deepakedward
 *
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


}
