package am;

import android.content.Context;
import com.transsion.http.d.h;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes5.dex */
public class d extends c {

    /* renamed from: l, reason: collision with root package name */
    private boolean f751l;

    /* renamed from: m, reason: collision with root package name */
    private Context f752m;

    public d(Context context, String str, boolean z10, Object obj, h hVar, Map map, boolean z11, int i11, int i12, boolean z12, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        super(str, obj, hVar, map, z11, i11, i12, z12, sSLSocketFactory, hostnameVerifier);
        this.f751l = z10;
        this.f752m = context;
        bm.a.f16706a.d("image", "origin image url:" + str);
    }

    @Override // am.c
    protected e b() {
        return this.f750k.m(this.f751l).c(this.f752m).j();
    }
}
