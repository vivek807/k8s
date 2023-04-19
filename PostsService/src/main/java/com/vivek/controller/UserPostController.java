package com.vivek.controller;

import com.vivek.model.UserPost;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class UserPostController extends BaseRestController<UserPost> {
}
