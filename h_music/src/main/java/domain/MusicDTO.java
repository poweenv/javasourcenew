package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MusicDTO {
	private int mno;
	private String singer;
	private String song;
	private String musicType;
	private String password;
	private int cnt;
	private int reRef;
	private int reLev;
	private int reSeq;
	private Date regDate;
	private String name;
	private String playtime;
}
