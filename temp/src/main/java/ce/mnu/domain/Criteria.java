package ce.mnu.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author DreStar
 * @brief 페이지 / 검색 관련 VO
 * @details 페이지 처리 / 검색 처리에 필요한 정보
 * @date 2022/05/24
 * @version 0.0.1
 *
 */

@ToString
@Setter
@Getter
public class Criteria {

	private int pageNum;
	private int amount;

	private String type;
	private String keyword;

	/**
	 * @brief 생성자
	 * @details 지정을 안해주면 1페이지 / 10개를 보여준다.
	 */
	public Criteria() {
		this(1, 10);
	}

	/**
	 * @brief 생성자
	 * @details 페이지 / 개수를 지정한다.
	 * 
	 * @param pageNum 페이지 변수
	 * @param amount 개수
	 */
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
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

	
	/**
	 * @brief 페이지 정보 파라미터 주소
	 * @details 현재 페이지의 정보를 get을 이용하여 주소를 리턴받는다.
	 * 
	 * @return link
	 * ex) ?pageNum=1&amount=10&type=T&keyword=Test 
	 */
	public String getListLink() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());

		return builder.toUriString();

	}
}
