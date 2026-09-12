package com.hisavana.common.interfacz;

import com.hisavana.common.bean.Network;
import java.util.List;

/* loaded from: classes4.dex */
public interface QueryPriceListener {
    void onQueryPriceFailed();

    void onQueryPriceSuccess(List<Network> list);
}
