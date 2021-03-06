package zhentao.zhang.pojo;

import java.util.Date;

public class RefereeReply {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referee_reply.ref_rep_id
     *
     * @mbggenerated
     */
    private Integer refRepId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referee_reply.referee_id
     *
     * @mbggenerated
     */
    private Integer refereeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referee_reply.ref_res_id
     *
     * @mbggenerated
     */
    private Integer refResId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referee_reply.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referee_reply.note
     *
     * @mbggenerated
     */
    private String note;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referee_reply.is_delete
     *
     * @mbggenerated
     */
    private Boolean isDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column referee_reply.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column referee_reply.ref_rep_id
     *
     * @return the value of referee_reply.ref_rep_id
     *
     * @mbggenerated
     */
    public Integer getRefRepId() {
        return refRepId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column referee_reply.ref_rep_id
     *
     * @param refRepId the value for referee_reply.ref_rep_id
     *
     * @mbggenerated
     */
    public void setRefRepId(Integer refRepId) {
        this.refRepId = refRepId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column referee_reply.referee_id
     *
     * @return the value of referee_reply.referee_id
     *
     * @mbggenerated
     */
    public Integer getRefereeId() {
        return refereeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column referee_reply.referee_id
     *
     * @param refereeId the value for referee_reply.referee_id
     *
     * @mbggenerated
     */
    public void setRefereeId(Integer refereeId) {
        this.refereeId = refereeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column referee_reply.ref_res_id
     *
     * @return the value of referee_reply.ref_res_id
     *
     * @mbggenerated
     */
    public Integer getRefResId() {
        return refResId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column referee_reply.ref_res_id
     *
     * @param refResId the value for referee_reply.ref_res_id
     *
     * @mbggenerated
     */
    public void setRefResId(Integer refResId) {
        this.refResId = refResId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column referee_reply.status
     *
     * @return the value of referee_reply.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column referee_reply.status
     *
     * @param status the value for referee_reply.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column referee_reply.note
     *
     * @return the value of referee_reply.note
     *
     * @mbggenerated
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column referee_reply.note
     *
     * @param note the value for referee_reply.note
     *
     * @mbggenerated
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column referee_reply.is_delete
     *
     * @return the value of referee_reply.is_delete
     *
     * @mbggenerated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column referee_reply.is_delete
     *
     * @param isDelete the value for referee_reply.is_delete
     *
     * @mbggenerated
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column referee_reply.create_time
     *
     * @return the value of referee_reply.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column referee_reply.create_time
     *
     * @param createTime the value for referee_reply.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}