package com.liujin.springbootstartup.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class User implements Serializable {
	@Id
	@GeneratedValue
	private Long id;

	@CreatedDate
	private LocalDateTime createTime;

	@LastModifiedDate
	private LocalDateTime lastModifiedTime;

	@CreatedBy
	private String createBy;

	@LastModifiedBy
	private String modifiedBy;

	@Column(insertable = false)
	private String name;

	private String address;

	@Column(nullable = true)
	private String email;

	private String phone;

	@Column(nullable = false)
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pro_id", referencedColumnName = "name")
	private List<Product> products;
}
