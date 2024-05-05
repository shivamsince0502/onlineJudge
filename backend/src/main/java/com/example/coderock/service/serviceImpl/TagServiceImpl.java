package com.example.coderock.service.serviceImpl;

import com.example.coderock.model.Tag;
import com.example.coderock.pojoclasses.TagRequest;
import com.example.coderock.repository.TagRepository;
import com.example.coderock.service.serviceInfs.TagServiceItf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagServiceItf {
    @Autowired
    private TagRepository tagRepository;
    @Override
    public Tag createTag(TagRequest tagRequest) {
        Tag tag = new Tag();
        tag.setTagName(tagRequest.getTagName());
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getAllTagsFromTagReq(List<TagRequest> requests) {
        List<Tag> tagList = tagRepository.findAll();
        Map<String, Tag> tagNameToTagMap = tagList.stream().collect(Collectors.toMap(Tag::getTagName, tag -> tag));
        List<String> requestList = requests.stream().map(TagRequest::getTagName).toList();
        List<Tag> tags = new ArrayList<>();
        for(int i = 0; i < requestList.size(); i++) {
            if(!tagNameToTagMap.containsKey(requestList.get(i))){
                Tag tag = new Tag();
                tag.setTagName(requestList.get(i));
                tags.add(tagRepository.save(tag));
            }else{
                tags.add(tagNameToTagMap.get(requestList.get(i)));
            }
        }
        return tags;
    }
}
