package zhentao.zhang.pojo;

import java.util.Date;

public class Referee {
    private Integer refereeId;
    private String rank;
    private String experience;
    private String honor;
    private Date createTime;
    private Boolean isDelete;
    
	public Integer getRefereeId() {
		return refereeId;
	}
	public void setRefereeId(Integer refereeId) {
		this.refereeId = refereeId;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getHonor() {
		return honor;
	}
	public void setHonor(String honor) {
		this.honor = honor;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Boolean isDelete() {
		return isDelete;
	}
	public void setDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
    
}