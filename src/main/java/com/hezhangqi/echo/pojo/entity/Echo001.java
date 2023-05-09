package com.hezhangqi.echo.pojo.entity;
/*
 * @Author: ti_cn ti_cn@icloud.com
 * @Date: 2022-12-27 20:17:23
 * @Description: 
 */

/**
 * @Author: Ti-cn
 * @Date: 2022/8/10 23:22
 */

public class Echo001 implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    private String column_01;

    private String column_02;

    public Echo001(String column_01, String column_02) {
        this.column_01 = column_01;
        this.column_02 = column_02;
    }

    public String getColumn_01() {
        return column_01;
    }

    public void setColumn_01(String column_01) {
        this.column_01 = column_01;
    }

    @Override
    public String toString() {
        return "Echo001 [column_01=" + column_01 + ", column_02=" + column_02 + "]";
    }

    public String getColumn_02() {
        return column_02;
    }

    public void setColumn_02(String column_02) {
        this.column_02 = column_02;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((column_01 == null) ? 0 : column_01.hashCode());
        result = prime * result + ((column_02 == null) ? 0 : column_02.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Echo001 other = (Echo001) obj;
        if (column_01 == null) {
            if (other.column_01 != null)
                return false;
        } else if (!column_01.equals(other.column_01))
            return false;
        if (column_02 == null) {
            if (other.column_02 != null)
                return false;
        } else if (!column_02.equals(other.column_02))
            return false;
        return true;
    }

}
