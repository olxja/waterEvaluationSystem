package com.bean;

import java.io.Serializable;

/**
 * Created by 郑超一 on 2017/2/28.
 */
public class Model implements Serializable {
    private String json;
    private Integer count;
    private String temp;
    private String model_name;
    private String model_classify;
    private String model_info;
    private Integer user_id;
    private Integer growth_ability;
    private Integer competitive_ability;
    private Integer financing_ability;
    private Integer teamcomposition_ablity;
    private Integer publicvoice_ability;
    private Integer innovatiove_ability;
    private Integer external_ability;
    private Integer main_business_income_2015;
    private Integer main_business_cgr_3years;
    private Integer net_profit_cgr_3years;
    private Integer total_assets_cgr_3years;
    private Integer capital_cgr_3years;
    private Integer main_business_profit_rate;
    private Integer total_assets_yield_rate;
    private Integer net_asset_yield_rate;
    private Integer capital_stock;
    private Integer total_assets;
    private Integer baidu_included;
    private Integer webmaster_ranking;
    private Integer search_engine_index;
    private Integer receivables_turnover_rate;
    private Integer total_assets_turnover_rate;
    private Integer liquidity_ratio;
    private Integer shareholder_number;
    private Integer business_valuation;
    private Integer shareholder_equity;
    private Integer Market_makers_number;
    private Integer investor_number;
    private Integer equity_investment_number;
    private Integer bond_financing_amount;
    private Integer amount_of_financing;
    private Integer workers_number;
    private Integer graduate_student_proportion;
    private Integer undergraduate_proportion;
    private Integer junior_student_proportion;
    private Integer under_junior_proportion;
    private Integer managers_change_frequency;
    private Integer public_attention_index;
    private Integer wechat_attention_index;
    private Integer invention_sum;
    private Integer computer_copyright_sum;
    private Integer certificate_sum;
    private Integer brand_sum;
    private Integer research_people_rate;
    private Integer research_put_into_rate;
    private Integer son_company_number;
    private Integer industry_business_code;
    private Integer value_of_area;

    public String getJson(){ return  json;}

    public void setJson(String json){this.json = json;}

    public String getTemp(){ return temp;}

    public void setTemp(String temp){ this.temp = temp;}

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getModel_classify() {
        return model_classify;
    }

    public void setModel_classify(String model_classify) {
        this.model_classify= model_classify;
    }

    public String getModel_info() {
        return model_info;
    }

    public void setModel_info(String model_info) {
        this.model_info = model_info;
    }

    public Integer getUser_id(){ return user_id;}

