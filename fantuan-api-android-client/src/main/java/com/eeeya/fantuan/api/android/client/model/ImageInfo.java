package com.eeeya.fantuan.api.android.client.model;


import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 **/
@ApiModel(description = "")
public class ImageInfo  {
  
  private String imageType = null;
  private String imageUrl = null;

  
  /**
   * 图片类型，例如：用户Logo
   **/
  @ApiModelProperty(required = false, value = "图片类型，例如：用户Logo")
  @JsonProperty("imageType")
  public String getImageType() {
    return imageType;
  }
  public void setImageType(String imageType) {
    this.imageType = imageType;
  }

  
  /**
   * 图片URL
   **/
  @ApiModelProperty(required = false, value = "图片URL")
  @JsonProperty("imageUrl")
  public String getImageUrl() {
    return imageUrl;
  }
  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageInfo {\n");
    
    sb.append("  imageType: ").append(imageType).append("\n");
    sb.append("  imageUrl: ").append(imageUrl).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
