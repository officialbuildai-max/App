package be;

import android.text.TextUtils;
import com.hisavana.common.base.LogSwitch;
import com.hisavana.common.bean.Network;
import com.hisavana.common.mock.RecordTestInfo;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f16434a = new HashMap();

    public Network a(String str) {
        return c(str);
    }

    public boolean b(String str, Network network) {
        if (network == null) {
            return false;
        }
        Network c11 = c(str);
        double doubleValue = c11 != null ? c11.getPrice().doubleValue() : 0.0d;
        if (doubleValue > 0.0d && doubleValue > network.getPrice().doubleValue()) {
            return false;
        }
        d(str, network);
        if (!LogSwitch.isDebug) {
            return true;
        }
        RecordTestInfo.LogMsg("add price cache:" + RecordTestInfo.getLogMsg(network), RecordTestInfo.LOG_CODE11);
        return true;
    }

    public final Network c(String str) {
        Network network;
        if (TextUtils.isEmpty(str) || (network = (Network) this.f16434a.get(str)) == null) {
            return null;
        }
        if (network.getBidInfo() != null && !network.getBidInfo().isExpired()) {
            return network;
        }
        this.f16434a.remove(str);
        return null;
    }

    public final void d(String str, Network network) {
        if (TextUtils.isEmpty(str) || network == null) {
            return;
        }
        this.f16434a.put(str, network);
    }
}
