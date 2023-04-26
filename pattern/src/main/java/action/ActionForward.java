package action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ActionForward {
	//페이지 이동방식(true,false), 페이지(String);
	
	private boolean isRedirect;
	private String path;
}
