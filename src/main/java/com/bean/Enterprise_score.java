package com.bean;

import java.io.Serializable;

public class Enterprise_score implements Serializable {
  private String company_id;
  private Long model_id;
  private Double growth_force;
  private Double competitive_force;
  private Double financing_force;
  private Double teamcomposition_force;
  private Double publicvoice_force;
  private Double innovatiove_force;
  private Double external_force;
  private Double sumscore;

  public String getCompany_id() {
    return company_id;
  }

  public void setCompany_id(String company_id) {
    this.company_id = company_id;
  }

  public Long getModel_id() {
    return model_id;
  }

  public void setModel_id(Long model_id) {
    this.model_id = model_id;
  }

  public Double getGrowth_force() {
    return growth_force;
  }

  public void setGrowth_force(Double growth_force) {
    this.growth_force = growth_force;
  }

  public Double getCompetitive_force() {
    return competitive_force;
  }

  public void setCompetitive_force(Double competitive_force) {
    this.competitive_force = competitive_force;
  }

  public Double getFinancing_force() {
    return financing_force;
  }

  public void setFinancing_force(Double financing_force) {
    this.financing_force = financing_force;
  }

  public Double getTeamcomposition_force() {
    return teamcomposition_force;
  }

  public void setTeamcomposition_force(Double teamcomposition_force) {
    this.teamcomposition_force = teamcomposition_force;
  }

  public Double getPublicvoice_force() {
    return publicvoice_force;
  }

  public void setPublicvoice_force(Double publicvoice_force) {
    this.publicvoice_force = publicvoice_force;
  }

  public Double getInnovatiove_force() {
    return innovatiove_force;
  }

  public void setInnovatiove_force(Double innovatiove_force) {
    this.innovatiove_force = innovatiove_force;
  }

  public Double getExternal_force() {
    return external_force;
  }

  public void setExternal_force(Double external_force) {
    this.external_force = external_force;
  }

  public Double getSumscore() {
    return sumscore;
  }

  public void setSumscore(Double sumscore) {
    this.sumscore = sumscore;
  }
}
