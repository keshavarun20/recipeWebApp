package com.recipe.recipeSocial.repository;

import com.recipe.recipeSocial.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
