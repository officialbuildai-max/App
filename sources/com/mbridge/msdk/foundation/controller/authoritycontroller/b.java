package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.e;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.OnCompletionListener;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f35073h = true;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f35074i = true;

    /* renamed from: b, reason: collision with root package name */
    protected AuthorityInfoBean f35076b;

    /* renamed from: g, reason: collision with root package name */
    private e f35081g;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<String> f35075a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private int f35077c = 3;

    /* renamed from: d, reason: collision with root package name */
    private int f35078d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f35079e = 0;

    /* renamed from: f, reason: collision with root package name */
    private String f35080f = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f35082a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OnCompletionListener f35083b;

        a(Context context, OnCompletionListener onCompletionListener) {
            this.f35082a = context;
            this.f35083b = onCompletionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f35082a);
            this.f35083b.onCompletion();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.foundation.controller.authoritycontroller.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0482b implements e.a {
        C0482b() {
        }

        @Override // com.mbridge.msdk.foundation.controller.e.a
        public void a() {
            b.this.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        try {
            if (this.f35081g == null) {
                e eVar = new e(context);
                this.f35081g = eVar;
                eVar.a(new C0482b());
            }
            k();
        } catch (Throwable th2) {
            o0.b("SDKAuthorityController", th2.getMessage());
        }
    }

    public static void a(boolean z10) {
        f35073h = z10;
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f35080f = str;
    }

    public static void b(boolean z10) {
        f35074i = z10;
    }

    private void d(int i11) {
        this.f35077c = i11 != 1 ? 2 : 1;
    }

    public static boolean i() {
        return f35073h;
    }

    public static boolean j() {
        return f35074i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        boolean c11 = this.f35081g.c();
        b(this.f35081g.b());
        d(c11 ? 1 : 2);
        this.f35076b.authDeviceIdStatus(c11 ? 1 : 0);
    }

    protected abstract int a(g gVar, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(String str) {
        AuthorityInfoBean authorityInfoBean;
        try {
            if (TextUtils.isEmpty(str) || (authorityInfoBean = this.f35076b) == null) {
                return 0;
            }
            return authorityInfoBean.getStatusByKey(str);
        } catch (Exception e11) {
            o0.b("SDKAuthorityController", e11.getMessage());
            return 0;
        }
    }

    public AuthorityInfoBean a() {
        AuthorityInfoBean authorityInfoBean = this.f35076b;
        if (authorityInfoBean != null) {
            return authorityInfoBean;
        }
        AuthorityInfoBean authorityInfoBean2 = new AuthorityInfoBean();
        authorityInfoBean2.a(1);
        return authorityInfoBean2;
    }

    public void a(int i11) {
        this.f35077c = i11 != 1 ? 2 : 1;
        if (this.f35076b != null) {
            d(i11);
        }
    }

    public void a(Context context, OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new a(context, onCompletionListener));
        } else {
            a(context);
        }
    }

    public void a(String str, int i11) {
        if (TextUtils.isEmpty(str) || this.f35076b == null) {
            return;
        }
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1262204598:
                if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1133763064:
                if (str.equals(MBridgeConstans.AUTHORITY_ALL_INFO)) {
                    c11 = 1;
                    break;
                }
                break;
            case -663505496:
                if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                    c11 = 2;
                    break;
                }
                break;
            case 1026848797:
                if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                    c11 = 3;
                    break;
                }
                break;
            case 1564683028:
                if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                this.f35076b.authSerialIdStatus(i11);
                return;
            case 1:
                this.f35076b.a(i11);
                return;
            case 2:
                this.f35076b.authDeviceIdStatus(i11);
                return;
            case 3:
                this.f35076b.authGenDataStatus(i11);
                return;
            case 4:
                this.f35076b.authOtherDataStatus(i11);
                return;
            default:
                return;
        }
    }

    public void b(int i11) {
        this.f35078d = i11;
    }

    public boolean b() {
        int i11 = this.f35077c;
        return i11 == 1 || i11 == 3;
    }

    public int c() {
        return this.f35078d;
    }

    public void c(int i11) {
        this.f35079e = i11;
    }

    public int d() {
        return this.f35079e;
    }

    public int e() {
        return this.f35077c;
    }

    public String f() {
        return this.f35080f;
    }

    public String g() {
        JSONArray jSONArray = new JSONArray();
        g c11 = h.b().c();
        for (int i11 = 0; i11 < this.f35075a.size(); i11++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("keyname", String.valueOf(this.f35075a.get(i11)));
                jSONObject.put("client_status", a(this.f35075a.get(i11)));
                jSONObject.put("server_status", a(c11, this.f35075a.get(i11)));
                jSONArray.put(jSONObject);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        AuthorityInfoBean authorityInfoBean = new AuthorityInfoBean();
        this.f35076b = authorityInfoBean;
        try {
            authorityInfoBean.authGenDataStatus(1);
            this.f35076b.authDeviceIdStatus(1);
            this.f35076b.authSerialIdStatus(1);
            this.f35076b.authOtherDataStatus(1);
            this.f35075a.add(MBridgeConstans.AUTHORITY_GENERAL_DATA);
            this.f35075a.add(MBridgeConstans.AUTHORITY_DEVICE_ID);
            this.f35075a.add(MBridgeConstans.AUTHORITY_SERIAL_ID);
            this.f35075a.add(MBridgeConstans.AUTHORITY_OTHER);
        } catch (Exception e11) {
            o0.b("SDKAuthorityController", e11.getMessage());
        }
    }
}
