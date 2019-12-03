package com.bawei.dinghongxiang20191203.model;

import android.graphics.Bitmap;

import com.bawei.dinghongxiang20191203.Util.NetUtils;
import com.bawei.dinghongxiang20191203.contract.Imcontract;
import com.google.gson.Gson;

public class Imodel {

    public void ongetData(final Imcontract.ImodelCallback imodelCallback){


        NetUtils.getInstance().doGet("http://blog.zhaoliang5156.cn/api/mall/mall.json", new NetUtils.Huidiao() {
            @Override
            public void Wen(String json) {
                Bean bean = new Gson().fromJson(json, Bean.class);
                imodelCallback.onMySuccess(bean);
            }

            @Override
            public void Tu(Bitmap bitmap) {

            }

            @Override
            public void Failure(Throwable throwable) {
                imodelCallback.onMyfailure(throwable);
            }
        });
    }
}
