package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.y;
import com.google.android.exoplayer2.util.p0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f26490a;

    /* renamed from: b, reason: collision with root package name */
    public final String f26491b;

    /* renamed from: c, reason: collision with root package name */
    public final String f26492c;

    /* renamed from: d, reason: collision with root package name */
    public final String f26493d;

    public l(int i11, String str, String str2, String str3) {
        this.f26490a = i11;
        this.f26491b = str;
        this.f26492c = str2;
        this.f26493d = str3;
    }

    private String b(y.a aVar) {
        String str = aVar.f26573a;
        String str2 = aVar.f26574b;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(":");
        sb2.append(str2);
        return Base64.encodeToString(y.c(sb2.toString()), 0);
    }

    private String c(y.a aVar, Uri uri, int i11) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String s11 = y.s(i11);
            String str = aVar.f26573a;
            String str2 = this.f26491b;
            String str3 = aVar.f26574b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length() + String.valueOf(str3).length());
            sb2.append(str);
            sb2.append(":");
            sb2.append(str2);
            sb2.append(":");
            sb2.append(str3);
            String Z0 = p0.Z0(messageDigest.digest(y.c(sb2.toString())));
            String valueOf = String.valueOf(uri);
            StringBuilder sb3 = new StringBuilder(String.valueOf(s11).length() + 1 + valueOf.length());
            sb3.append(s11);
            sb3.append(":");
            sb3.append(valueOf);
            String Z02 = p0.Z0(messageDigest.digest(y.c(sb3.toString())));
            String str4 = this.f26492c;
            StringBuilder sb4 = new StringBuilder(String.valueOf(Z0).length() + 2 + String.valueOf(str4).length() + String.valueOf(Z02).length());
            sb4.append(Z0);
            sb4.append(":");
            sb4.append(str4);
            sb4.append(":");
            sb4.append(Z02);
            String Z03 = p0.Z0(messageDigest.digest(y.c(sb4.toString())));
            return this.f26493d.isEmpty() ? p0.C("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\"", aVar.f26573a, this.f26491b, this.f26492c, uri, Z03) : p0.C("Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\", opaque=\"%s\"", aVar.f26573a, this.f26491b, this.f26492c, uri, Z03, this.f26493d);
        } catch (NoSuchAlgorithmException e11) {
            throw ParserException.createForManifestWithUnsupportedFeature(null, e11);
        }
    }

    public String a(y.a aVar, Uri uri, int i11) {
        int i12 = this.f26490a;
        if (i12 == 1) {
            return b(aVar);
        }
        if (i12 == 2) {
            return c(aVar, uri, i11);
        }
        throw ParserException.createForManifestWithUnsupportedFeature(null, new UnsupportedOperationException());
    }
}
