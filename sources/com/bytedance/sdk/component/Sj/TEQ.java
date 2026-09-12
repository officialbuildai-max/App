package com.bytedance.sdk.component.Sj;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.Sj.Ym;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class TEQ {
    boolean Dq;
    Dq EjP;
    Context HiB;
    boolean Jcg;
    WebView Sj;
    sef TEQ;
    boolean Zq;
    Sj sP;
    boolean sef;
    Fmk uA;
    Ym.Sj uvD;
    boolean vS;
    String TKC = "IESJSBridge";
    String Ym = "host";

    /* renamed from: aa, reason: collision with root package name */
    final Set<String> f20949aa = new LinkedHashSet();
    final Set<String> Fmk = new LinkedHashSet();

    TEQ() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TEQ(WebView webView) {
        this.Sj = webView;
    }

    private void TKC() {
        if ((this.Sj == null && !this.sef && this.sP == null) || ((TextUtils.isEmpty(this.TKC) && this.Sj != null) || this.EjP == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public TEQ Sj() {
        this.Zq = true;
        return this;
    }

    public TEQ Sj(Sj sj2) {
        this.sP = sj2;
        return this;
    }

    public TEQ Sj(aa aaVar) {
        this.EjP = Dq.Sj(aaVar);
        return this;
    }

    public TEQ Sj(String str) {
        this.TKC = str;
        return this;
    }

    public TEQ Sj(boolean z10) {
        this.vS = z10;
        return this;
    }

    public TEQ sP(boolean z10) {
        this.Jcg = z10;
        return this;
    }

    public dNu sP() {
        TKC();
        return new dNu(this);
    }
}
