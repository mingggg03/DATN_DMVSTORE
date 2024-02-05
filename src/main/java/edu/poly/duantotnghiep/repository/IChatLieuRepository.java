package edu.poly.duantotnghiep.repository;

import edu.poly.duantotnghiep.model.ChatLieuModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IChatLieuRepository extends JpaRepository<ChatLieuModel, String> {
    ChatLieuModel findChatLieuModelById(String id);
}
