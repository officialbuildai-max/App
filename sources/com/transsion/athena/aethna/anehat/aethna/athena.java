package com.transsion.athena.aethna.anehat.aethna;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.athena.anateh.anehat;
import com.transsion.athena.taaneh.aethna;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.ga.anateh;
import com.transsion.ga.i;
import java.io.File;

/* loaded from: classes5.dex */
public class athena {

    /* renamed from: a, reason: collision with root package name */
    private static volatile athena f42598a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f42599b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f42600c;

    /* renamed from: d, reason: collision with root package name */
    private String f42601d;

    /* renamed from: e, reason: collision with root package name */
    private String f42602e;

    private athena() {
    }

    private boolean a() {
        if (!this.f42600c) {
            File file = new File(this.f42601d);
            try {
                if (file.exists()) {
                    this.f42600c = true;
                } else {
                    this.f42600c = file.mkdirs();
                }
            } catch (Exception e11) {
                aethna.b(Log.getStackTraceString(e11));
            }
        }
        return this.f42600c;
    }

    public static athena b() {
        if (f42598a == null) {
            synchronized (athena.class) {
                try {
                    if (f42598a == null) {
                        f42598a = new athena();
                    }
                } finally {
                }
            }
        }
        return f42598a;
    }

    public void a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AthenaAnalytics.J().getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        this.f42601d = sb2.toString();
        if (!a()) {
            this.f42601d = AthenaAnalytics.J().getFilesDir().getPath();
        }
        this.f42602e = this.f42601d + str2 + "remote_config.cfg";
    }

    public void a(byte[] bArr) {
        this.f42599b = bArr;
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(this.f42601d) && a()) {
            File file = new File(this.f42602e);
            try {
                anehat.a(file, str, this.f42599b);
            } catch (Exception e11) {
                i.a().c(new anateh("bufferSave", e11));
                try {
                    if (file.isDirectory()) {
                        com.transsion.athena.taaneh.athena.a(AthenaAnalytics.J(), this.f42602e);
                    }
                } catch (Exception unused) {
                    e11.printStackTrace();
                }
            }
        }
    }

    @Nullable
    public String c() {
        if (!TextUtils.isEmpty(this.f42601d) && a()) {
            File file = new File(this.f42602e);
            try {
                return anehat.a(file, this.f42599b);
            } catch (Exception e11) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("e", e11.getClass().getSimpleName());
                    bundle.putString("pwd", com.transsion.athena.config.data.model.anehat.c(this.f42599b));
                    bundle.putLong("len", file.length());
                    i.a().c(new anateh("bufferRead", bundle));
                    com.transsion.athena.taaneh.athena.b(AthenaAnalytics.J(), file);
                } catch (Exception unused) {
                    e11.printStackTrace();
                }
            }
        }
        return null;
    }
}
