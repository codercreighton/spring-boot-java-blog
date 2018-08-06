package com.tts.theBlog.author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.tts.theBlog.comment.Comment;
import com.tts.theBlog.post.Post;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany (mappedBy ="author")
	private Set<Post> posts = new HashSet<Post>();
	
	@OneToMany (mappedBy ="author")
	private Set<Comment> comments = new HashSet<Comment>();
	
	private Author() {
		//needed for JPA
	}
	
	public Author(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Set<Comment> getComment() {
		return comments;
	}

	public void setComment(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", posts=" + posts + ", comments=" + comments + "]";
	}

	
	
	
	
}
