package com.kach.tuts.services;

import com.kach.tuts.domain.Hashtag;
import com.kach.tuts.services.interfaces.HashtagService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HashtagServiceImpl implements HashtagService {
    //Хранилище тегов
    private static final HashMap<String , Hashtag> Hashtag_REPOSITORY_MAP = new HashMap<>();
   @Override
    public void createHashtag(String NameHashtag, Hashtag hashtag){
       hashtag.setName(NameHashtag);
       Hashtag_REPOSITORY_MAP.put(NameHashtag,hashtag);
   }
   @Override
    public boolean deleteHashtag(Hashtag hashtag){
       return Hashtag_REPOSITORY_MAP.remove(hashtag)!=null;
   }
   @Override
    public boolean uptadeHashtag(String NewName, Hashtag hashtag){
       if (Hashtag_REPOSITORY_MAP.containsKey(NewName)){
           hashtag.setName(NewName);
           Hashtag_REPOSITORY_MAP.put(NewName,hashtag);
           return true;
       }
       return false;
    }
    @Override
    public boolean chekHashtag(String ChekName, Hashtag hashtag){
        return Hashtag_REPOSITORY_MAP.containsKey(ChekName) | Hashtag_REPOSITORY_MAP.containsValue(hashtag);
    }
}
