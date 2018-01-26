package com.benxiang.noodles.moudle.config;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.benxiang.noodles.R;
import com.benxiang.noodles.base.BaseMenageActivity;
import com.benxiang.noodles.contants.Constants;
import com.benxiang.noodles.utils.PreferenceUtil;
import com.benxiang.noodles.widget.ErrorDialogFragment;

import butterknife.BindView;

/**
 * Created by 刘圣如 on 2017/9/21.
 * 第一次安装应用的时候设置库存
 */

public class SettingTestActivity extends BaseMenageActivity {
    private static final String TAG = "SettingTestActivity";
//    @BindView(R.id.ed_setting_noodles)
//    EditText noodelsNum;
//    @BindView(R.id.ed_setting_noodles_plies)
//    EditText noodelsNumPlies;
//    @BindView(R.id.ed_setting_noodles_price)
//    EditText noodelsPrice;
//    @BindView(R.id.ed_setting_rice)
//    EditText riceNum;
//    @BindView(R.id.ed_setting_rice_plies)
//    EditText riceNumPlies;
//    @BindView(R.id.ed_setting_rice_price)
//    EditText ricePrice;
//
//    @BindView(R.id.ed_setting_chicken_leg)
//    EditText ed_setting_chicken_leg;
//    @BindView(R.id.ed_setting_leg_plies)
//    EditText ed_setting_leg_plies;
//
//    @BindView(R.id.ed_setting_halogen_eggs)
//    EditText ed_setting_halogen_eggs;
//    @BindView(R.id.ed_setting_eggs_plies)
//    EditText ed_setting_eggs_plies;
//
//    @BindView(R.id.ed_setting_spicy)
//    EditText ed_setting_spicy;
//    @BindView(R.id.ed_setting_spicy_plies)
//    EditText ed_setting_spicy_plies;
//
//
    @BindView(R.id.ed_http_address)
    EditText ed_address;

    @Override
    public int getContentViewID() {
        return R.layout.activity_setting_first;
    }

    @Override
    protected void afterContentViewSet() {
        registerMainHandler();
    }


    public void addToDb(View view) {
//        String noodleNo = "0";
//        String riceNo = "0";
//        String noodlePlies = "0";
//        String ricePlies = "0";
//        String spicyNo = "0";
//        String legNo = "0";
//        String eggNo = "0";
//        String spicyPiles = "0";
//        String legPlies = "0";
//        String eggPlies = "0";
//        if (edNullHint()) {
//            noodleNo = noodelsNum.getText().toString().trim();
//            riceNo = riceNum.getText().toString().trim();
//            if (!noodelsNumPlies.getText().toString().trim().equals("")) {
//                noodlePlies = noodelsNumPlies.getText().toString().trim();
//
//            }
//            if (!riceNumPlies.getText().toString().trim().equals("")) {
//                ricePlies = riceNumPlies.getText().toString().trim();
//            }
//            if (!ed_setting_spicy.getText().toString().trim().equals("")) {
//                spicyNo = ed_setting_spicy.getText().toString().trim();
//            }
//            if (!ed_setting_chicken_leg.getText().toString().trim().equals("")) {
//                legNo = ed_setting_chicken_leg.getText().toString().trim();
//            }
//            if (!ed_setting_halogen_eggs.getText().toString().trim().equals("")) {
//                eggNo = ed_setting_halogen_eggs.getText().toString().trim();
//            }
//            if (!ed_setting_spicy_plies.getText().toString().trim().equals("")) {
//                spicyPiles = ed_setting_spicy_plies.getText().toString().trim();
//            }
//            if (!ed_setting_leg_plies.getText().toString().trim().equals("")) {
//                legPlies = ed_setting_leg_plies.getText().toString().trim();
//            }
//            if (!ed_setting_eggs_plies.getText().toString().trim().equals("")) {
//                eggPlies = ed_setting_eggs_plies.getText().toString().trim();
//            }
//            //判断面和粉的数量
//            if (Integer.parseInt(noodleNo) > DbTypeContants.RICE_Piles_MAX * Integer.parseInt(noodlePlies) ||
//                    Integer.parseInt(riceNo) > DbTypeContants.RICE_Piles_MAX * Integer.parseInt(ricePlies) ||
//                    //判断酸辣包，鸡腿，卤蛋的数量
//                    Integer.parseInt(spicyNo) > DbTypeContants.SUANLA_BAO_PLIE_NO * Integer.parseInt(spicyPiles) ||
//                    Integer.parseInt(legNo) > DbTypeContants.JIUI_PLIE_NO * Integer.parseInt(legPlies) ||
//                    Integer.parseInt(eggNo) > DbTypeContants.LUDAN_PLIE_NO * Integer.parseInt(eggPlies) ||
//                    //判断面和粉的数量
//                    Integer.parseInt(noodlePlies) + Integer.parseInt(ricePlies) > DbTypeContants.RICE_PLIES_MAX ||
//                    Integer.parseInt(spicyPiles) + Integer.parseInt(legPlies) + Integer.parseInt(eggPlies) > DbTypeContants.CHARGE_PLIES_MAX) {
//                showError("数量太大");
//            } else {
//                Timber.e("面条层数" + noodlePlies);
//                Timber.e("米粉层数" + ricePlies);
//                showLoadingDialog();
////                int riceStartNo = (Integer.parseInt(noodlePlies) + 1) * 3 + 1;
//                int riceStartNo = (Integer.parseInt(noodlePlies) + DbTypeContants.LACK_PILES) * 3 + 1;
//
//                int spicyStartNo = 51;
//                int legStartNo = 51 + Integer.parseInt(spicyPiles);
//                int eggStartNo = 51 + Integer.parseInt(spicyPiles) + Integer.parseInt(legPlies);
//                Timber.e("鸡蛋层数" + eggPlies);
//                Timber.e("鸡蛋开始" + eggStartNo);
//        /*        NoodleDB.initNoodle(Integer.parseInt(riceNo), "A", true, 0, 6);
//                NoodleDB.initNoodle(Integer.parseInt(noodleNo), "B", false, 18, 5); */
//                //设置最大数和最小数
////                PreferenceConfig.setTypeAMin(3*3+1);
//                PreferenceConfig.setTypeAMax((Integer.parseInt(noodlePlies) + DbTypeContants.LACK_PILES) * 3);
////                PreferenceConfig.setTypeAMax((Integer.parseInt(noodlePlies)+1)*3);
//                PreferenceConfig.setTypeBMin(riceStartNo);
//                PreferenceConfig.setTypeBMax((riceStartNo+Integer.parseInt(ricePlies))*3);
//
//                NoodleDB.initNoodle(Integer.parseInt(noodleNo), DbTypeContants.NOODLE_TYPE, true, DbTypeContants.NOODLE_START_NO, Integer.parseInt(noodlePlies));
//                NoodleDB.initNoodle(Integer.parseInt(riceNo), DbTypeContants.RICE_TYPE, false, riceStartNo, Integer.parseInt(ricePlies));
//                NoodleDB.initNoodle(Integer.parseInt(spicyNo), DbTypeContants.SUANLA_BAO_PLIE_NO, DbTypeContants.SUANLABAO_TYPE, false,
//                        DbTypeContants.SUANLABAO_TYPE_NO, Integer.parseInt(spicyPiles), spicyStartNo);
//                NoodleDB.initNoodle(Integer.parseInt(legNo), DbTypeContants.JIUI_PLIE_NO, DbTypeContants.SUANLAJITUI_TYPE, false,
//                        DbTypeContants.SUANLAJITUI_TYPE_NO, Integer.parseInt(legPlies), legStartNo);
//                NoodleDB.initNoodle(Integer.parseInt(eggNo), DbTypeContants.LUDAN_PLIE_NO, DbTypeContants.LUJIDANG_TYPE, false,
//                        DbTypeContants.LUJIDANG_TYPE_NO, Integer.parseInt(eggPlies), eggStartNo);
//                getMainHandler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        hideLoadingDialog();
//                        startNext(SettingTestActivity.this, SettingActivity.class);
////                        startNext(SettingTestActivity.this, MakeMultiNoodlesActivity.class);
//                    }
//                }, 2000);
//            }
//        }
        dataToDB();
    }

