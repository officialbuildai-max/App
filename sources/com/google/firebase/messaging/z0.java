package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
final class z0 {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f32245d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a, reason: collision with root package name */
    private final String f32246a;

    /* renamed from: b, reason: collision with root package name */
    private final String f32247b;

    /* renamed from: c, reason: collision with root package name */
    private final String f32248c;

    private z0(String str, String str2) {
        this.f32246a = d(str2, str);
        this.f32247b = str;
        this.f32248c = str + "!" + str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new z0(split[0], split[1]);
    }

    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str == null || !f32245d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public static z0 f(String str) {
        return new z0("S", str);
    }

    public static z0 g(String str) {
        return new z0("U", str);
    }

    public String b() {
        return this.f32247b;
    }

    public String c() {
        return this.f32246a;
    }

    public String e() {
        return this.f32248c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof z0)) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return this.f32246a.equals(z0Var.f32246a) && this.f32247b.equals(z0Var.f32247b);
    }

    public int hashCode() {
        return Objects.hashCode(this.f32247b, this.f32246a);
    }
}
