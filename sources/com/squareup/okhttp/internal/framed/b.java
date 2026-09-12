package com.squareup.okhttp.internal.framed;

import okhttp3.internal.http2.Header;
import okio.ByteString;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f40417d = ByteString.encodeUtf8(Header.RESPONSE_STATUS_UTF8);

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f40418e = ByteString.encodeUtf8(Header.TARGET_METHOD_UTF8);

    /* renamed from: f, reason: collision with root package name */
    public static final ByteString f40419f = ByteString.encodeUtf8(Header.TARGET_PATH_UTF8);

    /* renamed from: g, reason: collision with root package name */
    public static final ByteString f40420g = ByteString.encodeUtf8(Header.TARGET_SCHEME_UTF8);

    /* renamed from: h, reason: collision with root package name */
    public static final ByteString f40421h = ByteString.encodeUtf8(Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: i, reason: collision with root package name */
    public static final ByteString f40422i = ByteString.encodeUtf8(":host");

    /* renamed from: j, reason: collision with root package name */
    public static final ByteString f40423j = ByteString.encodeUtf8(":version");

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f40424a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteString f40425b;

    /* renamed from: c, reason: collision with root package name */
    final int f40426c;

    public b(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public b(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public b(ByteString byteString, ByteString byteString2) {
        this.f40424a = byteString;
        this.f40425b = byteString2;
        this.f40426c = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f40424a.equals(bVar.f40424a) && this.f40425b.equals(bVar.f40425b);
    }

    public int hashCode() {
        return ((527 + this.f40424a.hashCode()) * 31) + this.f40425b.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", this.f40424a.utf8(), this.f40425b.utf8());
    }
}
