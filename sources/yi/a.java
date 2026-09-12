package yi;

import android.os.Bundle;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.data.athena;
import com.transsion.athena.taaneh.aethna;
import com.transsion.ga.AthenaAnalytics;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final TrackData f79142a;

    /* renamed from: b, reason: collision with root package name */
    private String f79143b;

    /* renamed from: c, reason: collision with root package name */
    private long f79144c;

    public a(String str) {
        long b11 = athena.b();
        this.f79144c = b11;
        if (b11 == 0) {
            aethna.b("FAILED! You should init Athena first before track the event " + str);
        }
        this.f79143b = str;
        this.f79142a = new TrackData();
    }

    public a(String str, int i11) {
        this.f79144c = i11;
        this.f79143b = str;
        this.f79142a = new TrackData();
    }

    private void a(String str, Bundle bundle) {
        if (bundle != null) {
            this.f79142a.add(str, bundle);
        }
    }

    public void b() {
        AthenaAnalytics.L(this.f79144c).h0(this.f79143b, this.f79142a, this.f79144c);
    }

    public a c(Bundle bundle, Bundle bundle2) {
        a("eparam", bundle);
        a("ext", bundle2);
        return this;
    }
}
