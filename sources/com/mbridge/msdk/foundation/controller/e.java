package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: classes5.dex */
public class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private String f35109a = "";

    /* renamed from: b, reason: collision with root package name */
    private String f35110b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f35111c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f35112d = "";

    /* renamed from: e, reason: collision with root package name */
    private int f35113e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f35114f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f35115g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f35116h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f35117i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f35118j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f35119k;

    /* renamed from: l, reason: collision with root package name */
    private a f35120l;

    /* renamed from: m, reason: collision with root package name */
    private final SharedPreferences f35121m;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public e(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        this.f35121m = defaultSharedPreferences;
        if (defaultSharedPreferences != null) {
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        a();
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f35121m;
        if (sharedPreferences != null) {
            d(sharedPreferences.getString("IABTCF_TCString", ""));
            a(this.f35121m.getInt("IABTCF_gdprApplies", 0));
            c(this.f35121m.getString("IABTCF_PurposeConsents", ""));
            e(this.f35121m.getString("IABTCF_VendorConsents", ""));
            b(this.f35121m.getString("IABTCF_AddtlConsent", ""));
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[01]+");
    }

    private boolean a(String str, int i11) {
        return a(str) && i11 <= str.length() && i11 >= 1 && '1' == str.charAt(i11 - 1);
    }

    public void a(int i11) {
        this.f35113e = i11;
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f35120l = aVar;
        }
    }

    public void a(boolean z10) {
        this.f35114f = z10;
    }

    public String b() {
        return this.f35109a;
    }

    public void b(String str) {
        this.f35112d = str;
        if (TextUtils.isEmpty(str)) {
            this.f35118j = true;
            return;
        }
        if (MBridgeConstans.GOOGLE_ATP_ID == -1) {
            this.f35119k = false;
            return;
        }
        this.f35119k = true;
        try {
            String[] split = str.split("~");
            if (split.length > 1) {
                if (TextUtils.isEmpty(split[1])) {
                    this.f35118j = false;
                } else {
                    this.f35118j = str.contains(String.valueOf(MBridgeConstans.GOOGLE_ATP_ID));
                }
            }
        } catch (Throwable th2) {
            o0.b("TCStringManager", th2.getMessage());
        }
    }

    public void c(String str) {
        this.f35115g = a(str, 1);
        this.f35116h = a(str, 2);
        this.f35110b = str;
    }

    public boolean c() {
        if (this.f35113e == 0) {
            a(true);
            return this.f35114f;
        }
        if (MBridgeConstans.VERIFY_ATP_CONSENT) {
            a((this.f35117i || (this.f35119k && this.f35118j)) && this.f35115g && this.f35116h);
        } else {
            a(this.f35117i && this.f35115g && this.f35116h);
        }
        return this.f35114f;
    }

    public void d(String str) {
        this.f35109a = str;
    }

    public void e(String str) {
        this.f35117i = a(str, 867);
        this.f35111c = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        char c11;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            switch (str.hashCode()) {
                case -2004976699:
                    if (str.equals("IABTCF_PurposeConsents")) {
                        c11 = 2;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 83641339:
                    if (str.equals("IABTCF_gdprApplies")) {
                        c11 = 1;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 1218895378:
                    if (str.equals("IABTCF_TCString")) {
                        c11 = 0;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 1342914771:
                    if (str.equals("IABTCF_AddtlConsent")) {
                        c11 = 4;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 1450203731:
                    if (str.equals("IABTCF_VendorConsents")) {
                        c11 = 3;
                        break;
                    }
                    c11 = 65535;
                    break;
                default:
                    c11 = 65535;
                    break;
            }
            if (c11 == 0) {
                d(sharedPreferences.getString("IABTCF_TCString", ""));
            } else if (c11 == 1) {
                a(sharedPreferences.getInt("IABTCF_gdprApplies", 0));
            } else if (c11 == 2) {
                c(sharedPreferences.getString("IABTCF_PurposeConsents", ""));
            } else if (c11 == 3) {
                e(sharedPreferences.getString("IABTCF_VendorConsents", ""));
            } else if (c11 == 4) {
                b(sharedPreferences.getString("IABTCF_AddtlConsent", ""));
            }
            a aVar = this.f35120l;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th2) {
            o0.b("TCStringManager", th2.getMessage());
        }
    }
}