    @Override
    protected void runToNextPager() {
        getMainHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoadingDialog();
//                        startNext(SettingTestActivity.this, SettingActivity.class);
                        StartBanner();
                    }
                }, 3000);
    }

    //    private boolean edNullHint() {
//        String noodleNo = noodelsNum.getText().toString().trim();
//        String riceNo = riceNum.getText().toString().trim();
//        String noodleprice = noodelsPrice.getText().toString().trim();
//        String riceprice = ricePrice.getText().toString().trim();
//        if (TextUtils.isEmpty(noodleNo) || TextUtils.isEmpty(riceNo)) {
//            showError("不能为空");
//            return false;
//        }
//
//        PreferenceUtil.config().setStringValue(Constants.NOODLE_PRICE, "5.9");
//        PreferenceUtil.config().setStringValue(Constants.RICE_PRICE, "5.9");
//        if (!TextUtils.isEmpty(noodleprice)) {
//            PreferenceUtil.config().setStringValue(Constants.NOODLE_PRICE, noodleprice);
//        }
//        if (!TextUtils.isEmpty(riceprice)) {
//            PreferenceUtil.config().setStringValue(Constants.RICE_PRICE, riceprice);
//        }
//        PreferenceUtil.config().setStringValue(Constants.NOODLE_NO, noodleNo);
//        PreferenceUtil.config().setStringValue(Constants.RICE_NO, riceNo);
//        /*PreferenceUtil.config().setStringValue(Constants.NOODLE_PRICE, noodleprice);
//        PreferenceUtil.config().setStringValue(Constants.RICE_PRICE, riceprice);*/
//
//
//        return true;
//    }

    public void saveAddress(View view) {
        if (edNullHint(ed_address)) {
            showWarningDialog("确定", "确定要修改后台地址", new ErrorDialogFragment.OnErrorClickListener() {
                @Override
                public void onClick(ErrorDialogFragment dialog) {
                    killAllErrorDialogs();
                    PreferenceUtil.config().setStringValue(Constants.HTTP_ADDRESS,ed_address.getText().toString().trim());
                    Toast.makeText(SettingTestActivity.this, "地址修改成功", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    private boolean edNullHint(EditText editText) {

        String textString = editText.getText().toString().trim();
        if (TextUtils.isEmpty(textString)) {
            showError("不能为空");
            return false;
        }
        return true;
    }

}
