package com.da.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "GROUPS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Groups {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "id_group")
	private Integer idGroups;

	@Column(name = "name_group")
	private String groupName;

	@Column(name = "statuss")
	private String status;

}
