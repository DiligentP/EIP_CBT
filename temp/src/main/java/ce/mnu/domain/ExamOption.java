package ce.mnu.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author DreStar
 * @brief 시험 옵션 VO
 * @details 시험 관련 옵션
 * @date 2022/05/25
 * @version 0.0.1
 *
 */

@ToString
@Setter
@Getter
public class ExamOption {
	private int amount;

	private String type;
	private String query;

	/**
	 * @brief 생성자
	 * @details 문제 개수를 100개로 한다.
	 */
	public ExamOption() {
		this(100, "random");
	}

	/**
	 * @brief 생성자
	 * @details 문제 개수를 지정한다.
	 * 
	 * @param amount 문제 개수
	 */
	public ExamOption(int amount, String type) {
		this.amount = amount;
		this.type = type;
	}

	
	/**
	 * @brief 타입 배열 받기
	 * @details 타입의 배열을 리턴한다.
	 * 
	 * @return type[]
	 */
	public String[] getTypeArr() {

		return type == null ? new String[] {} : type.split("");
	}
}
