package h6;

import android.text.TextUtils;
import com.bytedance.sdk.component.sP.Sj.Fmk;
import com.bytedance.sdk.component.sP.Sj.Ym;
import com.bytedance.sdk.component.sP.Sj.Zq;
import java.util.Map;

/* loaded from: classes3.dex */
public class a implements e {

    /* renamed from: a, reason: collision with root package name */
    private Ym f64494a;

    public a() {
        this.f64494a = null;
        this.f64494a = t5.b.a();
    }

    @Override // h6.e
    public c a(b bVar) {
        Fmk.Sj sj2 = new Fmk.Sj();
        try {
            Map map = bVar.f64499e;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = (String) entry.getValue();
                        if (str2 == null) {
                            str2 = "";
                        }
                        sj2.sP(str, str2);
                    }
                }
            }
            Zq sP = this.f64494a.Sj(sj2.sP(bVar.f64496b).Sj().Sj("videoPreloadLowVersion").Sj(6).sP()).sP();
            sP.TKC();
            return new f(sP, bVar);
        } catch (Throwable unused) {
            return null;
        }
    }
}
