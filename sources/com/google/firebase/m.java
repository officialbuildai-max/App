package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final String f32005a;

    /* renamed from: b, reason: collision with root package name */
    private final String f32006b;

    /* renamed from: c, reason: collision with root package name */
    private final String f32007c;

    /* renamed from: d, reason: collision with root package name */
    private final String f32008d;

    /* renamed from: e, reason: collision with root package name */
    private final String f32009e;

    /* renamed from: f, reason: collision with root package name */
    private final String f32010f;

    /* renamed from: g, reason: collision with root package name */
    private final String f32011g;

    private m(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.f32006b = str;
        this.f32005a = str2;
        this.f32007c = str3;
        this.f32008d = str4;
        this.f32009e = str5;
        this.f32010f = str6;
        this.f32011g = str7;
    }

    public static m a(Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new m(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    public String b() {
        return this.f32005a;
    }

    public String c() {
        return this.f32006b;
    }

    public String d() {
        return this.f32009e;
    }

    public String e() {
        return this.f32011g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return Objects.equal(this.f32006b, mVar.f32006b) && Objects.equal(this.f32005a, mVar.f32005a) && Objects.equal(this.f32007c, mVar.f32007c) && Objects.equal(this.f32008d, mVar.f32008d) && Objects.equal(this.f32009e, mVar.f32009e) && Objects.equal(this.f32010f, mVar.f32010f) && Objects.equal(this.f32011g, mVar.f32011g);
    }

    public int hashCode() {
        return Objects.hashCode(this.f32006b, this.f32005a, this.f32007c, this.f32008d, this.f32009e, this.f32010f, this.f32011g);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.f32006b).add("apiKey", this.f32005a).add("databaseUrl", this.f32007c).add("gcmSenderId", this.f32009e).add("storageBucket", this.f32010f).add("projectId", this.f32011g).toString();
    }
}
