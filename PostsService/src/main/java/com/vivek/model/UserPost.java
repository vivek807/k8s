package com.vivek.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "user_posts")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class UserPost extends BaseModel {
	@NotBlank
	private String text;

	@NotNull
	private Long authorId;

	@Column(updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private LocalDate postedAt;
}
