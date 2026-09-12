package com.google.android.datatransport.cct;

import com.google.android.datatransport.runtime.g;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class a implements g {

    /* renamed from: c, reason: collision with root package name */
    static final String f24233c;

    /* renamed from: d, reason: collision with root package name */
    static final String f24234d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f24235e;

    /* renamed from: f, reason: collision with root package name */
    private static final Set f24236f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f24237g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f24238h;

    /* renamed from: a, reason: collision with root package name */
    private final String f24239a;

    /* renamed from: b, reason: collision with root package name */
    private final String f24240b;

    static {
        String a11 = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f24233c = a11;
        String a12 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f24234d = a12;
        String a13 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f24235e = a13;
        f24236f = Collections.unmodifiableSet(new HashSet(Arrays.asList(r8.c.b("proto"), r8.c.b("json"))));
        f24237g = new a(a11, null);
        f24238h = new a(a12, a13);
    }

    public a(String str, String str2) {
        this.f24239a = str;
        this.f24240b = str2;
    }

    public static a c(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
        if (split.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = split[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }

    @Override // com.google.android.datatransport.runtime.g
    public Set a() {
        return f24236f;
    }

    public byte[] b() {
        String str = this.f24240b;
        if (str == null && this.f24239a == null) {
            return null;
        }
        String str2 = this.f24239a;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", "1$", str2, "\\", str).getBytes(Charset.forName("UTF-8"));
    }

    public String d() {
        return this.f24240b;
    }

    public String e() {
        return this.f24239a;
    }

    @Override // com.google.android.datatransport.runtime.f
    public byte[] getExtras() {
        return b();
    }

    @Override // com.google.android.datatransport.runtime.f
    public String getName() {
        return "cct";
    }
}
