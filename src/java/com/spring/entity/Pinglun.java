package com.spring.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "pinglun")
public class Pinglun implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "wenzhangID")
    private Integer wenzhangid;

    private String pinglunren;

    private String addtime;

    private String biao;

    private Integer pingfen;

    private String pinglunneirong;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return wenzhangID
     */
    public Integer getWenzhangid() {
        return wenzhangid;
    }

    /**
     * @param wenzhangid
     */
    public void setWenzhangid(Integer wenzhangid) {
        this.wenzhangid = wenzhangid;
    }

    /**
     * @return pinglunren
     */
    public String getPinglunren() {
        return pinglunren;
    }

    /**
     * @param pinglunren
     */
    public void setPinglunren(String pinglunren) {
        this.pinglunren = pinglunren == null ? null : pinglunren.trim();
    }

    /**
     * @return addtime
     */
    public String getAddtime() {
        return addtime;
    }

    /**
     * @param addtime
     */
    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    /**
     * @return biao
     */
    public String getBiao() {
        return biao;
    }

    /**
     * @param biao
     */
    public void setBiao(String biao) {
        this.biao = biao == null ? null : biao.trim();
    }

    /**
     * @return pingfen
     */
    public Integer getPingfen() {
        return pingfen;
    }

    /**
     * @param pingfen
     */
    public void setPingfen(Integer pingfen) {
        this.pingfen = pingfen;
    }

    /**
     * @return pinglunneirong
     */
    public String getPinglunneirong() {
        return pinglunneirong;
    }

    /**
     * @param pinglunneirong
     */
    public void setPinglunneirong(String pinglunneirong) {
        this.pinglunneirong = pinglunneirong == null ? null : pinglunneirong.trim();
    }
}