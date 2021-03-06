package com.da.repository;

import com.da.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>, JpaSpecificationExecutor<Notification> {

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_baiviet=?1  and  noti.is_read=?2 ")
    List<Notification> isUnReadShowAll(Integer idBV, Integer read);

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_the=?1")
    List<Notification> getAllByIdThe(Integer idThe);

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_baiviet=?1 and noti.is_read =0")
    List<Notification> getAllNeedReadByIdThe(Integer idBaiViet);

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_the=?1 and noti.id_action =1 and noti.id_baiviet=?2")
    List<Notification> checkAlreadyLike(Integer idThe, Integer idBV);

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_the=?1 and noti.id_action =2 and noti.id_baiviet=?2")
    List<Notification> checkAlreadyDisLike(Integer idThe, Integer idBV);

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_the=?1 and noti.id_baiviet=?2")
    List<Notification> readIdBV(Integer idBV);

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_the=?1 and noti.id_action =7 and noti.id_baiviet=?2 and noti.id_comment=?3")
    List<Notification> checkAlreadyLikeCM(Integer idThe, Integer idBV, Integer idCM);

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_the=?1 and noti.id_action =8 and noti.id_baiviet=?2 and noti.id_comment=?3")
    List<Notification> checkAlreadyDisLikeCM(Integer idThe, Integer idBV, Integer idCM);

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_the=?1 and noti.id_action =9 and noti.id_baiviet=?2 and noti.id_rep_comment=?3")
    List<Notification> checkAlreadyLikeRECM(Integer idThe, Integer idBV, Integer idRECM);

    @Query(nativeQuery = true, value = "select  * from notification as noti where noti.id_the=?1 and noti.id_action =10 and noti.id_baiviet=?2 and noti.id_rep_comment=?3")
    List<Notification> checkAlreadyDisLikeRECM(Integer idThe, Integer idBV, Integer idRECM);

}
