package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "verification_code_candidates")
public class CandidateVerificationCode extends VerificationCode {
	
	@JoinColumn(name = "candidate_id", referencedColumnName = "id", nullable = false)
	@Column(name = "candidate_id")
	private int candidateId;
}
