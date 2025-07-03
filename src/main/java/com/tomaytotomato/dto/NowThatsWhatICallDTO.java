package com.tomaytotomato.dto;


public class NowThatsWhatICallDTO {

  private Integer id;
  private String name;
  private String publisherTitle;
  private String artist;

  public NowThatsWhatICallDTO() {
  }

  public NowThatsWhatICallDTO(Integer id, String name, String publisherTitle, String artist) {
    this.id = id;
    this.name = name;
    this.publisherTitle = publisherTitle;
    this.artist = artist;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPublisherTitle() {
    return publisherTitle;
  }

  public void setPublisherTitle(String publisherTitle) {
    this.publisherTitle = publisherTitle;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }
}
