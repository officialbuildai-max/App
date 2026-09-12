package com.transsion.transfer.androidasync.http;

import android.text.TextUtils;
import com.cloud.tmc.kernel.utils.UrlUtils;

/* loaded from: classes6.dex */
public class u implements w, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private final String f55641a;

    /* renamed from: b, reason: collision with root package name */
    private final String f55642b;

    public u(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f55641a = str;
        this.f55642b = str2;
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f55641a.equals(uVar.f55641a) && TextUtils.equals(this.f55642b, uVar.f55642b);
    }

    @Override // com.transsion.transfer.androidasync.http.w
    public String getName() {
        return this.f55641a;
    }

    @Override // com.transsion.transfer.androidasync.http.w
    public String getValue() {
        return this.f55642b;
    }

    public int hashCode() {
        return this.f55641a.hashCode() ^ this.f55642b.hashCode();
    }

    public String toString() {
        return this.f55641a + UrlUtils.EQUAL_MARK + this.f55642b;
    }
}
