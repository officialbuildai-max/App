package com.bytedance.sdk.openadsdk.core.Ym.TKC;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TKC {

    @NonNull
    private final List<String> Sj;

    @NonNull
    private final Map<sP, String> sP;

    public TKC(@NonNull List<String> list) {
        this.Sj = list;
        HashMap hashMap = new HashMap();
        this.sP = hashMap;
        hashMap.put(sP.CACHEBUSTING, sP());
    }

    @NonNull
    private String sP() {
        return String.format(Locale.US, "%08d", Long.valueOf(Math.round(Math.random() * 1.0E8d)));
    }

    @NonNull
    private String sP(long j11) {
        Locale locale = Locale.getDefault();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format(locale, "%02d:%02d:%02d.%03d", Long.valueOf(timeUnit.toHours(j11)), Long.valueOf(timeUnit.toMinutes(j11) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(timeUnit.toSeconds(j11) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j11 % 1000));
    }

    @NonNull
    public TKC Sj(@Nullable long j11) {
        if (j11 >= 0) {
            String sP = sP(j11);
            if (!TextUtils.isEmpty(sP)) {
                this.sP.put(sP.CONTENTPLAYHEAD, sP);
            }
        }
        return this;
    }

    @NonNull
    public TKC Sj(@Nullable com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj sj2) {
        if (sj2 != null) {
            this.sP.put(sP.ERRORCODE, sj2.Sj());
        }
        return this;
    }

    @NonNull
    public TKC Sj(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, "UTF-8");
            } catch (Throwable unused) {
            }
            this.sP.put(sP.ASSETURI, str);
        }
        return this;
    }

    @NonNull
    public List<String> Sj() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.Sj) {
            if (!TextUtils.isEmpty(str)) {
                for (sP sPVar : sP.values()) {
                    String str2 = this.sP.get(sPVar);
                    if (str2 == null) {
                        str2 = "";
                    }
                    str = str.replaceAll("\\[" + sPVar.name() + "\\]", str2);
                }
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
