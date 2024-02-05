package edu.poly.duantotnghiep.service.impl;


import edu.poly.duantotnghiep.dto.reponse.ChatLieuResponse;
import edu.poly.duantotnghiep.dto.request.ChatLieuRequest;
import edu.poly.duantotnghiep.model.ChatLieuModel;
import edu.poly.duantotnghiep.repository.IChatLieuRepository;
import edu.poly.duantotnghiep.service.IChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatLieuServiceImpl implements IChatLieuService {
    @Autowired
    private IChatLieuRepository chatLieuRepository;

    public List<ChatLieuResponse> findAll() {
        return chatLieuRepository.findAll().stream()
                .map(m -> new ChatLieuResponse(m))
                .collect(Collectors.toList());
    }

    public ChatLieuRequest save(ChatLieuRequest request) {


            ChatLieuModel model = new ChatLieuModel();
            model.setId(request.getId());
            model.setTen(request.getTen());

            chatLieuRepository.save(model);

       return new ChatLieuRequest(model);
    }

    public ChatLieuModel findById(String s) {
        return chatLieuRepository.findChatLieuModelById(s);
    }

    @Override
    public ChatLieuRequest update(ChatLieuRequest request, String id) {
        ChatLieuModel model = chatLieuRepository.findChatLieuModelById(id);
        if(model != null){
            model.setId(id);
            model.setTen(request.getTen());
            chatLieuRepository.save(model);
        }
        return  new ChatLieuRequest(model);

    }

    public boolean existsById(String s) {
        return chatLieuRepository.existsById(s);
    }

    public void deleteById(String s) {
        chatLieuRepository.deleteById(s);
    }

}
