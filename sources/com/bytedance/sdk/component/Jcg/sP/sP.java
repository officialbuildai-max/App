package com.bytedance.sdk.component.Jcg.sP;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.sP.Sj.Fmk;
import com.bytedance.sdk.component.sP.Sj.Jcg;
import com.bytedance.sdk.component.sP.Sj.Sj;
import com.bytedance.sdk.component.sP.Sj.Ym;
import com.bytedance.sdk.component.sP.Sj.Zq;
import com.bytedance.sdk.component.sP.Sj.uvD;
import com.bytedance.sdk.component.sP.Sj.vS;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class sP extends TKC {
    public static final com.bytedance.sdk.component.sP.Sj.Sj Sj = new Sj.C0234Sj().Sj().sP();
    public static final com.bytedance.sdk.component.sP.Sj.Sj sP = new Sj.C0234Sj().sP();
    private com.bytedance.sdk.component.sP.Sj.Sj TEQ;
    private boolean Ym;

    /* renamed from: aa, reason: collision with root package name */
    private Map<String, String> f20947aa;

    public sP(Ym ym2) {
        super(ym2);
        this.TEQ = Sj;
        this.Ym = false;
        this.f20947aa = new HashMap();
    }

    public com.bytedance.sdk.component.Jcg.sP Sj() {
        try {
            Fmk.Sj sj2 = new Fmk.Sj();
            if (this.Ym) {
                sj2.sP(this.Dq);
            } else {
                Jcg.Sj sj3 = new Jcg.Sj();
                Uri parse = Uri.parse(this.Dq);
                sj3.Sj(parse.getScheme());
                sj3.sP(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    sj3.TKC(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.f20947aa.put(str, parse.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.f20947aa.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String encode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        sj3.Sj(encode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                sj2.Sj(sj3.sP());
            }
            Sj(sj2);
            sj2.Sj(this.TEQ);
            sj2.Sj((Object) TKC());
            Zq sP2 = this.TKC.Sj(sj2.Sj().sP()).sP();
            if (sP2 == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            vS Jcg = sP2.Jcg();
            if (Jcg != null) {
                for (int i11 = 0; i11 < Jcg.Sj(); i11++) {
                    hashMap.put(Jcg.Sj(i11), Jcg.sP(i11));
                }
            }
            uvD vS = sP2.vS();
            return new com.bytedance.sdk.component.Jcg.sP(sP2.EjP(), sP2.TKC(), sP2.HiB(), hashMap, vS != null ? vS.sP() : "", sP2.sP(), sP2.Sj());
        } catch (Throwable unused) {
            return null;
        }
    }

    public void Sj(final com.bytedance.sdk.component.Jcg.Sj.Sj sj2) {
        try {
            Fmk.Sj sj3 = new Fmk.Sj();
            if (this.Ym) {
                sj3.sP(this.Dq);
            } else {
                Jcg.Sj sj4 = new Jcg.Sj();
                Uri parse = Uri.parse(this.Dq);
                sj4.Sj(parse.getScheme());
                sj4.sP(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    sj4.TKC(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.f20947aa.put(str, parse.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.f20947aa.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String encode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        sj4.Sj(encode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                sj3.Sj(sj4.sP());
            }
            Sj(sj3);
            sj3.Sj(this.TEQ);
            sj3.Sj((Object) TKC());
            if (!TextUtils.isEmpty(this.HiB)) {
                sj3.Sj(this.HiB);
            }
            int i11 = this.vS;
            if (i11 > 0) {
                sj3.Sj(i11);
            }
            this.TKC.Sj(sj3.Sj().sP()).Sj(new com.bytedance.sdk.component.sP.Sj.TKC() { // from class: com.bytedance.sdk.component.Jcg.sP.sP.1
                @Override // com.bytedance.sdk.component.sP.Sj.TKC
                public void Sj(com.bytedance.sdk.component.sP.Sj.sP sPVar, Zq zq2) throws IOException {
                    if (sj2 != null) {
                        HashMap hashMap = new HashMap();
                        if (zq2 != null) {
                            vS Jcg = zq2.Jcg();
                            if (Jcg != null) {
                                for (int i12 = 0; i12 < Jcg.Sj(); i12++) {
                                    hashMap.put(Jcg.Sj(i12), Jcg.sP(i12));
                                }
                            }
                            uvD vS = zq2.vS();
                            sj2.Sj(sP.this, new com.bytedance.sdk.component.Jcg.sP(zq2.EjP(), zq2.TKC(), zq2.HiB(), hashMap, vS == null ? "" : vS.sP(), zq2.sP(), zq2.Sj()));
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.sP.Sj.TKC
                public void Sj(com.bytedance.sdk.component.sP.Sj.sP sPVar, IOException iOException) {
                    com.bytedance.sdk.component.Jcg.Sj.Sj sj5 = sj2;
                    if (sj5 != null) {
                        sj5.Sj(sP.this, iOException);
                    }
                }
            });
        } catch (Throwable th2) {
            if (sj2 != null) {
                sj2.Sj(this, new IOException(th2.getMessage()));
            }
        }
    }

    public void Sj(boolean z10) {
        this.Ym = z10;
    }
}
