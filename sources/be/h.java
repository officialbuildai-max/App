package be;

import android.util.Log;
import com.hisavana.common.bean.Network;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.AdUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import com.hisavana.mediation.config.ConfigContentHelper;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class h {
    public static CloudControlConfig.CodeSeat a(String str) {
        return b(str, "", false);
    }

    public static CloudControlConfig.CodeSeat b(String str, String str2, boolean z10) {
        CloudControlConfig.CodeSeat codeSeat = null;
        try {
            codeSeat = ConfigContentHelper.g().e(str);
        } catch (Exception e11) {
            AdLogUtil.Log().e("ConfigUtil", "getConfigByAdUnit " + Log.getStackTraceString(e11));
        }
        if (codeSeat == null) {
            return codeSeat;
        }
        List<Network> networks = codeSeat.getNetworks();
        if (networks != null && !networks.isEmpty()) {
            for (Network network : networks) {
                network.setAdt(codeSeat.getCodeSeatType().intValue());
                if (network.getSource().intValue() != 1 && !AdUtil.isQueryPriceNetwork(network)) {
                    network.setPrice(Double.valueOf(network.getTempPrice()));
                }
                if (z10) {
                    AdUtil.overwriteAdmobNetworkPrice(network, str2);
                }
            }
        }
        return codeSeat;
    }
}
