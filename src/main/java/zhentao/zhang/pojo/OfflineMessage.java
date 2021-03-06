package zhentao.zhang.pojo;

import java.util.Date;

public class OfflineMessage {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column offline_message.msg_id
     *
     * @mbggenerated
     */
    private Integer msgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column offline_message.from_user_id
     *
     * @mbggenerated
     */
    private Integer fromUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column offline_message.to_user_id
     *
     * @mbggenerated
     */
    private Integer toUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column offline_message.msg_type
     *
     * @mbggenerated
     */
    private String msgType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column offline_message.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column offline_message.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column offline_message.is_receive
     *
     * @mbggenerated
     */
    private Boolean isReceive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column offline_message.is_delete
     *
     * @mbggenerated
     */
    private Boolean isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column offline_message.msg_id
     *
     * @return the value of offline_message.msg_id
     *
     * @mbggenerated
     */
    public Integer getMsgId() {
        return msgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column offline_message.msg_id
     *
     * @param msgId the value for offline_message.msg_id
     *
     * @mbggenerated
     */
    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column offline_message.from_user_id
     *
     * @return the value of offline_message.from_user_id
     *
     * @mbggenerated
     */
    public Integer getFromUserId() {
        return fromUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column offline_message.from_user_id
     *
     * @param fromUserId the value for offline_message.from_user_id
     *
     * @mbggenerated
     */
    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column offline_message.to_user_id
     *
     * @return the value of offline_message.to_user_id
     *
     * @mbggenerated
     */
    public Integer getToUserId() {
        return toUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column offline_message.to_user_id
     *
     * @param toUserId the value for offline_message.to_user_id
     *
     * @mbggenerated
     */
    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column offline_message.msg_type
     *
     * @return the value of offline_message.msg_type
     *
     * @mbggenerated
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column offline_message.msg_type
     *
     * @param msgType the value for offline_message.msg_type
     *
     * @mbggenerated
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column offline_message.content
     *
     * @return the value of offline_message.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column offline_message.content
     *
     * @param content the value for offline_message.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column offline_message.create_time
     *
     * @return the value of offline_message.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column offline_message.create_time
     *
     * @param createTime the value for offline_message.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column offline_message.is_receive
     *
     * @return the value of offline_message.is_receive
     *
     * @mbggenerated
     */
    public Boolean getIsReceive() {
        return isReceive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column offline_message.is_receive
     *
     * @param isReceive the value for offline_message.is_receive
     *
     * @mbggenerated
     */
    public void setIsReceive(Boolean isReceive) {
        this.isReceive = isReceive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column offline_message.is_delete
     *
     * @return the value of offline_message.is_delete
     *
     * @mbggenerated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column offline_message.is_delete
     *
     * @param isDelete the value for offline_message.is_delete
     *
     * @mbggenerated
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}