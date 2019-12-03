package com.bawei.dinghongxiang20191203.presenter;

import com.bawei.dinghongxiang20191203.Util.NetUtils;
import com.bawei.dinghongxiang20191203.contract.Imcontract;
import com.bawei.dinghongxiang20191203.model.Bean;
import com.bawei.dinghongxiang20191203.model.Imodel;

public class Ipresenter {
    public void ongetData(final Imcontract.Iview iview){
        final Imodel imodel = new Imodel();

        imodel.ongetData(new Imcontract.ImodelCallback() {
            @Override
            public void onMySuccess(Bean bean) {
                iview.onMySuccess(bean);
            }

            @Override
            public void onMyfailure(Throwable throwable) {
                iview.onMyfailure(throwable);
            }
        });

    }
}
