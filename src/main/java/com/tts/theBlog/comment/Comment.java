package com.tts.theBlog.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import org.springframework.data.annotation.CreatedDate;

import com.tts.theBlog.author.Author;
import com.tts.theBlog.post.Post;

import java.util.Date;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition= "TEXT")
	private String body;
	
	@CreatedDate @Column(columnDefinition ="TIMESTAMP")
	private Date posted;
	
	@ManyToOne
	private Post post;
	@ManyToOne
	private Author author;
	
	private Comment() {
		//needed for JPA
	}
	
	public Comment(String body) {
		this.setBody(body);
	}


	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	
	
	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", body=" + body + ", posted=" + posted + ", post=" + post + ", author=" + author
				+ "]";
	}

	
	
	
}
