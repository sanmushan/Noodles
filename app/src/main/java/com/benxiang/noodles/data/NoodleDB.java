package com.benxiang.noodles.data;

import com.benxiang.noodles.contants.DbTypeContants;
import com.benxiang.noodles.data.table.DropPackageDB;
import com.benxiang.noodles.data.table.RiceND;

/**
 * Created by 刘圣如 on 2017/9/21.
 */

public class NoodleDB {

    /*    public static void initNoodle(int noodleNum,String type,boolean delete,int changNo) {
            if (delete) {
                DBFactory.getmDBNoodle().deleteAll(RiceND.class);
            }
            int num = noodleNum;
            for (int i = 0; i < 4; i++) {

                for (int j = 0; j < 12; j++) {
                    RiceND riceND = new RiceND();
    //                riceND.csyaX = i + 1;
                    riceND.noodleType=type=="A"?1:2;
                    riceND.noodleTypeDesc=type;
    //                riceND.csyaZ = j % 4 + 1;
    //                riceND.csyaY = j / 4 + 1;
                    if (num > 0) {
                        riceND.noodleStatus = 1;
                    } else {
                        riceND.noodleStatus = 0;
                    }
                    int no=j / 4;
                    switch (no) {
                        case 0:
                            riceND.noodleNo=i*3+1+changNo;
                            riceND.noodleNoDesc=i*3+1+"";
                            break;
                        case 1:
                        case 1:
                            riceND.noodleNo=i*3+2+changNo;
                            riceND.noodleNoDesc=i*3+2+"";
                            break;
                        case 2:
                            riceND.noodleNo=i*3+3+changNo;
                            riceND.noodleNoDesc=i*3+3+"";
                            break;
                    }
                    num--;
                    DBFactory.getmDBNoodle().insert(riceND);
                }
    //            num = num-12;

            }
        }*/

    //向表里面插入面或粉的数据
    public static void initNoodle(int noodleNum, String type, boolean delete, int startNo, int pliesNum) {
        if (delete) {
            DBFactory.getmDBNoodle().deleteAll(RiceND.class);
        }
        int num = noodleNum;
        //遍历每一层
        for (int i = 0; i < pliesNum; i++) {
            //每层有3个号,遍历每一个号
            for (int j = 0; j < 3; j++) {
                RiceND riceND = new RiceND();
                riceND.noodleType = (type == DbTypeContants.NOODLE_TYPE ? 1 : 2);
                riceND.noodleTypeDesc = type;
                if (i == 0 && j == 0) {
                    riceND.stratBit = (type == DbTypeContants.NOODLE_TYPE ? 1 : 2);
                }
                if (num > 0) {
                    if (num >= 4) {
                        riceND.totalNum = 4;
                    } else {
                        riceND.totalNum = num;
                    }
                    riceND.noodleStatus = (type == DbTypeContants.NOODLE_TYPE ? DbTypeContants.MIANTIAO:DbTypeContants.MIFEN  );
                } else {
                    riceND.noodleStatus = 0;
                    riceND.totalNum = 0;
                }
                int numDesc = i * 3 + j + startNo;
                riceND.noodleNo = numDesc;
//                riceND.noodleNoDesc = numDesc + "";
                riceND.noodleNoDesc = String.valueOf(numDesc);
                num = num - 4;
                DBFactory.getmDBNoodle().insert(riceND);
            }
//            num = num-12;
        }
    }

    //向表里面插入掉料包的数据
    public static void initNoodle(int noodleNum, int pliesMax, String typeDesc, boolean delete, int noodleType,int pliesNum,int startNo) {
        if (delete) {
            DBFactory.getmDBNoodle().deleteAll(RiceND.class);
        }
        int num = noodleNum;
        int numDesc = 0;
        int status = 0;
        //遍历每一层,遍历每一个货道
        for (int i = 0; i < pliesNum; i++) {
            RiceND riceND = new RiceND();
            riceND.noodleType = noodleType;
            riceND.noodleTypeDesc = typeDesc;
            numDesc = startNo + i;
            switch (typeDesc) {
                case DbTypeContants.SUANLABAO_TYPE:
//                    numDesc = 51 + i;
                    status=DbTypeContants.SUANLABAO;
                    break;
                case DbTypeContants.SUANLAJITUI_TYPE:
//                    numDesc = 53 + i;
                    status=DbTypeContants.SUANLAJITUI;
                    break;
                case DbTypeContants.LUJIDANG_TYPE:
//                    numDesc = 55 + i;
                    status=DbTypeContants.LUJIDANG;
                    break;
                case DbTypeContants.FOUR_CATEGORY_TYPE:
                    status = DbTypeContants.FOUR_CATEGORY;
                    break;
            }
            if (num > 0) {
                if (num >= pliesMax) {
                    riceND.totalNum = pliesMax;
                } else {
                    riceND.totalNum = num;
                }
                riceND.noodleStatus =status;
            } else {
                riceND.noodleStatus = 0;
                riceND.totalNum = 0;

            }
            num -=  pliesMax;
            riceND.noodleNo = numDesc;
//            riceND.noodleNoDesc = numDesc + "";
            riceND.noodleNoDesc = String.valueOf(numDesc);
            DBFactory.getmDBNoodle().insert(riceND);
        }
//            num = num-12;

    }

    //向表里面插入卤水的数据
    public static void initNoodle(int brineNum, boolean delete, int startNo) {
        if (delete) {
            DBFactory.getmDBNoodle().deleteAll(RiceND.class);
        }
        int num = brineNum;
        RiceND riceND = new RiceND();
        riceND.noodleType = DbTypeContants.BRINE_TYPE_NO;
        riceND.noodleTypeDesc = DbTypeContants.BRINE_TYPE;
        if (num > 0) {
            riceND.totalNum = num;
            riceND.noodleStatus = DbTypeContants.BRINE_STATUS;
        } else {
            riceND.noodleStatus = 0;
            riceND.totalNum = 0;
        }
        int numDesc = startNo;
        riceND.noodleNo = numDesc;
        riceND.noodleNoDesc = String.valueOf(numDesc);
        DBFactory.getmDBNoodle().insert(riceND);
    }

    //向表里面插入掉料包的数据
    public static void initDropPackageDB(String productCode, String productName, String storeUnit, String productStatus, String menuItemCode, String menuItemCName,String standard, boolean delete) {
        if (delete) {
            DBFactory.getmDBNoodle().deleteAll(DropPackageDB.class);
        }
        DropPackageDB dropPackageDB = new DropPackageDB();
        dropPackageDB.ProdutCode = productCode;
        dropPackageDB.ProductName = productName;
        dropPackageDB.ProductStatus = productStatus;
        dropPackageDB.menuItemCode = menuItemCode;
        dropPackageDB.menuItemCName = menuItemCName;
        dropPackageDB.storeUnit = storeUnit;
        dropPackageDB.standard = standard;
        DBFactory.getmDBNoodle().insert(dropPackageDB);
    }

}
