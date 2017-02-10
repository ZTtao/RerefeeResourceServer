package zhentao.zhang.pojo;

import java.util.Date;

public class FindRefereeMessage {
	private Integer id;
    private User user;     //������
    private String gameState;   //��������
    private String address;     //�����ص�
    private Date time;          //����ʱ��
    private Integer refereeCount;//��������
    private String refereeClaim;//����Ҫ��
    private String pay;         //����
    private String note;        //��ע
    private Date publishTime;  //����ʱ��
    private Boolean isAccept = false;  //�Ƿ��ѱ�����
    private Integer applyCount = 0;//��������
    private Integer readCount = 0; //�鿴����
    private Integer acceptCount = 0;//����ļ����
    private Boolean isDelete = false;  //�Ƿ�ɾ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getGameState() {
		return gameState;
	}
	public void setGameState(String gameState) {
		this.gameState = gameState;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getRefereeCount() {
		return refereeCount;
	}
	public void setRefereeCount(Integer refereeCount) {
		this.refereeCount = refereeCount;
	}
	public String getRefereeClaim() {
		return refereeClaim;
	}
	public void setRefereeClaim(String refereeClaim) {
		this.refereeClaim = refereeClaim;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Boolean getIsAccept() {
		return isAccept;
	}
	public void setIsAccept(Boolean isAccept) {
		this.isAccept = isAccept;
	}
	public Integer getApplyCount() {
		return applyCount;
	}
	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
	}
	public Integer getReadCount() {
		return readCount;
	}
	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
	public Integer getAcceptCount() {
		return acceptCount;
	}
	public void setAcceptCount(Integer acceptCount) {
		this.acceptCount = acceptCount;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
    
}
