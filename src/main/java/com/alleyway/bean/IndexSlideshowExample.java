package com.alleyway.bean;

import java.util.ArrayList;
import java.util.List;

public class IndexSlideshowExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public IndexSlideshowExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
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
     * This method corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
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

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNull() {
            addCriterion("video_id is null");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNotNull() {
            addCriterion("video_id is not null");
            return (Criteria) this;
        }

        public Criteria andVideoIdEqualTo(Integer value) {
            addCriterion("video_id =", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotEqualTo(Integer value) {
            addCriterion("video_id <>", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThan(Integer value) {
            addCriterion("video_id >", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("video_id >=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThan(Integer value) {
            addCriterion("video_id <", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThanOrEqualTo(Integer value) {
            addCriterion("video_id <=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdIn(List<Integer> values) {
            addCriterion("video_id in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotIn(List<Integer> values) {
            addCriterion("video_id not in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdBetween(Integer value1, Integer value2) {
            addCriterion("video_id between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("video_id not between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstIsNull() {
            addCriterion("introduce_first is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstIsNotNull() {
            addCriterion("introduce_first is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstEqualTo(String value) {
            addCriterion("introduce_first =", value, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstNotEqualTo(String value) {
            addCriterion("introduce_first <>", value, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstGreaterThan(String value) {
            addCriterion("introduce_first >", value, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstGreaterThanOrEqualTo(String value) {
            addCriterion("introduce_first >=", value, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstLessThan(String value) {
            addCriterion("introduce_first <", value, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstLessThanOrEqualTo(String value) {
            addCriterion("introduce_first <=", value, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstLike(String value) {
            addCriterion("introduce_first like", value, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstNotLike(String value) {
            addCriterion("introduce_first not like", value, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstIn(List<String> values) {
            addCriterion("introduce_first in", values, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstNotIn(List<String> values) {
            addCriterion("introduce_first not in", values, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstBetween(String value1, String value2) {
            addCriterion("introduce_first between", value1, value2, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceFirstNotBetween(String value1, String value2) {
            addCriterion("introduce_first not between", value1, value2, "introduceFirst");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondIsNull() {
            addCriterion("introduce_second is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondIsNotNull() {
            addCriterion("introduce_second is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondEqualTo(String value) {
            addCriterion("introduce_second =", value, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondNotEqualTo(String value) {
            addCriterion("introduce_second <>", value, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondGreaterThan(String value) {
            addCriterion("introduce_second >", value, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondGreaterThanOrEqualTo(String value) {
            addCriterion("introduce_second >=", value, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondLessThan(String value) {
            addCriterion("introduce_second <", value, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondLessThanOrEqualTo(String value) {
            addCriterion("introduce_second <=", value, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondLike(String value) {
            addCriterion("introduce_second like", value, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondNotLike(String value) {
            addCriterion("introduce_second not like", value, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondIn(List<String> values) {
            addCriterion("introduce_second in", values, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondNotIn(List<String> values) {
            addCriterion("introduce_second not in", values, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondBetween(String value1, String value2) {
            addCriterion("introduce_second between", value1, value2, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceSecondNotBetween(String value1, String value2) {
            addCriterion("introduce_second not between", value1, value2, "introduceSecond");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyIsNull() {
            addCriterion("introduce_thirdly is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyIsNotNull() {
            addCriterion("introduce_thirdly is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyEqualTo(String value) {
            addCriterion("introduce_thirdly =", value, "introduceThirdly");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyNotEqualTo(String value) {
            addCriterion("introduce_thirdly <>", value, "introduceThirdly");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyGreaterThan(String value) {
            addCriterion("introduce_thirdly >", value, "introduceThirdly");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyGreaterThanOrEqualTo(String value) {
            addCriterion("introduce_thirdly >=", value, "introduceThirdly");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyLessThan(String value) {
            addCriterion("introduce_thirdly <", value, "introduceThirdly");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyLessThanOrEqualTo(String value) {
            addCriterion("introduce_thirdly <=", value, "introduceThirdly");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyLike(String value) {
            addCriterion("introduce_thirdly like", value, "introduceThirdly");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyNotLike(String value) {
            addCriterion("introduce_thirdly not like", value, "introduceThirdly");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyIn(List<String> values) {
            addCriterion("introduce_thirdly in", values, "introduceThirdly");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyNotIn(List<String> values) {
            addCriterion("introduce_thirdly not in", values, "introduceThirdly");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyBetween(String value1, String value2) {
            addCriterion("introduce_thirdly between", value1, value2, "introduceThirdly");
            return (Criteria) this;
        }

        public Criteria andIntroduceThirdlyNotBetween(String value1, String value2) {
            addCriterion("introduce_thirdly not between", value1, value2, "introduceThirdly");
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
     * This class corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated do_not_delete_during_merge Sun Jun 09 11:07:37 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table aw_index_slideshow
     *
     * @mbggenerated Sun Jun 09 11:07:37 CST 2019
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