package com.alleyway.bean;

import java.util.ArrayList;
import java.util.List;

public class WorksExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public WorksExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLabelIdIsNull() {
            addCriterion("label_id is null");
            return (Criteria) this;
        }

        public Criteria andLabelIdIsNotNull() {
            addCriterion("label_id is not null");
            return (Criteria) this;
        }

        public Criteria andLabelIdEqualTo(Integer value) {
            addCriterion("label_id =", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotEqualTo(Integer value) {
            addCriterion("label_id <>", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThan(Integer value) {
            addCriterion("label_id >", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("label_id >=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThan(Integer value) {
            addCriterion("label_id <", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdLessThanOrEqualTo(Integer value) {
            addCriterion("label_id <=", value, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdIn(List<Integer> values) {
            addCriterion("label_id in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotIn(List<Integer> values) {
            addCriterion("label_id not in", values, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdBetween(Integer value1, Integer value2) {
            addCriterion("label_id between", value1, value2, "labelId");
            return (Criteria) this;
        }

        public Criteria andLabelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("label_id not between", value1, value2, "labelId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCoverPathIsNull() {
            addCriterion("cover_path is null");
            return (Criteria) this;
        }

        public Criteria andCoverPathIsNotNull() {
            addCriterion("cover_path is not null");
            return (Criteria) this;
        }

        public Criteria andCoverPathEqualTo(String value) {
            addCriterion("cover_path =", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotEqualTo(String value) {
            addCriterion("cover_path <>", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathGreaterThan(String value) {
            addCriterion("cover_path >", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathGreaterThanOrEqualTo(String value) {
            addCriterion("cover_path >=", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLessThan(String value) {
            addCriterion("cover_path <", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLessThanOrEqualTo(String value) {
            addCriterion("cover_path <=", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathLike(String value) {
            addCriterion("cover_path like", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotLike(String value) {
            addCriterion("cover_path not like", value, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathIn(List<String> values) {
            addCriterion("cover_path in", values, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotIn(List<String> values) {
            addCriterion("cover_path not in", values, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathBetween(String value1, String value2) {
            addCriterion("cover_path between", value1, value2, "coverPath");
            return (Criteria) this;
        }

        public Criteria andCoverPathNotBetween(String value1, String value2) {
            addCriterion("cover_path not between", value1, value2, "coverPath");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(String value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(String value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(String value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(String value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(String value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(String value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLike(String value) {
            addCriterion("add_time like", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotLike(String value) {
            addCriterion("add_time not like", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<String> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<String> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(String value1, String value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(String value1, String value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andLikeSizeIsNull() {
            addCriterion("like_size is null");
            return (Criteria) this;
        }

        public Criteria andLikeSizeIsNotNull() {
            addCriterion("like_size is not null");
            return (Criteria) this;
        }

        public Criteria andLikeSizeEqualTo(Integer value) {
            addCriterion("like_size =", value, "likeSize");
            return (Criteria) this;
        }

        public Criteria andLikeSizeNotEqualTo(Integer value) {
            addCriterion("like_size <>", value, "likeSize");
            return (Criteria) this;
        }

        public Criteria andLikeSizeGreaterThan(Integer value) {
            addCriterion("like_size >", value, "likeSize");
            return (Criteria) this;
        }

        public Criteria andLikeSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_size >=", value, "likeSize");
            return (Criteria) this;
        }

        public Criteria andLikeSizeLessThan(Integer value) {
            addCriterion("like_size <", value, "likeSize");
            return (Criteria) this;
        }

        public Criteria andLikeSizeLessThanOrEqualTo(Integer value) {
            addCriterion("like_size <=", value, "likeSize");
            return (Criteria) this;
        }

        public Criteria andLikeSizeIn(List<Integer> values) {
            addCriterion("like_size in", values, "likeSize");
            return (Criteria) this;
        }

        public Criteria andLikeSizeNotIn(List<Integer> values) {
            addCriterion("like_size not in", values, "likeSize");
            return (Criteria) this;
        }

        public Criteria andLikeSizeBetween(Integer value1, Integer value2) {
            addCriterion("like_size between", value1, value2, "likeSize");
            return (Criteria) this;
        }

        public Criteria andLikeSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("like_size not between", value1, value2, "likeSize");
            return (Criteria) this;
        }

        public Criteria andCommentSizeIsNull() {
            addCriterion("comment_size is null");
            return (Criteria) this;
        }

        public Criteria andCommentSizeIsNotNull() {
            addCriterion("comment_size is not null");
            return (Criteria) this;
        }

        public Criteria andCommentSizeEqualTo(Integer value) {
            addCriterion("comment_size =", value, "commentSize");
            return (Criteria) this;
        }

        public Criteria andCommentSizeNotEqualTo(Integer value) {
            addCriterion("comment_size <>", value, "commentSize");
            return (Criteria) this;
        }

        public Criteria andCommentSizeGreaterThan(Integer value) {
            addCriterion("comment_size >", value, "commentSize");
            return (Criteria) this;
        }

        public Criteria andCommentSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_size >=", value, "commentSize");
            return (Criteria) this;
        }

        public Criteria andCommentSizeLessThan(Integer value) {
            addCriterion("comment_size <", value, "commentSize");
            return (Criteria) this;
        }

        public Criteria andCommentSizeLessThanOrEqualTo(Integer value) {
            addCriterion("comment_size <=", value, "commentSize");
            return (Criteria) this;
        }

        public Criteria andCommentSizeIn(List<Integer> values) {
            addCriterion("comment_size in", values, "commentSize");
            return (Criteria) this;
        }

        public Criteria andCommentSizeNotIn(List<Integer> values) {
            addCriterion("comment_size not in", values, "commentSize");
            return (Criteria) this;
        }

        public Criteria andCommentSizeBetween(Integer value1, Integer value2) {
            addCriterion("comment_size between", value1, value2, "commentSize");
            return (Criteria) this;
        }

        public Criteria andCommentSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_size not between", value1, value2, "commentSize");
            return (Criteria) this;
        }

        public Criteria andCollectSizeIsNull() {
            addCriterion("collect_size is null");
            return (Criteria) this;
        }

        public Criteria andCollectSizeIsNotNull() {
            addCriterion("collect_size is not null");
            return (Criteria) this;
        }

        public Criteria andCollectSizeEqualTo(Integer value) {
            addCriterion("collect_size =", value, "collectSize");
            return (Criteria) this;
        }

        public Criteria andCollectSizeNotEqualTo(Integer value) {
            addCriterion("collect_size <>", value, "collectSize");
            return (Criteria) this;
        }

        public Criteria andCollectSizeGreaterThan(Integer value) {
            addCriterion("collect_size >", value, "collectSize");
            return (Criteria) this;
        }

        public Criteria andCollectSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_size >=", value, "collectSize");
            return (Criteria) this;
        }

        public Criteria andCollectSizeLessThan(Integer value) {
            addCriterion("collect_size <", value, "collectSize");
            return (Criteria) this;
        }

        public Criteria andCollectSizeLessThanOrEqualTo(Integer value) {
            addCriterion("collect_size <=", value, "collectSize");
            return (Criteria) this;
        }

        public Criteria andCollectSizeIn(List<Integer> values) {
            addCriterion("collect_size in", values, "collectSize");
            return (Criteria) this;
        }

        public Criteria andCollectSizeNotIn(List<Integer> values) {
            addCriterion("collect_size not in", values, "collectSize");
            return (Criteria) this;
        }

        public Criteria andCollectSizeBetween(Integer value1, Integer value2) {
            addCriterion("collect_size between", value1, value2, "collectSize");
            return (Criteria) this;
        }

        public Criteria andCollectSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_size not between", value1, value2, "collectSize");
            return (Criteria) this;
        }

        public Criteria andAuditStateIsNull() {
            addCriterion("audit_state is null");
            return (Criteria) this;
        }

        public Criteria andAuditStateIsNotNull() {
            addCriterion("audit_state is not null");
            return (Criteria) this;
        }

        public Criteria andAuditStateEqualTo(Integer value) {
            addCriterion("audit_state =", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotEqualTo(Integer value) {
            addCriterion("audit_state <>", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateGreaterThan(Integer value) {
            addCriterion("audit_state >", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_state >=", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateLessThan(Integer value) {
            addCriterion("audit_state <", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateLessThanOrEqualTo(Integer value) {
            addCriterion("audit_state <=", value, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateIn(List<Integer> values) {
            addCriterion("audit_state in", values, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotIn(List<Integer> values) {
            addCriterion("audit_state not in", values, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateBetween(Integer value1, Integer value2) {
            addCriterion("audit_state between", value1, value2, "auditState");
            return (Criteria) this;
        }

        public Criteria andAuditStateNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_state not between", value1, value2, "auditState");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Integer value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Integer value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Integer value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Integer value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Integer value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Integer> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Integer> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Integer value1, Integer value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Integer value1, Integer value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table aw_works
     *
     * @mbggenerated do_not_delete_during_merge Sun Jun 09 11:29:48 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table aw_works
     *
     * @mbggenerated Sun Jun 09 11:29:48 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}