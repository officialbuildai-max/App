package androidx.profileinstaller;

import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f14150a = {48, 49, 53, 0};

    /* renamed from: b, reason: collision with root package name */
    static final byte[] f14151b = {48, 49, 48, 0};

    /* renamed from: c, reason: collision with root package name */
    static final byte[] f14152c = {48, 48, 57, 0};

    /* renamed from: d, reason: collision with root package name */
    static final byte[] f14153d = {48, 48, 53, 0};

    /* renamed from: e, reason: collision with root package name */
    static final byte[] f14154e = {48, 48, 49, 0};

    /* renamed from: f, reason: collision with root package name */
    static final byte[] f14155f = {48, 48, 49, 0};

    /* renamed from: g, reason: collision with root package name */
    static final byte[] f14156g = {48, 48, 50, 0};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(byte[] bArr) {
        return (Arrays.equals(bArr, f14154e) || Arrays.equals(bArr, f14153d)) ? ":" : "!";
    }
}
