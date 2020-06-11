package com.da.repository;

import com.da.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>, JpaSpecificationExecutor<Notification> {

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_the=?1  and  noti.read=?2")
    List<Notification> isUnReadShowAll(Integer idThe, boolean read);

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_the=?1")
    List<Notification> getAllByIdThe(Integer idThe);
}
