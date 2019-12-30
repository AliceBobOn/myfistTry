package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "tuxiangxinxi")
public class Tuxiangxinxi implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "tuxiangbianhao")
    private String tuxiangbianhao;
    @Column(name = "fenlei")
    private String fenlei;
    @Column(name = "tupian")
    private String tupian;
    @Column(name = "mingcheng")
    private String mingcheng;
    @Column(name = "shiping")
    private String shiping;
    @Column(name = "zuozhe")
    private String zuozhe;
    @Column(name = "dianjishuai")
    private Integer dianjishuai;
    @Column(name = "neirongjianjie")
    private String neirongjianjie;
    private String issh;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTuxiangbianhao() {
        return tuxiangbianhao;
    }
    public void setTuxiangbianhao(String tuxiangbianhao) {
        this.tuxiangbianhao = tuxiangbianhao == null ? "" : tuxiangbianhao.trim();
    }

    public String getFenlei() {
        return fenlei;
    }
    public void setFenlei(String fenlei) {
        this.fenlei = fenlei == null ? "" : fenlei.trim();
    }

    public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? "" : tupian.trim();
    }

    public String getMingcheng() {
        return mingcheng;
    }
    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng == null ? "" : mingcheng.trim();
    }

    public String getShiping() {
        return shiping;
    }
    public void setShiping(String shiping) {
        this.shiping = shiping == null ? "" : shiping.trim();
    }

    public String getZuozhe() {
        return zuozhe;
    }
    public void setZuozhe(String zuozhe) {
        this.zuozhe = zuozhe == null ? "" : zuozhe.trim();
    }

    public Integer getDianjishuai() {
        return dianjishuai;
    }
    public void setDianjishuai(Integer dianjishuai) {
        this.dianjishuai = dianjishuai == null ? 0 : dianjishuai;
    }

    public String getNeirongjianjie() {
        return neirongjianjie;
    }
    public void setNeirongjianjie(String neirongjianjie) {
        this.neirongjianjie = neirongjianjie == null ? "" : neirongjianjie.trim();
    }
    public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? "" : issh.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
