package com.vivek.repository;

import com.vivek.model.UserPost;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostRepository extends BaseRepository<UserPost, Long> {
}
