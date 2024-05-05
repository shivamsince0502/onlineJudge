package com.example.coderock.service.serviceInfs;

import com.example.coderock.model.Tag;
import com.example.coderock.pojoclasses.TagRequest;
import com.example.coderock.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagServiceItf {
    public Tag createTag(TagRequest tagRequest);
    public List<Tag> getAllTagsFromTagReq(List<TagRequest> requests);

}
