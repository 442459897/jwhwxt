package com.muran.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * \u680F\u76EE\u4FE1\u606F
 **/

@ApiModel(description = "\u680F\u76EE\u4FE1\u606F")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-07-08T09:44:35.726+08:00")
public class ColumnPosterInfo {

	private String name = null;
	private String columnKey = null;
	private Boolean isShowPoster = null;
	private String posterUrl = null;
	private String posterImageUrl = null;

	/**
	 * \u680F\u76EE\u540D\u79F0
	 **/
	public ColumnPosterInfo name(String name) {
		this.name = name;
		return this;
	}

	@ApiModelProperty(value = "\u680F\u76EE\u540D\u79F0")
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * \u680F\u76EEkey
	 **/
	public ColumnPosterInfo columnKey(String columnKey) {
		this.columnKey = columnKey;
		return this;
	}

	@ApiModelProperty(value = "\u680F\u76EEkey")
	@JsonProperty("columnKey")
	public String getColumnKey() {
		return columnKey;
	}

	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	/**
	 * \u662F\u5426\u663E\u793A\u6D77\u62A5
	 **/
	public ColumnPosterInfo isShowPoster(Boolean isShowPoster) {
		this.isShowPoster = isShowPoster;
		return this;
	}

	@ApiModelProperty(value = "\u662F\u5426\u663E\u793A\u6D77\u62A5")
	@JsonProperty("isShowPoster")
	public Boolean getIsShowPoster() {
		return isShowPoster;
	}

	public void setIsShowPoster(Boolean isShowPoster) {
		this.isShowPoster = isShowPoster;
	}

	/**
	 * \u680F\u76EE\u6D77\u62A5\u5730\u5740
	 **/
	public ColumnPosterInfo posterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
		return this;
	}

	@ApiModelProperty(value = "\u680F\u76EE\u6D77\u62A5\u5730\u5740")
	@JsonProperty("posterUrl")
	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ColumnPosterInfo columnPosterInfo = (ColumnPosterInfo) o;
		return Objects.equals(name, columnPosterInfo.name)
				&& Objects.equals(columnKey, columnPosterInfo.columnKey)
				&& Objects.equals(isShowPoster, columnPosterInfo.isShowPoster)
				&& Objects.equals(posterUrl, columnPosterInfo.posterUrl);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, columnKey, isShowPoster, posterUrl);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ColumnPosterInfo {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    columnKey: ").append(toIndentedString(columnKey))
				.append("\n");
		sb.append("    isShowPoster: ").append(toIndentedString(isShowPoster))
				.append("\n");
		sb.append("    posterUrl: ").append(toIndentedString(posterUrl))
				.append("\n");
		sb.append("    posterImageUrl: ")
				.append(toIndentedString(posterImageUrl)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	/**
	 * @return the posterImageUrl
	 */
	@ApiModelProperty(value = "\u680F\u76EE\u6D77\u62A5\u5730\u5740")
	@JsonProperty("posterImageUrl")
	public String getPosterImageUrl() {
		return posterImageUrl;
	}

	/**
	 * @param posterImageUrl
	 *            the posterImageUrl to set
	 */
	public void setPosterImageUrl(String posterImageUrl) {
		this.posterImageUrl = posterImageUrl;
	}
}
