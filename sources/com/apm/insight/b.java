package com.apm.insight;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class b implements ICrashCallback, IOOMCallback {

    /* renamed from: a, reason: collision with root package name */
    private IOOMCallback f19404a;

    /* renamed from: b, reason: collision with root package name */
    private ICrashCallback f19405b;

    /* renamed from: c, reason: collision with root package name */
    private String f19406c;

    public b(String str, ICrashCallback iCrashCallback) {
        this.f19406c = str;
        this.f19405b = iCrashCallback;
    }

    public b(String str, IOOMCallback iOOMCallback) {
        this.f19406c = str;
        this.f19404a = iOOMCallback;
    }

    public final void a(@NonNull CrashType crashType, @Nullable String str, @Nullable String str2, String str3) {
        d a11;
        if (this.f19405b == null || (a11 = d.a(this.f19406c)) == null || !a11.a(str3, str2)) {
            return;
        }
        this.f19405b.onCrash(crashType, str, null);
    }

    public final void a(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread, JSONArray jSONArray) {
        if (this.f19405b == null || jSONArray == null) {
            return;
        }
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            if (TextUtils.equals(a.a(jSONArray.optJSONObject(i11), "header", "aid"), this.f19406c)) {
                this.f19405b.onCrash(crashType, str, thread);
            }
        }
    }

    public final void a(@NonNull CrashType crashType, @Nullable Throwable th2, @Nullable Thread thread, long j11, JSONArray jSONArray) {
        if (this.f19404a == null || jSONArray == null) {
            return;
        }
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            if (TextUtils.equals(a.a(jSONArray.optJSONObject(i11), "header", "aid"), this.f19406c)) {
                this.f19404a.onCrash(crashType, th2, thread, j11);
            }
        }
    }

    @Override // com.apm.insight.ICrashCallback
    public final void onCrash(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread) {
    }

    @Override // com.apm.insight.IOOMCallback
    public final void onCrash(@NonNull CrashType crashType, @Nullable Throwable th2, @Nullable Thread thread, long j11) {
    }
}
