package com.kach.tuts.services;

import com.kach.tuts.domain.Hashtag;
import com.kach.tuts.services.interfaces.HashtagService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HashtagServiceImpl implements HashtagService {
    //Хранилище тегов
    private static final HashMap<String , Hashtag> HASHTAG_REPOSITORY_MAP = new HashMap<>();
   @Override
    public void createHashtag(String nameHashtag, Hashtag hashtag){
       hashtag.setName(nameHashtag);
       HASHTAG_REPOSITORY_MAP.put(nameHashtag,hashtag);
    }
   @Override
    public boolean deleteHashtag(Hashtag hashtag){
       return HASHTAG_REPOSITORY_MAP.remove(hashtag)!=null;
   }
   @Override
    public boolean uptadeHashtag(String newName, Hashtag hashtag){
       if (HASHTAG_REPOSITORY_MAP.containsKey(newName)){
           hashtag.setName(newName);
           HASHTAG_REPOSITORY_MAP.put(newName,hashtag);
           return true;
       }
       return false;
    }
    @Override
    public boolean chekHashtag(String chekName, Hashtag hashtag){
        return HASHTAG_REPOSITORY_MAP.containsKey(chekName) || HASHTAG_REPOSITORY_MAP.containsValue(hashtag);
    }
}
