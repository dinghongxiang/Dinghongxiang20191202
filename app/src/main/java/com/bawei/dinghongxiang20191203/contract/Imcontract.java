package com.bawei.dinghongxiang20191203.contract;

import com.bawei.dinghongxiang20191203.model.Bean;

public interface Imcontract {

    interface Iview{
        void onMySuccess(Bean bean);
        void onMyfailure(Throwable throwable);
    }

    interface ImodelCallback{
        void onMySuccess(Bean bean);
        void onMyfailure(Throwable throwable);
    }
}