    public void  setUser_id(Integer user_id){ this.user_id = user_id;}

//    public Integer getGrowth_ability () {
//        return growth_ability;
//    }
//
//    public void setGrowth_ability (Integer growth_ability ) {
//        this.growth_ability = growth_ability;
//    }
//
//    public Integer getCompetitive_ability () {
//        return competitive_ability;
//    }
//
//    public void setCompetitive_ability (Integer competitive_ability) {
//        this.competitive_ability = competitive_ability;
//    }
//
//    public Integer getFinancing_ability () {
//        return financing_ability;
//    }
//
//    public void setFinancing_ability (Integer financing_ability) {
//        this.financing_ability = financing_ability;
//    }
//
//    public Integer getTeamcomposition_ablity () {
//        return teamcomposition_ablity;
//    }
//
//    public void setTeamcomposition_ablity (Integer teamcomposition_ablity) {
//        this.teamcomposition_ablity = teamcomposition_ablity;
//    }
//
//    public Integer getPublicvoice_ability () {
//        return publicvoice_ability ;
//    }
//
//    public void setPublicvoice_ability (Integer publicvoice_ability) {
//        this.publicvoice_ability = publicvoice_ability;
//    }
//
//    public Integer getInnovatiove_ability () {
//        return innovatiove_ability ;
//    }
//
//    public void setInnovatiove_ability (Integer innovatiove_ability) {
//        this.innovatiove_ability = innovatiove_ability;
//    }
//
//    public Integer getExternal_ability () {
//        return external_ability;
//    }
//
//    public void setExternal_ability (Integer external_ability) {
//        this.external_ability = external_ability;
//    }
//
//    public Integer getMain_business_income_2015 () {
//        return main_business_income_2015;
//    }
//
//    public void setMain_business_income_2015 (Integer main_business_income_2015) {
//        this.main_business_income_2015 = main_business_income_2015;
//    }
//
//    public Integer getMain_business_cgr_3years () {
//        return main_business_cgr_3years;
//    }
//
//    public void setMain_business_cgr_3years (Integer main_business_cgr_3years) {
//        this.main_business_cgr_3years = main_business_cgr_3years;
//    }
//
//    public Integer getNet_profit_cgr_3years () {
//        return net_profit_cgr_3years;
//    }
//
//    public void setNet_profit_cgr_3years (Integer net_profit_cgr_3years) {
//        this.net_profit_cgr_3years = net_profit_cgr_3years;
//    }
//
//    public Integer getTotal_assets_cgr_3years () {
//        return total_assets_cgr_3years;
//    }
//
//    public void setTotal_assets_cgr_3years (Integer total_assets_cgr_3years) {
//        this.total_assets_cgr_3years = total_assets_cgr_3years;
//    }
//
//    public Integer getCapital_cgr_3years () {
//        return capital_cgr_3years;
//    }
//
//    public void setCapital_cgr_3years (Integer capital_cgr_3years) {
//        this.capital_cgr_3years = capital_cgr_3years ;
//    }
//
//    public Integer getMain_business_profit_rate () {
//        return main_business_profit_rate;
//    }
//
//    public void setMain_business_profit_rate (Integer main_business_profit_rate) {
//        this.main_business_profit_rate = main_business_profit_rate;
//    }
//
//    public Integer getTotal_assets_yield_rate () {
//        return total_assets_yield_rate;
//    }
//
//    public void setTotal_assets_yield_rate (Integer total_assets_yield_rate) {
//        this.total_assets_yield_rate = total_assets_yield_rate;
//    }
//
//    public Integer getNet_asset_yield_rate () {
//        return net_asset_yield_rate;
//    }
//
//    public void setNet_asset_yield_rate (Integer net_asset_yield_rate) {
//        this.net_asset_yield_rate = net_asset_yield_rate;
//    }
//
//    public Integer getCapital_stock () {
//        return capital_stock;
//    }
//
//    public void setCapital_stock (Integer capital_stock) {
//        this.capital_stock = capital_stock;
//    }
//
//    public Integer getTotal_assets () {
//        return total_assets;
//    }
//
//    public void setTotal_assets (Integer total_assets) {
//        this.total_assets = total_assets;
//    }
//
//    public Integer getBaidu_included () {
//        return baidu_included;
//    }
//
//    public void setBaidu_included (Integer baidu_included) {
//        this.baidu_included = baidu_included;
//    }
//
//    public Integer getWebmaster_ranking () {
//        return webmaster_ranking;
//    }
//
//    public void setWebmaster_ranking (Integer webmaster_ranking) {
//        this.webmaster_ranking = webmaster_ranking;
//    }
//
//    public Integer getSearch_engine_index () {
//        return search_engine_index;
//    }
//
//    public void setSearch_engine_index (Integer search_engine_index) {
//        this.search_engine_index = search_engine_index;
//    }
//
//    public Integer getReceivables_turnover_rate () {
//        return receivables_turnover_rate;
//    }
//
//    public void setReceivables_turnover_rate (Integer receivables_turnover_rate) {
//        this.receivables_turnover_rate = receivables_turnover_rate;
//    }
//
//    public Integer getTotal_assets_turnover_rate () {
//        return total_assets_turnover_rate;
//    }
//
//    public void setTotal_assets_turnover_rate (Integer total_assets_turnover_rate) {
//        this.total_assets_turnover_rate = total_assets_turnover_rate;
//    }
//
//    public Integer getLiquidity_ratio () {
//        return liquidity_ratio;
//    }
//
//    public void setLiquidity_ratio (Integer liquidity_ratio) {
//        this.liquidity_ratio = liquidity_ratio;
//    }
//
//    public Integer getShareholder_number () {
//        return shareholder_number;
//    }
//
//    public void setShareholder_number (Integer shareholder_number) {
//        this.shareholder_number = shareholder_number;
//    }
//
//    public Integer getBusiness_valuation () {
//        return business_valuation;
//    }
//
//    public void setBusiness_valuation (Integer business_valuation) {
//        this.business_valuation = business_valuation;
//    }
//
//    public Integer getShareholder_equity () {
//        return shareholder_equity;
//    }
//
//    public void setShareholder_equity (Integer shareholder_equity) {
//        this.shareholder_equity = shareholder_equity;
//    }
//
//    public Integer getMarket_makers_number () {
//        return Market_makers_number;
//    }
//
//    public void setMarket_makers_number (Integer Market_makers_number) {
//        this.Market_makers_number = Market_makers_number;
//    }
//
//    public Integer getInvestor_number () {
//        return investor_number;
//    }
//
//    public void setInvestor_number (Integer investor_number) {
//        this.investor_number = investor_number;
//    }
//
//    public Integer getEquity_investment_number () {
//        return equity_investment_number;
//    }
//
//    public void setEquity_investment_number (Integer equity_investment_number) {
//        this.equity_investment_number = equity_investment_number;
//    }
//
//    public Integer getBond_financing_amount () {
//        return bond_financing_amount;
//    }
//
//    public void setBond_financing_amount (Integer bond_financing_amount) {
//        this.bond_financing_amount = bond_financing_amount;
//    }
//
//    public Integer getAmount_of_financing () {
//        return amount_of_financing;
//    }
//
//    public void setAmount_of_financing (Integer amount_of_financing) {
//        this.amount_of_financing = amount_of_financing;
//    }
//
//    public Integer getWorkers_number () {
//        return workers_number;
//    }
//
//    public void setWorkers_number (Integer workers_number) {
//        this.workers_number = workers_number;
//    }
//
//    public Integer getGraduate_student_proportion () {
//        return graduate_student_proportion;
//    }
//
//    public void setGraduate_student_proportion (Integer graduate_student_proportion) {
//        this.graduate_student_proportion = graduate_student_proportion;
//    }
//
//    public Integer getUndergraduate_proportion () {
//        return undergraduate_proportion;
//    }
//
//    public void setUndergraduate_proportion (Integer under_junior_proportion) {
//        this.undergraduate_proportion = undergraduate_proportion;
//    }
//
//    public Integer getJunior_student_proportion () {
//        return junior_student_proportion;
//    }
//
//    public void setJunior_student_proportion (Integer junior_student_proportion) {
//        this.junior_student_proportion = junior_student_proportion;
//    }
//
//    public Integer getUnder_junior_proportion () {
//        return under_junior_proportion;
//    }
//
//    public void setUnder_junior_proportion (Integer under_junior_proportion) {
//        this.under_junior_proportion = under_junior_proportion;
//    }
//
//    public Integer getManagers_change_frequency () {
//        return managers_change_frequency;
//    }
//
//    public void setManagers_change_frequency (Integer managers_change_frequency) {
//        this.managers_change_frequency = managers_change_frequency;
//    }
//
//    public Integer getPublic_attention_index () {
//        return public_attention_index;
//    }
//
//    public void setPublic_attention_index (Integer public_attention_index) {
//        this.public_attention_index = public_attention_index;
//    }
//
//    public Integer getWechat_attention_index () {
//        return wechat_attention_index;
//    }
//
//    public void setWechat_attention_index (Integer wechat_attention_index) {
//        this.wechat_attention_index =wechat_attention_index;
//    }
//
//    public Integer getInvention_sum () {
//        return invention_sum;
//    }
//
//    public void setInvention_sum (Integer invention_sum) {
//        this.invention_sum = invention_sum;
//    }
//
//    public Integer getComputer_copyright_sum () {
//        return computer_copyright_sum;
//    }
//
//    public void setComputer_copyright_sum (Integer computer_copyright_sum) {
//        this.computer_copyright_sum = computer_copyright_sum;
//    }
//
//    public Integer getCertificate_sum () {
//        return certificate_sum;
//    }
//
//    public void setCertificate_sum (Integer certificate_sum) {
//        this.certificate_sum = certificate_sum;
//    }
//
//    public Integer getBrand_sum () {
//        return brand_sum;
//    }
//
//    public void setBrand_sum (Integer brand_sum) {
//        this.brand_sum = brand_sum;
//    }
//
//    public Integer getResearch_people_rate () {
//        return research_people_rate;
//    }
//
//    public void setResearch_people_rate (Integer research_people_rate) {
//        this.research_people_rate = research_people_rate;
//    }
//
//    public Integer getResearch_put_into_rate () {
//        return research_put_into_rate;
//    }
//
//    public void setResearch_put_into_rate (Integer research_put_into_rate) {
//        this.research_put_into_rate = research_put_into_rate;
//    }
//
//    public Integer getSon_company_number () {
//        return son_company_number;
//    }
//
//    public void setSon_company_number (Integer son_company_number) {
//        this.son_company_number = son_company_number;
//    }
//
//    public Integer getIndustry_business_code () {
//        return industry_business_code;
//    }
//
//    public void setIndustry_business_code (Integer industry_business_code) {
//        this.industry_business_code = industry_business_code;
//    }
//
//    public Integer getValue_of_area () {
//        return value_of_area;
//    }
//
//    public void setValue_of_area (Integer value_of_area) {
//        this.value_of_area = value_of_area;
//    }

}
