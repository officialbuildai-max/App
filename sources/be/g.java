package be;

import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public static final String f16474b = "g";

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f16475a;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final g f16476a = new g();
    }

    public g() {
        this.f16475a = new ConcurrentHashMap();
    }

    public static g d() {
        return b.f16476a;
    }

    public CloudControlConfig.CodeSeat a(String str) {
        try {
            CloudControlConfig.CodeSeat codeSeat = (CloudControlConfig.CodeSeat) this.f16475a.get(str);
            if (codeSeat != null) {
                return codeSeat;
            }
            AdLogUtil.Log().d(f16474b, "getCodeSeat value is null");
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void b() {
        AdLogUtil.Log().d(f16474b, "clearCache");
        this.f16475a.clear();
    }

    public void c(List list) {
        if (list == null) {
            return;
        }
        try {
            b();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CloudControlConfig.CodeSeat codeSeat = (CloudControlConfig.CodeSeat) it.next();
                this.f16475a.put(codeSeat.getCodeSeatId(), codeSeat);
            }
        } catch (Exception unused) {
            AdLogUtil.Log().d(f16474b, "update code seat error");
        }
    }
}
