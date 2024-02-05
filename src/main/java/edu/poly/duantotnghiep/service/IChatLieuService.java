package edu.poly.duantotnghiep.service;

import edu.poly.duantotnghiep.dto.reponse.ChatLieuResponse;
import edu.poly.duantotnghiep.dto.request.ChatLieuRequest;
import edu.poly.duantotnghiep.model.ChatLieuModel;

import java.util.List;

public interface IChatLieuService {
    List<ChatLieuResponse> findAll();

    ChatLieuRequest save(ChatLieuRequest request);

    ChatLieuModel findById(String s);

    ChatLieuRequest update(ChatLieuRequest request, String id);

    boolean existsById(String s);

    void deleteById(String s);
}
